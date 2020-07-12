package com.ps.service;

public class BankService {

	public float calcSimpleInterestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcSimpleInterestAmount(-,-,-) Target Method1 "+pAmt+"   "+rate+"   "+time);
		return (pAmt*rate*time)/100.0f; //(p*r*t)/100
	}
	
	public float calcCompoundInterestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcCompoundInterestAmount(-,-,-) Target Method1 "+pAmt+"   "+rate+"   "+time);
		return (float) (pAmt*Math.pow((1+rate/100), time))-pAmt;		//p(1+(r/100)^t)-p
	}
}
