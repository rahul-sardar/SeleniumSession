package com.qa.dataproviders.example;

import org.testng.annotations.DataProvider;

public class MutipleDataProvider {
	@DataProvider(name = "supplierOne")
	public String[][] dataSupplier() {

		String[][] data = {  
							{ "amotooricap3@gmail.com", "12345" , "Mumbai" },
							{ "amotooricap1@gmail.com", "12345", "Pune" },
							{"testabc@yopmail.com", "12345", "Delhi"}

		};
		return data;

	}
	
	@DataProvider(name = "supplierTwo")
	public String[][] dataSupplierTwo() {

		String[][] data = {  
							{ "Biscuits", "Chocolate" , "Brown" },
							{ "Cookies", "Choco Chips", "Yellow" },
							{"Drink", "Sprite", "Blue"}

		};
		return data;

	}
	
	

}
