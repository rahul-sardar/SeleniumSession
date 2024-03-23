package com.qa.dataproviders.example;

import org.testng.annotations.Test;

public class GettingDataFromMultipleDaraprovider {
	
	@Test(dataProvider = "supplierOne", dataProviderClass=MutipleDataProvider.class)
	public void testData(String one, String two, String three) {
		
		System.out.println(one + " - " + two + " - " + three + " . " );

	}
	
	/*
	 * Since data provider are not present in the same class we have to provide the ClassName in dataproviderClass field
	 * Similarly we can keep our data in 2-3 classes and just pass the correct dataprovider and dataproviderclass name where we want to fetch the data
	 */

}
