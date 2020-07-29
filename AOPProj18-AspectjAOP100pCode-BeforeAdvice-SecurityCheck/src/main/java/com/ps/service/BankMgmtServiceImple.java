package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.BankDAO;

@Service("bankService")
public class BankMgmtServiceImple implements BankMgmtService {
	
	@Autowired
	private BankDAO dao;
	
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
