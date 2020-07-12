package com.ps.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitorAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start=0,end=0;
		Object retVal=null;
		start=System.currentTimeMillis();
		System.out.println("pre");
		retVal=invocation.proceed();
		System.out.println("post");
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+" with arguments "+Arrays.toString(invocation.getArguments())+" has taken "+(end-start)+" ms");
		return retVal;
	}

}
