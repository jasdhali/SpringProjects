package com.apress.springrecipes.course.jpa;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateCourseDaoJPA implements CourseDAOJPA {
	private SessionFactory sessionFactory;
	
	public HibernateCourseDaoJPA() {
		Configuration configuration = new AnnotationConfiguration().configure("/hibernate_jpa.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public void delete(Long courseId) {
		
	}


	public void store(CourseJPA course) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				//session.saveOrUpdate( course );
				session.save( course );
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			finally{
				
			}
	}

	public CourseJPA findById(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CourseJPA> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
