package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ps.dto.ProductDTO;

@Service("storeService")
public class ECommerceStore {
	private List<ProductDTO> cartList=new ArrayList<>();
	
	public String addItemToCart(ProductDTO dto){
		cartList.add(dto);
		return dto.getPname()+" is added to cart list";
	}
	
	public void displayCartItemsList() {
		cartList.forEach(System.out::println);
	}
	
	public float calcBillAmount(float cuponDiscount) {
		float bAmt=0.0f;
		float finalAmount=0.0f;
		bAmt=(float) cartList.stream().mapToDouble(dto->
			(dto.getPrice()*dto.getQty())).sum();
		finalAmount=bAmt-(bAmt*(cuponDiscount/100f));
		return finalAmount;
	}
}
