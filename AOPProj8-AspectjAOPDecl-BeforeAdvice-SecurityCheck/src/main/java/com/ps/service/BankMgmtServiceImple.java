package com.ps.service;

import com.ps.dao.BankDAO;

public class BankMgmtServiceImple implements BankMgmtService {
	private BankDAO dao;
	
	public BankMgmtServiceImple(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String withdrawMoney(long acno, double amt) {
		System.out.println("BankMgmtServiceImple.withdrawMoney(-,-)");
		int count=0;
		count=dao.withdraw(acno, amt);
		return count==0?"Money withdraw failed with account :: "+acno:"Money withdraw successful on account :: "+acno;
	}

	@Override
	public String depositeMoney(long acno, double amt) {
		System.out.println("BankMgmtServiceImple.depositeMoney(-,-)");
		int count=0;
		count=dao.deposite(acno, amt);
		return count==0?"Money deposite failed with account :: "+acno:"Money deposite successful on account :: "+acno;
	}

}
