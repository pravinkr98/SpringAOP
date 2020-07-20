package com.ps.service;

public interface BankMgmtService {

	public String withdrawMoney(long acno, double amt);
	public String depositeMoney(long acno, double amt);
}
