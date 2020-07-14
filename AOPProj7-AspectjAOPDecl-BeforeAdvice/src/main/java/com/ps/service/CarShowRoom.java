package com.ps.service;

public class CarShowRoom {

	public String purchaseCar(String modelName, String color, Double price, String executive) {
		
		if(modelName.equalsIgnoreCase("Baleno") && color.equalsIgnoreCase("red") && price<=1000000)
			return "Car is available for sell  with model :: "+modelName+", color :: "+color+", price :: "+price+" by executive :: "+executive;
		else
			return "Car is not available for sell  with model :: "+modelName+", color :: "+color+", price :: "+price+" by executive :: "+executive;

	}
}
