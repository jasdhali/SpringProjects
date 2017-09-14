package com.apress.springrecipes.course.jpa.context;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apress.springrecepies.orm.entities.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao<Student> {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	private EntityManager entityManager;

	public StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public void delete(Long courseId) {
		// TODO Auto-generated method stub

	}

	@Override
	//@Transactional
	public void store(Student student) {
		entityManager.merge(student);
	}

	@Override
	public List<Student> findAll() { 
		Query query = entityManager.createQuery("from Student");
		return query.getResultList();
	}

	@Override
	public Student findById(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
