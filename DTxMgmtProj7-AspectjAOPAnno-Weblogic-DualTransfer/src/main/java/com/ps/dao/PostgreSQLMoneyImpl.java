package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("pgDAO")
public class PostgreSQLMoneyImpl implements BankService {
	private static final String DEPOSITE_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	private static final String WITHDRAW_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";

	@Autowired
	@Qualifier("pgJt")
	private JdbcTemplate jt;
	
	@Override
	public int depositeMoney(long destAccount, float amount) {
		return jt.update(DEPOSITE_QUERY, amount,destAccount);
	}

	@Override
	public int withdrawMoney(long srcAccount, float amount) {
		return jt.update(WITHDRAW_QUERY, amount,srcAccount);
	}

}
