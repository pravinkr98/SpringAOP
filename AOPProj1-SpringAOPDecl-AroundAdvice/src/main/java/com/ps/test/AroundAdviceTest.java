package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.service.BankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		
		//get IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//call bean to proxy class object
		proxy=ctx.getBean("pfb", BankService.class);
		System.out.println("proxy object classname "+proxy.getClass()+"  super class "+proxy.getClass().getSuperclass());
		try {
			System.out.println("Simple Interest Amount :: "+proxy.calcSimpleInterestAmount(10000, 2, 12));
			System.out.println(".........................................................................................");
			System.out.println("Compound Interst Amount :: "+proxy.calcCompoundInterestAmount(10000, 2, 12));
			System.out.println("=================================================================");
			System.out.println("Simple Interest Amount :: "+proxy.calcSimpleInterestAmount(10000, 2, 12));
			System.out.println(".........................................................................................");
			System.out.println("Compound Interst Amount :: "+proxy.calcCompoundInterestAmount(10000, 2, 12));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main

}//class
