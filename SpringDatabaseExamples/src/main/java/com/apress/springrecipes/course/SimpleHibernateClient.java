package com.apress.springrecipes.course;
import java.util.Date;


public class SimpleHibernateClient {

	public SimpleHibernateClient() {
	}

	public static void main(String[] args) {
		CourseDAO courseDAO  = new HibernateCourseDao();
		Course course = new Course("Core spring" , new Date(), new Date(),1000);
		courseDAO.store(course);		
	}	
}
