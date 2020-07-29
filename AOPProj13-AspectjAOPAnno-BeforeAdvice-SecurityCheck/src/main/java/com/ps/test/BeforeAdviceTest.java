package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.manager.AuthenticationManager;
import com.ps.service.BankMgmtService;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankMgmtService proxy=null;
		
		//get IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get manager object
		manager=ctx.getBean("authManager", AuthenticationManager.class);
		//get bank service object
		proxy=ctx.getBean("bankService", BankMgmtService.class);
		//signIn
		manager.signIn("karan","hyd");
		try {
			//withdraw
			System.out.println(proxy.withdrawMoney(1002, 25000));
			//deposite
			System.out.println(proxy.depositeMoney(1001, 25000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//signOut
		manager.signOut();
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main

}//class
