package com.qa.dataproviders.example;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "getTestData")
	public String[][] dataSupplier() {

		String[][] data = {  
							{ "amotooricap3@gmail.com", "12345" },
							{ "amotooricap1@gmail.com", "12345" },
							{"testabc@yopmail.com", "12345"}

		};
		return data;

	}

}
