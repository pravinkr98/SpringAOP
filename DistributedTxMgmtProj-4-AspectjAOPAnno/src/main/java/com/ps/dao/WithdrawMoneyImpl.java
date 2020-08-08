package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("wDAO")
public class WithdrawMoneyImpl implements WithdrawDAO {
	private static final String WITHDRAW_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";

	@Autowired
	@Qualifier("oraJt")
	private JdbcTemplate jt;
	
	@Override
	public int withdrawMoney(long srcAccount, float amount) {
		return jt.update(WITHDRAW_QUERY, amount,srcAccount);
	}

}
