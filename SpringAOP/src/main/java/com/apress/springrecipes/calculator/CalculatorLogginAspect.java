package com.apress.springrecipes.calculator;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorLogginAspect {
	private Log log = LogFactory.getLog(this.getClass());
	
	@Before("execution(* *.*(..))")
	public void logBefore(JoinPoint joinPoint){
		Date date = new Date();
		log.info(date+"The method " + joinPoint.getSignature().getName() +"() begins with "+ joinPoint.getArgs() );
	}
	
	@After("execution(* *.*(..))")
	public void logAfter(JoinPoint joinPoint){
		log.info("The method " + joinPoint.getSignature().getName() +"() begins with "+ joinPoint.getArgs() );
	}
}
