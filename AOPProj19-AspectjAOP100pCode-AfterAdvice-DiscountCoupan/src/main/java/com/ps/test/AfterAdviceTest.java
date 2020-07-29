package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ps.config.AppConfig;
import com.ps.service.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		
		//get IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get proxy class object
		proxy=ctx.getBean("store", ShoppingStore.class);
		//invoke method
		try {
			System.out.println("Bill Amount :: "+proxy.shopping(new String[] {"Bed","Table","Dressing"}, new double[] {18500,6500,8500}));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main

}//class
