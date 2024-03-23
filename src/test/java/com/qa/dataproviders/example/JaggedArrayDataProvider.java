package com.qa.dataproviders.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JaggedArrayDataProvider {

	@Test(priority = 1, dataProvider = "objectData")
	public void testData(Object [] a) {
		for(Object data : a) {
			System.out.print(data + " ");
			
		}
		System.out.println();
		System.out.println("--------------------------------------------------");
	}
    
	/*
	 * Test will run 4 times, since 4 set of data.
	 */
	@DataProvider(name = "objectData")
	public Object[][] dataSupplier() {
		
		Object[][] data = {{"one", "two", "three", "four"},
				{"five", "six"},
				{"seven", "eight", "nine", "ten", "eleven"}
		};
		return data;
	}
	
	/*
	 * Jagged Arrays are the arrays where each row will have different number of column
	 * Here we cannot put individual parameter in test method to receive the data
	 */
}
