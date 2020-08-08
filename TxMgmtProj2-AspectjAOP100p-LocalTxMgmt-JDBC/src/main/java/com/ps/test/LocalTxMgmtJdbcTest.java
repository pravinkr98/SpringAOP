package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.config.AppConfig;
import com.ps.service.BankMgmtService;

public class LocalTxMgmtJdbcTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		
		//get IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get BankService object
		proxy=ctx.getBean("bankService", BankMgmtService.class);
		System.out.println(proxy.getClass()+"     "+proxy.getClass().getSuperclass());
		//invoke money transfer method
		try {
			System.out.println(proxy.transferMoney(10011, 1002, 20000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main

}//class
