package com.ps.service;

import org.springframework.stereotype.Service;

@Service("shopping")
public class ShoppingStore {

	public float calculateSingleProductBillAmt(float price, float item) throws IllegalAccessException {
		if(price<=0.0f || item<=0)
			throw new IllegalAccessException("Invalid Input");
		
		return price*item;
	}
}
