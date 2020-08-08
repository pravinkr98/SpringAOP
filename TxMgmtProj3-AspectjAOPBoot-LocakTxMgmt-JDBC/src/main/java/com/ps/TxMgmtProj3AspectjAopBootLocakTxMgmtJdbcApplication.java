package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ps.service.BankMgmtService;

@SpringBootApplication
public class TxMgmtProj3AspectjAopBootLocakTxMgmtJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		
		//get IOC container
		ctx=SpringApplication.run(TxMgmtProj3AspectjAopBootLocakTxMgmtJdbcApplication.class, args);
		
		//get BankService object
		proxy=ctx.getBean("bankService", BankMgmtService.class);
		System.out.println(proxy.getClass()+"     "+proxy.getClass().getSuperclass());
		//invoke money transfer method
		try {
			System.out.println(proxy.transferMoney(1001, 10022, 2500));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
