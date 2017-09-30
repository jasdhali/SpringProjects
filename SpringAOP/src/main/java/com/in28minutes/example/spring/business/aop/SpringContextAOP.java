package com.in28minutes.example.spring.business.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.in28minutes.example.spring.business.aop" })
class SpringContextAOP {
}