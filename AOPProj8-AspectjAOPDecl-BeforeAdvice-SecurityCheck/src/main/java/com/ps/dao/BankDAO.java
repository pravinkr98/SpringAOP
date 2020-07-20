package com.ps.dao;

public interface BankDAO {

	public int withdraw(long acno, double amt);
	public int deposite(long acno, double amt);
}
