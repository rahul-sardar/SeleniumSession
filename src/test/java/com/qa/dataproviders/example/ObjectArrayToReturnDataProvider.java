package com.qa.dataproviders.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ObjectArrayToReturnDataProvider {

	@Test(dataProvider = "objectData1")
	public void testData(String a, String b) {

		System.out.println(a + " - " + b);

	}

	@DataProvider(name = "objectData1")
	public String[][] dataSupplierOne() {

		String[][] data = { { "Biscuits", "Chocolate" }, { "Cookies", "Choco Chips" }, { "Drink", "Sprite" } };
		return data;

	}

	/*
	 * Now if you pass the below data to the test method then we will compiler
	 * error. since type cast is not possible. we are passing int data to string
	 * variable type
	 */
	@DataProvider(name = "objectData2")
	public int[][] dataSupplierTwo() {

		int[][] data = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		return data;

	}

	/*
	 * Now this Test can except any type of parameter without throwing a error.
	 * 
	 */
	@Test(dataProvider = "objectData3")
	public void testData2(Object a, Object b, Object c) {

		System.out.println(a + " - " + b + " - " + c);

	}

	/*
	 * Now in below data provider try to change array data type to Integer, Or
	 * String Or Boolean We will get a syntax error We cannot store different type
	 * of data in Integer, String type of array But we can store under object array
	 * Object Class is parent class of all the classes in java, so we can store any
	 * type of data here.
	 */
	@DataProvider(name = "objectData3")
	public Object[][] dataSupplierThree() {

		Object[][] data = { { 1, "Test", true }, { 2, "Negative", false }, { 3, "NotTest", true } };
		return data;

	}

	/*
	 * What the reason to return - No need to worry about what type of data we are
	 * storing in 2d array. Also we can convert according to type of data that been
	 * passed.
	 * 
	 * Integration with External Data Sources: In real-world testing scenarios, test
	 * data often comes from external sources such as databases, spreadsheets, or
	 * APIs. By returning an object array, you can integrate TestNG with these
	 * external data sources more seamlessly, as you can transform the retrieved
	 * data into object arrays for consumption by your test methods.
	 * 
	 * Test Case Variability: Different test cases may require different sets of
	 * input parameters. Returning an object array allows you to handle this
	 * variability efficiently, ensuring that each test case receives the
	 * appropriate parameters for accurate testing and validation.
	 */

}
