package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dDAO")
public class DepositeMoneyImpl implements DepositeDAO {
	private static final String DEPOSITE_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";

	@Autowired
	@Qualifier("mysqlJt")
	private JdbcTemplate jt;
	
	@Override
	public int depositeMoney(long destAccount, float amount) {
		return jt.update(DEPOSITE_QUERY, amount,destAccount);
	}

}
