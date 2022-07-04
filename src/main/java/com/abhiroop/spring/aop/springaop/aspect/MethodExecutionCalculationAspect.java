package com.abhiroop.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around(value = "execution (* com.abhiroop.spring.aop.springaop.business.*.*(..))")
	public void afterReturning(ProceedingJoinPoint joinPoint) throws Throwable {
		//startTime = x
		long startTime = System.currentTimeMillis();
		// allow method execution
		joinPoint.proceed();
		//endTime = y
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time taken by {} is {}", joinPoint, timeTaken);
	}
	
}
