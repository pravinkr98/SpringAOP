package com.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.model.CustomerInfo;

@SpringBootApplication
public class SpringBootConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerInfo info=null;
		
		//get IOC container
		ctx=SpringApplication.run(SpringBootConfigurationPropertiesAnnotationApplication.class, args);
		//get Bean
		info=ctx.getBean("custInfo", CustomerInfo.class);
		//display properties
		System.out.println(info);
		System.out.println("-------------------------------------------------");
		info.display();
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
