package com.ps.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object args[]=null;
		System.out.println("Entering into "+invocation.getMethod().getName()+"  with arguments "+Arrays.toString(invocation.getArguments()));
		args=invocation.getArguments();
		if(((Float)args[0])<50000)
			args[1]=((Float)args[1])-0.5f;
		
		if((Float)args[0]<0 || (Float)args[1]<0 || (Float)args[2]<0)
			throw new IllegalArgumentException("invalid inputs");
		else
			retVal=invocation.proceed();
		System.out.println(" Exiting from "+invocation.getMethod().getName()+" with arguments "+Arrays.toString(invocation.getArguments()));
		//To modify target method return value
		//retVal=((Float)retVal)+((Float)retVal*0.05f);
		return retVal;
	}

}
