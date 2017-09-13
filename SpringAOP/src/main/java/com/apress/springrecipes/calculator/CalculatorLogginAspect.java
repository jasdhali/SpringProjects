package com.apress.springrecipes.calculator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorLogginAspect {
	private Log log = LogFactory.getLog(this.getClass());
	
	@Before("execution(* *.*(..))")
	public void logBefore(JoinPoint joinPoint){
		log.info("The method " + joinPoint.getSignature().getName() +"() begins with "+ joinPoint.getArgs() );
	}
}