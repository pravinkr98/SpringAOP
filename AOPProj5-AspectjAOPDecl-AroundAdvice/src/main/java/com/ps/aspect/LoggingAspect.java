package com.ps.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	private static Logger logger=Logger.getLogger(LoggingAspect.class);
	
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
}
