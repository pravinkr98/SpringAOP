package com.ps.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class TestDriveBeforeAspect {

	public void testDriving(JoinPoint jp)throws Throwable{		
		Object args[]=null;
		Writer writer=null;
		
		System.out.println(" Target method details"+jp.getSignature()+"   "+Arrays.deepToString(jp.getArgs()));
		//get target method arguments
		args=jp.getArgs();
		try {
			writer=new FileWriter("E:/auditLog.txt",true);
			writer.write("Car model :: "+args[0]+" with color :: "+args[1]+" having price :: "+args[2]+" by executive :: "+args[3]+" on date :: "+new Date()+" has been taken  for a test drive\n");
			writer.flush();
			writer.close();					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method
}//class
