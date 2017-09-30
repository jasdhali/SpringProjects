package com.apress.springrecipes.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArithmeticCalculatorTest {
	
	private ArithmeticCalculator arithmeticCalculator;
	double arg1=100;
	double arg2=50;
	
	@Before
	public void setUp() throws Exception {
		arithmeticCalculator = new ArithmeticCalculatorImpl();
	}

	@Test
	public void testAdd() {
		double expected = 150d;
		double actual = arithmeticCalculator.add(arg1, arg2);
		assertTrue(expected==actual);
		
	}

	@Test
	public void testSub() {
		double expected = 50d;
		double actual = arithmeticCalculator.sub(arg1, arg2);
		assertTrue(expected==actual);
	}

	@Test
	public void testMul() {
		double expected = 5000d;
		double actual = arithmeticCalculator.mul(arg1, arg2);
		assertTrue(expected==actual);
	}

	@Test
	public void testDiv() {
		double expected = 2d;
		double actual = arithmeticCalculator.div(arg1, arg2);
		assertTrue(expected==actual);
	}

}
