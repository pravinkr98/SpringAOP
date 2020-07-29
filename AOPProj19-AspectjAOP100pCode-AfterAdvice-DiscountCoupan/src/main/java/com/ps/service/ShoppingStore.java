package com.ps.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("store")
public class ShoppingStore {

	public double shopping(String[] items, double[] prices) {
		double billAmount=0.0;
		billAmount=Arrays.stream(prices, 0, prices.length).sum();
		return billAmount;
	}
	
	/*public double shopping(String[] items, double[] prices) {
		double billAmount=0.0;
		billAmount=DoubleStream.of(prices).sum();
		return billAmount;
	}*/
}
