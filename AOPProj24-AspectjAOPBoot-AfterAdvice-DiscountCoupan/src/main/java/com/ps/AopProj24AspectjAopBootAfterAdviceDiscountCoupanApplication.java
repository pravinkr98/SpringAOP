package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ps.service.ShoppingStore;

@SpringBootApplication
public class AopProj24AspectjAopBootAfterAdviceDiscountCoupanApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		
		//get IOC container
		ctx=SpringApplication.run(AopProj24AspectjAopBootAfterAdviceDiscountCoupanApplication.class, args);
		
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

	}

}
