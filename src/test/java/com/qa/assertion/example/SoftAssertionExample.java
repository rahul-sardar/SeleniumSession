package com.qa.assertion.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {

	WebDriver driver;
	SoftAssert softAssert;

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
		softAssert = new SoftAssert();
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
		
		
		
		

		softAssert.assertTrue(driver.findElement(firstNameInput).isDisplayed(), "First name input field is not displayed.");
		softAssert.assertTrue(driver.findElement(lastNameInput).isDisplayed(), "Last name input field is not displayed.");
		softAssert.assertTrue(driver.findElement(emailInput).isDisplayed(), "Email input field is not displayed.");
		softAssert.assertTrue(driver.findElement(telephoneInput).isDisplayed(), "Telephone input field is not displayed.");
		softAssert.assertTrue(driver.findElement(continueButton).isDisplayed(), "Continue button is not displayed.");
		
		softAssert.assertEquals(driver.findElement(telephoneErrorLocator).getText().trim(), "");
		softAssert.assertEquals(driver.findElement(firstNameErrorLocator).getText().trim(), "");
		softAssert.assertEquals(driver.findElement(lastNameErrorLocator).getText().trim(), "");
		softAssert.assertEquals(driver.findElement(emailErrorLocator).getText().trim(), "");
		softAssert.assertAll(); // Collects and reports all assertion failures
	}

	@Test(priority=2)
	public void testEditAccountPageTitle() {
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/editoo";
		String actualURL = driver.getCurrentUrl();
		softAssert.assertEquals(actualTitle, expectedTitle, "Incorrect page title on edit account page.");
		softAssert.assertEquals(actualURL, expectedURL, "Incorrect URL on edit account page.");
		softAssert.assertAll(); // Collects and reports all assertion failures
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

/*
 * 
 * 
In TestNG, hard assertions and soft assertions are used to validate expected outcomes in test cases, 
but they differ in how they handle test failures and continue the execution of subsequent assertions or test steps.

Hard Assertion in TestNG:
Definition: Hard assertions in TestNG are provided by the Assert class. They are traditional assertions 
that immediately stop the test execution when they fail by throwing an exception (typically AssertionError).
Behavior: When a hard assertion fails, TestNG marks the test as failed and stops executing further assertions 
or test steps within the same test method.

Usage:
Hard assertions are suitable for critical validations where failure indicates a serious issue in the test scenario 
or the application under test.
They are commonly used for validations that are essential for the test case's success and where proceeding with the 
test would be meaningless if the validation fails.

Soft Assertion in TestNG:
Definition: Soft assertions in TestNG are provided by the SoftAssert class or by using Assert with TestNG.assertAll() method. 
They allow the execution of multiple assertions within a test method, even after one or more assertions fail.
Behavior: With soft assertions, TestNG collects all assertion failures but continues executing subsequent assertions and 
test steps. At the end of the test method, TestNG reports a summary of all assertion failures.
Usage:
Soft assertions are useful when you want to verify multiple conditions in a single test case and gather a comprehensive list of 
failures rather than halting at the first encountered failure.
They are beneficial in scenarios where you want to collect and report all validation issues before marking the test as failed.
 */
