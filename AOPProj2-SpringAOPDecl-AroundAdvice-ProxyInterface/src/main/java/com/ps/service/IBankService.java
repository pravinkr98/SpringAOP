package com.ps.service;

public interface IBankService {

	public float calcSimpleInterestAmount(float pAmt,float rate,float time);
	public float calcCompoundInterestAmount(float pAmt,float rate,float time);
	
}
