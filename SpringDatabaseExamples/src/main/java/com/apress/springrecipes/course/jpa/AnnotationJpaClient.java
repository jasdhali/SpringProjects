package com.apress.springrecipes.course.jpa;
/**
 * Class to use JPA annotation decorated entity classes with persistence configuration
 * with hibernate as runtime.
 */
import java.util.GregorianCalendar;

public class AnnotationJpaClient {

    public static void main(String[] args) {
        CourseDAOJPA courseDao = new JpaCourseDao();
        
        CourseJPA course = new CourseJPA();
        course.setId(new Long(10));
        course.setTitle("SpringJDBC-JPA-Hib");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(100);
        for(long i=21;i<=22;i++){
        	course.setId(i);
        	courseDao.store(course);
        }
        courseDao.store(course);
        	
        CourseJPA courseJPA = courseDao.findById(new Long(14));
        System.out.println( "Found entirty properties => " + courseJPA.getTitle() );

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
