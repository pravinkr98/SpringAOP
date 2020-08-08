package com.ps.dao;

public interface BankDAO {

	public int withdrawMoney(long acno, double amt);
	public int depositeMoney(long acno, double amt);
}
