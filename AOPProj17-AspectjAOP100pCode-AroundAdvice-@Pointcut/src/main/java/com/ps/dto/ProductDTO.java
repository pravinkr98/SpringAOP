package com.ps.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDTO implements Serializable {
	
	private int pid;
	private String pname;
	private float price;
	private float qty;
}
