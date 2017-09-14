package com.apress.springrecipes.course.jpa.depinjection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import com.apress.springrecipes.course.jpa.CourseDAOJPA;
import com.apress.springrecipes.course.jpa.CourseJPA;

public class JpaCourseDaoDI implements CourseDAOJPA {
	private EntityManagerFactory entityManagerFactory;
	/*
	public JpaCourseDaoDI() {
		entityManagerFactory = Persistence.createEntityManagerFactory("course");
	}*/

	/*@Override
	public void delete(Long courseId) {	
	}*/
	
	
	public void store(CourseJPA course) {
			EntityManager manager = entityManagerFactory.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			try {
				tx.begin();
				//session.saveOrUpdate( course );
				manager.merge( course );
				tx.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			finally{
			}
	}

	public void delete(Long courseId) {
		// TODO Auto-generated method stub
		
	}

	public CourseJPA findById(Long courseId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		try {
			
			return manager.find( CourseJPA.class, courseId );
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("@@@@Successfully Found entity for ID->" + courseId );
		}
		return null;
	}

	public List<CourseJPA> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	
}
