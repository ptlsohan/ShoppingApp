package com.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class LogService {

	Logger logger = LoggerFactory.getLogger(LogService.class);
	
	@Around(value = "within( com.controller.*)")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Entering method " + joinPoint.getSignature());
		Object o = joinPoint.proceed();
		logger.info("Exiting method" + joinPoint.getSignature());
		return o;
	}
	
}
