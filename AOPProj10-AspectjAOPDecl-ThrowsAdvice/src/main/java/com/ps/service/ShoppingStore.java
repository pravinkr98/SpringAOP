package com.ps.service;

public class ShoppingStore {

	public float calculateSingleProductBillAmt(float price, float item) {
		if(price<=0.0f || item<=0)
			throw new IllegalArgumentException("Invalid Input");
		
		return price*item;
	}
}
