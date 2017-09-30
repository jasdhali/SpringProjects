package com.in28minutes.example.spring.business.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextAOP.class)
public class AOPExampleTest {

	@Autowired
	private HiByeService service;

	@Test
	public void testSomething() {
		service.sayHi("in28Minutes");
		service.sayBye();
		service.returnSomething();
	}

}

