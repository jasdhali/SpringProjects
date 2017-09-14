package com.apress.springrecipes.course.jpa;

import java.util.GregorianCalendar;

public class AnnotationBasicHibernateClient {

    public static void main(String[] args) {
        HibernateCourseDaoJPA courseDao = new HibernateCourseDaoJPA();
        
        CourseJPA course = new CourseJPA();
        course.setId(new Long(10));
        course.setTitle("Core Spring");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(100);
        for(long i=2;i<=10;i++){
        	course.setId(i);
        	courseDao.store(course);
        }
        courseDao.store(course);
        

        /*List<Course> courses = courseDao.findAll();
        Long courseId = courses.get(0).getId();

        course = courseDao.findById(courseId);
        System.out.println("Course Title: " + course.getTitle());
        System.out.println("Begin Date: " + course.getBeginDate());
        System.out.println("End Date: " + course.getEndDate());
        System.out.println("Fee: " + course.getFee());*/

        ///courseDao.delete(courseId);
    }
}
