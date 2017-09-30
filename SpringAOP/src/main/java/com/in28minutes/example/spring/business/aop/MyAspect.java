package com.in28minutes.example.spring.business.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
class MyAspect {
	@Before("execution(* com.in28minutes.example.spring.business.aop.HiByeService.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.print("Before ");
		System.out.print(joinPoint.getSignature().getName() + " called with ");
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* com.in28minutes.example.spring.business.aop.HiByeService.*(..))", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
		System.out.print("After ");
		System.out.print(joinPoint.getSignature().getName());
		System.out.println(" result is " + result);
	}

}