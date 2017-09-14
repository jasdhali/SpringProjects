package com.apress.springrecipes.course.jpa;

import java.util.List;

public interface CourseDAOJPA {
	
	public void delete(Long courseId);

	public void store(CourseJPA course);

	public CourseJPA findById(Long courseId);

	public List<CourseJPA> findAll();
	
}
