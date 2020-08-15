package com.ps.service;

public interface BankMgmtService {

	public String transferMoneyFromOracle(long srcAcno, long destAcno, float amt);
	public String transferMoneyFromPgSQL(long srcAcno, long destAcno, float amt);
}
