package com.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ReportsDemoTest {

			  @BeforeSuite
			  public void beforeSuite() {
				  System.out.println("Before Suite Method....Prepare the test data");
			  }
			  
			  @BeforeTest
			  public void beforeTest() {
				  System.out.println("Before Test Method....Start The DB Connection");
			  }
			  
			  @BeforeClass
			  public void beforeClass() {
				  System.out.println("Before Class Method....Get the Value from DB");
			  }
			  
			  @BeforeMethod
			  public void beforeMethod() throws Exception {
				  System.out.println("Before Method ");
			  }
			  
			  @Test(priority = 1)
			  public void test1() {
				  System.out.println("Test Method 1");  
			  }
			  
			  @Test(priority = 2 /* ,enabled = false*/) 
			  public void test2() {
				  System.out.println("Test Method 2");  
			  }
			  
			  @Test(priority=3 /* ,enabled = false*/)
			  public void test3() {
					 System.out.println("Test Method 3");
			  }  
			  
			 @AfterMethod
			 public void tearDown() {
				  System.out.println("After Method Running");
			 }
			 
			 @AfterClass
			 public void afterClass() {
				  System.out.println("After Class Method....Delete the user");
			 }
			 
			 @AfterTest
			 public void afterTest() {
				  System.out.println("After Test Method....Disconnect the DB");
			 }
			 
			  @AfterSuite
			  public void afterSuite() {
				  System.out.println("After Suite Method....Delete the test data");
			  }

	
	
	
}
