package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.advice.InternalProblemException;
import com.ps.service.ShoppingStore;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		
		//get IOC Container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get proxy class object
		proxy=ctx.getBean("shopping", ShoppingStore.class);
		//invoke method
		try {
			System.out.println("Bill Amount is :: "+proxy.calculateSingleProductBillAmt(10000, 2));
		}
		/*catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		catch(InternalProblemException iae) {
			iae.printStackTrace();
		}*/
		catch(IllegalAccessException iae) {
			iae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("....................................................................");
		
		try {
			System.out.println("Bill Amount is :: "+proxy.calculateSingleProductBillAmt(1000, 0));
		}
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		catch(InternalProblemException iae) {
			iae.printStackTrace();
		}
		catch(IllegalAccessException iae) {
			iae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
