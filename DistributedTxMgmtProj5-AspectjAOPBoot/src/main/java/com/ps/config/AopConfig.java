package com.ps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AopConfig {

	@Bean(name="dTxService")
	public UserTransactionImp createDTxService() throws Exception {
		UserTransactionImp txService=null;
		txService=new UserTransactionImp();
		txService.setTransactionTimeout(60);
		return txService;
	}
	
	@Bean(name="dTxMgmr")
	public UserTransactionManager createDTxMgmr() throws Exception {
		UserTransactionManager txMgmr=null;
		txMgmr=new UserTransactionManager();
		txMgmr.setForceShutdown(true);
		return txMgmr;
	}
	
	@Bean(name="jtaTxMgmr")
	public JtaTransactionManager createJtaTxMgmr() throws Exception {
		JtaTransactionManager jtaTx=null;
		jtaTx=new JtaTransactionManager();
		jtaTx.setUserTransaction(createDTxService());
		jtaTx.setTransactionManager(createDTxMgmr());
		return jtaTx;
	}
}
