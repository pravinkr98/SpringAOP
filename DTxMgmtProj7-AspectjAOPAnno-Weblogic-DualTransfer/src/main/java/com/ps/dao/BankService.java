package com.ps.dao;

public interface BankService {

	public int depositeMoney(long destAccount, float amount);
	public int withdrawMoney(long srcAccount, float amount);
}
