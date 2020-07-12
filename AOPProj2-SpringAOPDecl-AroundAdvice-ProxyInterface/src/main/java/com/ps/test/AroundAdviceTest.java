package com.ps.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.service.IBankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService proxy=null;
		
		//get IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//call bean to proxy class object
		proxy=ctx.getBean("pfb", IBankService.class);
		System.out.println("proxy object classname "+proxy.getClass()+"      "+Arrays.toString(proxy.getClass().getInterfaces())+"     "+proxy.getClass().getSuperclass());
		try {
			System.out.println("Simple Interest Amount :: "+proxy.calcSimpleInterestAmount(100000, 12, 4));
			System.out.println(".........................................................................................");
			System.out.println("Compound Interst Amount :: "+proxy.calcCompoundInterestAmount(100000, 12, 4));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main

}//class
