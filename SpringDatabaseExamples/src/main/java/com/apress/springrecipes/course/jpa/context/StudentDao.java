package com.apress.springrecipes.course.jpa.context;

import java.util.List;

public interface StudentDao<Student> {

	public void delete(Long courseId);

	public void store(Student course);

	public Student findById(Long courseId);

	public List<Student> findAll();


}
