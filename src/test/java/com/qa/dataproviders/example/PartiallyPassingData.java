package com.qa.dataproviders.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartiallyPassingData {

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
	@DataProvider(name = "objectData", indices= {0,2})
	public Object[][] dataSupplier() {
		
		Object[][] data = { {"one", "two", "three", "four"},
							{"five", "six", "seven", "Eight"},
							{ "nine", "ten", "eleven", "Tweleve"}
		};
		return data;
	}
	
	/*
	 * Test will run 4 times, since 4 set of data.
	 */
	@DataProvider(name = "objectDataOne", indices= {0,5})
	public Object[] dataSupplierTwo() {
		
		Object[] data = { "one", "two", "three", "four", "fiver", "six", "seven"};
		return data;
	}
	
	/*
	 * Here above we are passing only partial data to the test method.
	 * indices ={0,2} --> Meaning pass the first index and 3rd index data from dataprovider.
	 * What't the purpose?
	 * -> Suppose of out 1000's of data, only for two data test are failing then we can pass the data
	 *    from indices.
	 */
}
