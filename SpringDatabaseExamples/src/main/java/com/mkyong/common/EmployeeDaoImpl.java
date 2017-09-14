package com.mkyong.common;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

//@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	public EmployeeDaoImpl() {
	}
	private JdbcTemplate jdbcTemplate;

    //@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	//@Override
	public void createEmployee(Employee employee) {
		this.jdbcTemplate.update(
		        "insert into Emp (Empno, Ename) values (?, ?)",new Integer(8000),"Watling");
	}

	//@Override
	public void deleteEmployee(Integer empno) {
		this.jdbcTemplate.update("delete from Emp where empno = ?",new Integer(8000));
	}
    // JDBC-backed implementations of the methods on the CorporateEventDao follow...

}
