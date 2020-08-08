package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ps.dao.DepositeDAO;
import com.ps.dao.WithdrawDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements BankMgmtService {
	
	@Autowired
	private DepositeDAO dDao=null;
	@Autowired
	private WithdrawDAO wDao=null;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "jtaTxMgmr")
	public String transferMoney(long srcAcno, long destAcno, float amt) {
		int count1=0,count2=0;
		//use WithdrawDAO
		count1=wDao.withdrawMoney(srcAcno, amt);
		//use DepositeDAO
		count2=dDao.depositeMoney(destAcno, amt);
		if(count1==0 || count2==0)
			throw new IllegalArgumentException("Problem in money transferring");
		else
			return +amt+" money transfer successful from "+srcAcno+" account to "+destAcno+" account";
	}

}
