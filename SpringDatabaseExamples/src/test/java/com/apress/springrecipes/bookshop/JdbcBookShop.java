package com.apress.springrecipes.bookshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public class JdbcBookShop //extends JdbcDaoSupport 
implements BookShop {
	private DataSource dataSource;
	
    /*@Transactional(
            propagation = Propagation.REQUIRES_NEW,
            rollbackFor = IOException.class,
            noRollbackFor = ArithmeticException.class)*/
	
    

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void purchase(String isbn, String username) {
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement stmnt1 = conn.prepareStatement("select price from Book where ISBN = ?");
			stmnt1.setString(1, isbn);
			ResultSet rs = stmnt1.executeQuery();
			rs.next();
			int price = rs.getInt("PRICE");
			stmnt1.close();
			
			
			PreparedStatement stmnt2 = conn.prepareStatement("UPDATE BOOK_STOCK SET STOCK = STOCK - 1 " +
	                "WHERE ISBN = ?");
			stmnt2.setString(1, isbn);
			stmnt2.executeUpdate();
			stmnt2.close();
			
			PreparedStatement stmnt3 = conn.prepareStatement("UPDATE ACCOUNT SET BALANCE = BALANCE - ? " +
	                "WHERE USERNAME = ?");
			stmnt3.setInt(1, price);
			stmnt3.setString(2, username);
			stmnt3.executeUpdate();
			stmnt3.close();			
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			if( conn !=null ){
				try{
					conn.close();
				}catch(SQLException e){}
			}
		}
	}
		/*
        int price = getJdbcTemplate().queryForInt(
                "SELECT PRICE FROM BOOK WHERE ISBN = ?", new Object[] { isbn });

        getJdbcTemplate().update(
                "UPDATE BOOK_STOCK SET STOCK = STOCK - 1 " +
                "WHERE ISBN = ?",
                new Object[] { isbn });

        getJdbcTemplate().update(
                "UPDATE ACCOUNT SET BALANCE = BALANCE - ? " +
                "WHERE USERNAME = ?",
                new Object[] { price, username });
    }
	*/
    /*@Transactional
    public void increaseStock(String isbn, int stock) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " - Prepare to increase book stock");

        getJdbcTemplate().update(
                "UPDATE BOOK_STOCK SET STOCK = STOCK + ? " +
                "WHERE ISBN = ?",
                new Object[] { stock, isbn });

        System.out.println(threadName + " - Book stock increased by " + stock);
        sleep(threadName);

        System.out.println(threadName + " - Book stock rolled back");
        throw new RuntimeException("Increased by mistake");
    }*/

    /*@Transactional(
            isolation = Isolation.REPEATABLE_READ,
            timeout = 30,
            readOnly = true)
    public int checkStock(String isbn) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " - Prepare to check book stock");

        int stock = getJdbcTemplate().queryForInt(
                "SELECT STOCK FROM BOOK_STOCK WHERE ISBN = ?",
                new Object[] { isbn });

        System.out.println(threadName + " - Book stock is " + stock);
        sleep(threadName);

        return stock;
    }*/

    private void sleep(String threadName) {
        System.out.println(threadName + " - Sleeping");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
        System.out.println(threadName + " - Wake up");
    }
}
