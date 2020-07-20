package com.ps.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements BankDAO {
	private static final String QUERY_WITHDRAW="UPDATE BANKACCOUNT SET BALANCE=(BALANCE-?) WHERE ACNO=?";
	private static final String QUERY_DEPOSITE="UPDATE BANKACCOUNT SET BALANCE=(BALANCE+?) WHERE ACNO=?";
	private JdbcTemplate jt;
		
	public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int withdraw(long acno, double amt) {
		System.out.println("BankDAOImpl.withdraw(-,-)");
		int count=0;
		count=jt.update(QUERY_WITHDRAW, amt, acno);
		return count;
	}

	@Override
	public int deposite(long acno, double amt) {
		System.out.println("BankDAOImpl.deposite(-,-)");
		int count=0;
		count=jt.update(QUERY_DEPOSITE, amt, acno);
		return count;
	}

}
