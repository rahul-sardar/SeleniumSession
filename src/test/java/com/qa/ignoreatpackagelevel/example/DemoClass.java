package com.qa.ignoreatpackagelevel.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoClass {

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
	public void testMethod1() {
		System.out.println("TestMethod1: Executing test method 1.");
		Assert.assertEquals(2 + 2, 4);
	}

	@Test
	public void testMethod2() {
		System.out.println("TestMethod2: Executing test method 2.");
		String str1 = "Hello";
		String str2 = "Hello";
		Assert.assertEquals(str1, str2);
	}

	@Test
	public void testMethod3() {
		System.out.println("TestMethod3: Executing test method 3.");
		Assert.assertTrue(true);
	}

	@Test
	public void testMethod4() {
		System.out.println("TestMethod4: Executing test method 4.");
		Assert.assertFalse(false);
	}

	@Test
	public void testMethod5() {
		System.out.println("TestMethod5: Executing test method 5.");
		Assert.assertNotEquals(10, 5);
	}

}
