package com.apress.springrecipes.course.jpa.context;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apress.springrecipes.course.jpa.CourseDAOJPA;
import com.apress.springrecipes.course.jpa.CourseJPA;


@Repository("courseDaoContext")
public class JpaCourseContext implements CourseDAOJPA{

	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;
	
		
	public JpaCourseContext() {}

    //@Transactional
    public void store(CourseJPA course) {
        entityManager.merge(course);
    }

    @Transactional
    public void delete(Long courseId) {
        CourseJPA course = entityManager.find(CourseJPA.class, courseId);
        entityManager.remove(course);
    }

    @Transactional(readOnly = true)
    public CourseJPA findById(Long courseId) {
        return entityManager.find(CourseJPA.class, courseId);
    }

    @Transactional(readOnly = true)
    public List<CourseJPA> findAll() {
        Query query = entityManager.createQuery("from Course");
        return query.getResultList();
    }

}
