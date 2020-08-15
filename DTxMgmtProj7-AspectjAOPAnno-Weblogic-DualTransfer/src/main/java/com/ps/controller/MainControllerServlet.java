package com.ps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.service.BankMgmtService;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private ApplicationContext ctx;
       
	public void init() throws ServletException {
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
	}

	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long srcNo=0L,destNo=0L;
		float amt=0.0f;
		BankMgmtService service=null;
		String result=null,bank=null;
		RequestDispatcher rd=null;
		
		//read form data
		srcNo=Long.parseLong(req.getParameter("srcAcno"));
		destNo=Long.parseLong(req.getParameter("destAcno"));
		amt=Float.parseFloat(req.getParameter("amt"));
		bank=req.getParameter("bank");
		
		//get Service class object
		service=ctx.getBean("bankService", BankMgmtService.class);
		try {
			//invoke method
			if(bank.equals("oracle")) {
				result=service.transferMoneyFromOracle(srcNo, destNo, amt);
			}
			else if(bank.equals("postgres")) {
				result=service.transferMoneyFromPgSQL(srcNo, destNo, amt);
			}			
			req.setAttribute("resultMsg", result);
			//forward to result.jsp page
			rd=req.getRequestDispatcher("/result.jsp");
			rd.forward(req, resp);
		}
		catch(Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
