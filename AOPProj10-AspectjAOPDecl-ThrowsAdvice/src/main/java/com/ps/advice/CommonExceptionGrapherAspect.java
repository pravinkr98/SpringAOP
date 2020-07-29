package com.ps.advice;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionGrapherAspect {

	public void exceptionGraphing(JoinPoint jp,Exception iae) {
		throw new InternalProblemException(iae.getMessage());
	}
}
