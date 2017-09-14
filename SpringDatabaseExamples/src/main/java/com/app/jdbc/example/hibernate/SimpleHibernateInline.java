package com.app.jdbc.example.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class SimpleHibernateInline {
	public SimpleHibernateInline() {
	}

	public static void main(String[] args) {
		SimpleHibernateInline client = new SimpleHibernateInline();
		client.call();
	}

	public static void call() {
		System.out.println("Launching Web Service Exporter.");
		ApplicationContext context = new FileSystemXmlApplicationContext("/target/classes/hibernate-inlineDS.xml");
		LocalSessionFactoryBean  
			sessionFactoryBean = (LocalSessionFactoryBean)context.getBean("mySessionFactory");
		
		/*if( sessionFactoryBean!=null){
				SessionFactory factory = sessionFactoryBean.buildSessionFactory();
				if( factory !=null ){
					System.out.println("Session factory found");
				}
		}*/
		context = null;
	}
}
