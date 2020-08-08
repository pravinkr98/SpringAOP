package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ps.service.BankMgmtService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
public class DistributedTxMgmtProj5AspectjAopBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		
		//create IOC container
		ctx=SpringApplication.run(DistributedTxMgmtProj5AspectjAopBootApplication.class, args);
		
		//get Proxy object
		proxy=ctx.getBean("bankService", BankMgmtService.class);
		System.out.println(proxy.getClass()+"    "+proxy.getClass().getSuperclass());
		
		try {
			System.out.println(proxy.transferMoney(5001, 1001, 4000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
