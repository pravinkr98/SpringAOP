package com.ps.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAspect")
@Aspect
@Order(1)
public class PerformanceMonitorAspect {

	@Around(value = "execution(* com.ps.service.ECommerceStore.*(..))")
	public Object monitor(ProceedingJoinPoint pjp)throws Throwable{
		long start=0,end=0;
		Object retVal=null;
		
		start=System.currentTimeMillis();
		retVal=pjp.proceed();
		end=System.currentTimeMillis();
		
		System.out.println(pjp.getSignature()+"  with arguments "+Arrays.deepToString(pjp.getArgs())+"  has taken "+(end-start)+" ms");
		return retVal;
	}
}
