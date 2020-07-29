package com.ps.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("grapherAspect")
@Aspect
public class CommonExceptionGrapherAspect {

	@AfterThrowing(value = "execution(float com.ps.service.ShoppingStore.calculateSingleProductBillAmt(..))",throwing = "iae")
	public void exceptionGraphing(JoinPoint jp,Exception iae) {
		throw new InternalProblemException(iae.getMessage());
	}
}
