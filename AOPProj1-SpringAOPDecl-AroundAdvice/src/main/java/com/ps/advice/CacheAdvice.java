package com.ps.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor {
	private Map<String,Object> cacheMap = new HashMap();
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key=null;
		Object retVal=null;
		//prepare key
		key=invocation.getMethod().getName()+Arrays.deepToString(invocation.getArguments());
		if(!cacheMap.containsKey(key)) {
			retVal=invocation.proceed();		//invoke target method and get result
			cacheMap.put(key, retVal);		//keeping target method results in map object
			System.out.println("from target mehtod");
		}
		else {
			retVal=cacheMap.get(key);
			System.out.println("from cache");
		}
			
			
		return retVal;
	}

}
