package com.qa.ignoreatpackagelevel.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnotherDemoClass {

	@BeforeClass
	public void setUpClass() {
		System.out.println("BeforeClass: Executed once before the first test method in this class.");
	}

	@AfterClass
	public void tearDownClass() {
		System.out.println("AfterClass: Executed once after all test methods in this class.");
	}

	@BeforeMethod
	public void setUp() {
		System.out.println("BeforeMethod: Executed before each test method.");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("AfterMethod: Executed after each test method.");
	}

	@Test
	public void testMethod6() {
		System.out.println("TestMethod6: Executing test method 6.");
		int[] numbers = { 1, 2, 3, 4, 5 };
		Assert.assertEquals(numbers.length, 5);
	}

	@Test
	public void testMethod7() {
		System.out.println("TestMethod7: Executing test method 7.");
		String str = "TestNG";
		Assert.assertTrue(str.contains("NG"));
	}

	@Test
	public void testMethod8() {
		System.out.println("TestMethod8: Executing test method 8.");
		Assert.assertNotNull(new Object());
	}

	@Test
	public void testMethod9() {
		System.out.println("TestMethod9: Executing test method 9.");
		double result = 10 / 2;
		Assert.assertEquals(result, 5.0);
	}


}
