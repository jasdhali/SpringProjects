package com.mybatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.domain.Student;

public class MyBatisInsert {
	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SampleOracleConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		// Create a new student object
		Student student = new Student("Mohammad", "It", 80, 984803322,
				"Mohammad@gmail.com");

		// Insert student data
		session.insert("Student.insert", student);
		System.out.println("record inserted successfully");
		session.commit();
		session.close();
	}
}
