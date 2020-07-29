package com.ps.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ps.manager.AuthenticationManager;

@Component("securityAspect")
@Aspect
public class SecurityCheckAspect {
	
	@Autowired
	private AuthenticationManager manager;

	@Before(value="execution(java.lang.String com.ps.service.BankMgmtService.*(..))")
	public void check(JoinPoint jp)throws Throwable{
		System.out.println("SecurityCheckAspect.check(-)");
		System.out.println(jp.getSignature()+" with arguments "+jp.getArgs());
		if(!manager.isAuthenticated())
			throw new IllegalArgumentException("Authentication failed");
	}
}
