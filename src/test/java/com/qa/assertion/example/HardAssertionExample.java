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
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Login with credentials
		WebElement emailInput = driver.findElement(By.id("input-email"));
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
		By editLink = By.linkText("Edit your account information");

		emailInput.sendKeys("testabc@yopmail.com");
		passwordInput.sendKeys("12345");
		loginButton.click();
		driver.findElement(editLink).click();
		
	}

	@Test(priority=1)
	public void testEditAccountPageElements() throws InterruptedException {
		Thread.sleep(5);
		By firstNameInput = By.id("input-firstname");
		By lastNameInput = By.id("input-lastname");
		By emailInput = By.id("input-email");
		By telephoneInput = By.id("input-telephone");
		By continueButton = By.cssSelector("input[value='Continue']");
		By firstNameErrorLocator = By.cssSelector("#input-firstname + .text-danger");
		By lastNameErrorLocator = By.cssSelector("#input-lastname + .text-danger");
		By emailErrorLocator = By.cssSelector("#input-email + .text-danger");
		By telephoneErrorLocator = By.cssSelector("#input-telephone + .text-danger");
		
		driver.findElement(firstNameInput).clear();
		driver.findElement(lastNameInput).clear();
		driver.findElement(emailInput).clear();
		driver.findElement(telephoneInput).clear();
		driver.findElement(continueButton).click();
		
		
		
		

		Assert.assertTrue(driver.findElement(firstNameInput).isDisplayed(), "First name input field is not displayed.");
		Assert.assertTrue(driver.findElement(lastNameInput).isDisplayed(), "Last name input field is not displayed.");
		Assert.assertTrue(driver.findElement(emailInput).isDisplayed(), "Email input field is not displayed.");
		Assert.assertTrue(driver.findElement(telephoneInput).isDisplayed(), "Telephone input field is not displayed.");
		Assert.assertTrue(driver.findElement(continueButton).isDisplayed(), "Continue button is not displayed.");
		
		Assert.assertEquals(driver.findElement(telephoneErrorLocator).getText().trim(), "");
		Assert.assertEquals(driver.findElement(firstNameErrorLocator).getText().trim(), "");
		Assert.assertEquals(driver.findElement(lastNameErrorLocator).getText().trim(), "");
		Assert.assertEquals(driver.findElement(emailErrorLocator).getText().trim(), "");
		
	}

	@Test(priority=2)
	public void testEditAccountPageTitle() {
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/editoo";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualTitle, expectedTitle, "Incorrect page title on edit account page.");
		Assert.assertEquals(actualURL, expectedURL, "Incorrect URL on edit account page.");
		
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