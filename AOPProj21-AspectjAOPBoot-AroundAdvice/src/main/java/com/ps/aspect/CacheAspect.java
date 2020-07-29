package com.ps.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("cacheAspect")
@Aspect
@Order(10)
public class CacheAspect {
	private Map<String,Object> cacheMap = new HashMap<>();
	
	@Around(value="execution(float com.ps.service.ECommerceStore.calcBillAmount(..))")
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		String key=null;
		Object retVal=null;
		//prepare key
		key=pjp.getSignature()+Arrays.deepToString(pjp.getArgs());
		if(!cacheMap.containsKey(key)) {
			retVal=pjp.proceed();		//invoke target method and get result
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
