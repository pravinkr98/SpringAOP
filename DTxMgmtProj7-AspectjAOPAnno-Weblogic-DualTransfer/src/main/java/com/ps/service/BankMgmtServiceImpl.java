package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ps.dao.BankService;

@Service("bankService")
public class BankMgmtServiceImpl implements BankMgmtService {
	
	@Autowired
	@Qualifier(value = "oraDAO")
	private BankService oracleDao=null;
	@Autowired
	@Qualifier(value = "pgDAO")
	private BankService pgsqlDao=null;	

	@Override
	public String transferMoneyFromOracle(long srcAcno, long destAcno, float amt) {
		return moneyTransfer(oracleDao,pgsqlDao,srcAcno,destAcno,amt);
	}

	@Override
	public String transferMoneyFromPgSQL(long srcAcno, long destAcno, float amt) {
		return moneyTransfer(pgsqlDao,oracleDao,srcAcno,destAcno,amt);
	}
	
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "jtaTxMgmr")
	public String moneyTransfer(BankService bank1, BankService bank2, long srcAcno, long destAcno, float amt) {
		int count1=0,count2=0;
		//use WithdrawDAO
		count1=bank1.withdrawMoney(srcAcno, amt);
		//use DepositeDAO
		count2=bank2.depositeMoney(destAcno, amt);
		if(count1==0 || count2==0)
			throw new IllegalArgumentException("Problem in money transferring");
		else
			return +amt+" money transfer successful from "+srcAcno+" account to "+destAcno+" account";
	}

}
