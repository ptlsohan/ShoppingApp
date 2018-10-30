package com.service;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Service;


@Service
@Aspect
public class LogService {

	Logger logger = Logger.getLogger(LogService.class);
	

	@Around("execution(* com.controller.*.*(..))")

	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Entering method " + joinPoint.getSignature());
		Object o = joinPoint.proceed();
		logger.info("Exiting method" + joinPoint.getSignature());
		return o;
	}
	
}
