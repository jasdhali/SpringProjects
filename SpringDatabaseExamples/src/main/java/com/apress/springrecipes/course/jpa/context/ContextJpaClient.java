package com.apress.springrecipes.course.jpa.context;
/**
 * Class to use JPA annotation decorated entity classes with persistence configuration
 * with hibernate as runtime.
 */
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.springrecepies.orm.entities.Student;
import com.apress.springrecipes.course.jpa.CourseDAOJPA;
import com.apress.springrecipes.course.jpa.CourseJPA;

public class ContextJpaClient {

    public static void main(String[] args) {
    	ApplicationContext context=
    			new ClassPathXmlApplicationContext("/jpa-beans-usingContext.xml");
    	
    	if( context !=null ){    		
        CourseDAOJPA courseDao = (CourseDAOJPA)context.getBean("courseDaoContext");
        
        @SuppressWarnings("unchecked")
		StudentDao<Student> studentDao= (StudentDao<Student>)context.getBean("studentDao");
        
        CourseJPA course = new CourseJPA();
        course.setId(new Long(30));
        course.setTitle("SpringJDBC-JPA-Hib");
        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
        course.setFee(101);
        /*
        for(long i=29;i<=28;i++){
        	course.setId(i);
        	courseDao.store(course);
        }
        courseDao.store(course);*/
        
        Student st = new Student( "NameNameNameNameNameNameNameNameName", "branch", 100, 100, "email");
        st.setId( 14 );
        studentDao.store(st);
        	
        CourseJPA courseJPA = courseDao.findById(new Long(14));
        System.out.println( "@@@@@@@@@@Found entirty properties => " + courseJPA.getTitle() );

        /*List<Course> courses = courseDao.findAll();
        Long courseId = courses.get(0).getId();

        course = courseDao.findById(courseId);
        System.out.println("Course Title: " + course.getTitle());
        System.out.println("Begin Date: " + course.getBeginDate());
        System.out.println("End Date: " + course.getEndDate());
        System.out.println("Fee: " + course.getFee());*/

        ///courseDao.delete(courseId);
        }
    	else {
    		System.out.println("Context creation failed");
    	}
    }
}
