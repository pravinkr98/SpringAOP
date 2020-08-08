package com.ps.service;

public interface BankMgmtService {

	public String transferMoney(long sourceAcno, long destAcno, double amount) throws IllegalAccessException;
}
