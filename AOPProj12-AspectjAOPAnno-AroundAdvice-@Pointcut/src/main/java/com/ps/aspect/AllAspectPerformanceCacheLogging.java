package com.ps.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("allAspect")
@Aspect
public class AllAspectPerformanceCacheLogging {
	private static Logger logger=Logger.getLogger(AllAspectPerformanceCacheLogging.class);
	
	static {
		try {
			PropertyConfigurator.configure("src/main/java/com/ps/commons/log4j.properties");
			logger.info("Log4j Activated");
		}
		catch(Exception e) {
			logger.fatal("Issue in loading of properties file");
			e.printStackTrace();
		}
	}
	
	@Pointcut("execution(* com.ps.service.ECommerceStore.*(..))")
	public void myPtc() {	}

	@Around("myPtc()")
	@Order(3)
	public Object logging(ProceedingJoinPoint pjp)throws Throwable{
		Object retVal=null;
		Object args[]=null;
		System.out.println("LoggingAspect is applying...");
		logger.debug("Entering into Logging"+pjp.getSignature()+" with arguments "+Arrays.deepToString(pjp.getArgs()));
		args=pjp.getArgs();
		if(pjp.getSignature().getName().equalsIgnoreCase("calcBillAmount")) {
			args[0]=(Float)args[0]+1;
		}
		
		retVal=pjp.proceed(args);
		logger.debug("Exiting from Logging"+pjp.getSignature()+" with arguments "+Arrays.deepToString(pjp.getArgs()));
		return retVal;
	}
	
	private Map<String,Object> cacheMap = new HashMap<>();
	
	@Around(value="myPtc()")
	@Order(1)
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
	
	@Around(value = "myPtc()")
	@Order(2)
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
