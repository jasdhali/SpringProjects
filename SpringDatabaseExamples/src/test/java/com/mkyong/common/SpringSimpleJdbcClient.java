package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSimpleJdbcClient {
	public SpringSimpleJdbcClient() {
	}

	public static void main(String[] args) {
		SpringSimpleJdbcClient client = new SpringSimpleJdbcClient();
		client.call();
	}

	public static void call() {
		System.out.println("Launching Web Service Exporter.");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"C:\\devenv\\eclipse_workspaces\\PracticeWorkspace\\SpringJDBCExamples\\src\\main\\resources\\spring-jdbc-beans.xml");
		com.mkyong.common.EmployeeDao employeeDao = 
					(com.mkyong.common.EmployeeDao) context.getBean("employeeDao");
		if (employeeDao != null) {
			System.out.println("data source created...");
			Employee emp = new Employee();
			emp.setEmpNo(new Integer(8000));
			employeeDao.createEmployee(emp);
		}
		context = null;
	}
}
