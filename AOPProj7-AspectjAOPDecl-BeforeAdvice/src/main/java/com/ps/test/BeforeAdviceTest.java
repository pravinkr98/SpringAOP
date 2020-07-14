package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.service.CarShowRoom;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CarShowRoom carProxy=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get target class bean object
		carProxy=ctx.getBean("showRoom", CarShowRoom.class);
		//invoke method
		try {
			System.out.println(carProxy.purchaseCar("baleno", "red", 750000.0, "Ramesh"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main

}//class
