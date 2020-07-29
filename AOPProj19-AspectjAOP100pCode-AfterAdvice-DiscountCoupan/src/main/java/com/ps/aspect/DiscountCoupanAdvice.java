package com.ps.aspect;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("discountAspect")
@Aspect
public class DiscountCoupanAdvice {

	@AfterReturning(value = "execution(double com.ps.service.ShoppingStore.shopping(..))",returning = "billAmount")
	public void cupanGenerator(JoinPoint jp,double billAmount)throws Throwable {
		String coupanMsg=null;
		Writer writer=null;
		System.out.println(jp.getSignature()+" with args "+Arrays.deepToString(jp.getArgs()));
		if(billAmount<5000)
			coupanMsg="Avail 5% discount on next purchase";
		else if(billAmount<10000)
			coupanMsg="Avail 10% discount on next purchase";
		else if(billAmount<20000)
			coupanMsg="Avail 20% discount on next purchase";
		else
			coupanMsg="Avail 30% discount on next purchase";
		
		writer=new FileWriter("E:/coupan.txt");
		writer.write(coupanMsg);
		writer.flush();
		writer.close();
		System.out.println(coupanMsg);
	}
}
