package com.ps.aspect;

import org.aspectj.lang.JoinPoint;

import com.ps.manager.AuthenticationManager;

public class SecurityCheckAspect {

	private AuthenticationManager manager;

	public SecurityCheckAspect(AuthenticationManager manager) {
		this.manager = manager;
	}
	
	public void check(JoinPoint jp)throws Throwable{
		System.out.println("SecurityCheckAspect.check(-)");
		System.out.println(jp.getSignature()+" with arguments "+jp.getArgs());
		if(!manager.isAuthenticated())
			throw new IllegalArgumentException("Authentication failed");
	}
}
