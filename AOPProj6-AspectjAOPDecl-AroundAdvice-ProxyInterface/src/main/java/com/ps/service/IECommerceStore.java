package com.ps.service;

import com.ps.dto.ProductDTO;

public interface IECommerceStore {

	public String addItemToCart(ProductDTO dto);
	public void displayCartItemsList();
	public float calcBillAmount(float cuponDiscount);
}
