package com.ps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.dto.ProductDTO;
import com.ps.service.IECommerceStore;

public class AspectJAOPAroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IECommerceStore proxy=null;
		ProductDTO p1=null,p2=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get service class object
		proxy=ctx.getBean("ecs", IECommerceStore.class);
		System.out.println("Target class :: "+proxy.getClass().getName()+"    Super class :: "+proxy.getClass().getSuperclass().getName());
		//insert 1st product details into dto object
		p1=new ProductDTO();
		p1.setPid(1001); p1.setPname("table"); p1.setPrice(1000.0f); p1.setQty(3.0f);
		//insert 2nd product details into dto object
		p2=new ProductDTO();
		p2.setPid(2002); p2.setPname("Sofa"); p2.setPrice(15000); p2.setQty(2.0f);
		
		//invoke method
		try {
			//add 1st product into cart
			System.out.println(proxy.addItemToCart(p1));
			//add 2nd product into cart
			System.out.println(proxy.addItemToCart(p2));		
			//show all cart items
			proxy.displayCartItemsList();
			//calculate bill amount with discount
			System.out.println("Total bill amount with 6% discount :: "+proxy.calcBillAmount(5));
			System.out.println("======================================================");
			System.out.println("Total bill amount with 6% discount :: "+proxy.calcBillAmount(5));
		}
		catch(Exception te) {
			te.printStackTrace();
		}
	}

}
