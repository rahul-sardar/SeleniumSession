package com.qa.assertion.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HardAssertionExample {
	
	 WebDriver driver;
	 

	    @BeforeClass
	    public void setUp() {
	       
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @Test
	    public void testPageTitle() {
	        String expectedTitle = "OrangeHRM";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected title.");
	    }
	    
	    @Test
	    public void testLoginPageElements() {
	        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
	        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	        Assert.assertTrue(usernameInput.isDisplayed(), "Username input field is not displayed.");
	        Assert.assertTrue(passwordInput.isDisplayed(), "Password input field is not displayed.");
	        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed.");
	    }
	    
	    

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	     

}


/*
 * In TestNG, hard assertions and soft assertions are used to validate expected
 * outcomes in test cases, but they differ in how they handle test failures and
 * continue the execution of subsequent assertions or test steps.
 * 
 * Hard Assertion in TestNG: Definition: Hard assertions in TestNG are provided
 * by the Assert class. They are traditional assertions that immediately stop
 * the test execution when they fail by throwing an exception (typically
 * AssertionError). When a hard assertion fails, TestNG marks the test
 * as failed and stops executing further assertions or test steps within the
 * same test method. Usage: Hard assertions are suitable for critical
 * validations where failure indicates a serious issue in the test scenario or
 * the application under test. They are commonly used for validations that are
 * essential for the test case's success and where proceeding with the test
 * would be meaningless if the validation fails.
 * 
 * If a method has 2 or 3 assertion then if one of the assertion fails testng will stop executing code from 
 * the next line. It will mark the tc's as fail and move onto the next test method
 */