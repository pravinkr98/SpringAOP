package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ps.manager.AuthenticationManager;
import com.ps.service.BankMgmtService;

@SpringBootApplication
public class AopProj23AspectjAopBootBeforeAdviceSecurityCheckApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankMgmtService proxy=null;
		
		//get IOC container
		ctx=SpringApplication.run(AopProj23AspectjAopBootBeforeAdviceSecurityCheckApplication.class, args);
		
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

	}

}
