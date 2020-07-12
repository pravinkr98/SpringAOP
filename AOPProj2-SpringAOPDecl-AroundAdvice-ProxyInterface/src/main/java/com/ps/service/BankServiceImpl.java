package com.ps.service;

public class BankServiceImpl  implements IBankService{

	public float calcSimpleInterestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcSimpleInterestAmount(-,-,-)");
		return (pAmt*rate*time)/100.0f; //(p*r*t)/100
	}
	
	public float calcCompoundInterestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcCompoundInterestAmount(-,-,-)");
		return (float) (pAmt*Math.pow((1+rate/100), time))-pAmt;		//p(1+(r/100)^t)-p
	}
}
