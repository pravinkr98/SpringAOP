package com.ps.advice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("loggerAspect")
@Aspect
public class CommonExceptionLogger {
	private static Logger logger =Logger.getLogger(CommonExceptionLogger.class);
	
	static {
		try {
			PropertyConfigurator.configure("src/main/java/com/ps/commons/log4j.properties");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterThrowing(value = "execution(float com.ps.service.ShoppingStore.calculateSingleProductBillAmt(..))",throwing = "ex")
	public void exceptionLogger(JoinPoint jp, Exception ex) {
		logger.error(ex+" exception is raised in "+jp.getSignature()+" method with args "+Arrays.deepToString(jp.getArgs()));
	}
	
	/*public void exceptionLogger(JoinPoint jp, Exception ex,int x) {
		logger.error(ex+" exception is raised in "+jp.getSignature()+" method with args "+Arrays.deepToString(jp.getArgs()));
	}
	
	public void exceptionLogger(JoinPoint jp, Throwable ex, int x) {
		logger.error(ex+" exception is raised in "+jp.getSignature()+" method with args "+Arrays.deepToString(jp.getArgs()));
	}*/
	
}
