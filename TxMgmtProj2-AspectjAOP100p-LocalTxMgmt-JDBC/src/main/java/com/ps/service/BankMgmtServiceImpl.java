package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ps.dao.BankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements BankMgmtService {

	@Autowired
	private BankDAO dao;
	
	@Override
	//@Transactional(propagation = Propagation.REQUIRED, timeout = 20, rollbackFor = IllegalAccessException.class )
	//@Transactional(propagation = Propagation.REQUIRED, timeout = 20, rollbackForClassName = "IllegalAccessException" )
	//@Transactional(propagation = Propagation.REQUIRED, timeout = 20, noRollbackFor =IllegalArgumentException.class  )
	//@Transactional(propagation = Propagation.REQUIRED, timeout = 20, noRollbackForClassName = "IllegalArgumentException"  )
	//@Transactional(propagation = Propagation.REQUIRED, transactionManager = "dsTxMgmr"  )
	//@Transactional(propagation = Propagation.REQUIRED )
	//@Transactional(propagation = Propagation.REQUIRES_NEW )
	//@Transactional(propagation = Propagation.MANDATORY )
	//@Transactional(propagation = Propagation.NEVER)
	//@Transactional(propagation = Propagation.SUPPORTS)
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Transactional(propagation = Propagation.REQUIRED,transactionManager = "dsTxMgmr" )
	public String transferMoney(long sourceAcno, long destAcno, double amount) throws IllegalAccessException {
		int count1=0,count2=0;
		//use dao for withdraw
		count1=dao.withdrawMoney(sourceAcno, amount);
		
		//putting transaction in sleep mode for certain time
		/*try {
			Thread.sleep(30000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}*/
		
		//use dao for deposite
		count2=dao.depositeMoney(destAcno, amount);	
		//return result
		if(count1==0 || count2==0)
			throw new RuntimeException("Problem in money transferring");
			//throw new IllegalAccessException("Problem in money transferring");
			//throw new IllegalArgumentException("Problem in money transferring");
		else
			return +sourceAcno+" account to "+destAcno+" account money transfer of "+amount+" is successful";
	}

}
