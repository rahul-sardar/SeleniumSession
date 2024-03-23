
package com.qa.parallelexecution.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationEmailRegisterErrorTest {

	WebDriver driver;
	String baseUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";

	// By locators
	By firstNameInput = By.id("input-firstname");
	By lastNameInput = By.id("input-lastname");
	By emailInput = By.id("input-email");
	By telephoneInput = By.id("input-telephone");
	By passwordInput = By.id("input-password");
	By confirmPasswordInput = By.id("input-confirm");
	By privacyPolicyCheckbox = By.name("agree");
	By continueButton = By.cssSelector("input[type='submit'][value='Continue']");
	By privacyAgreeErrorMessage = By.xpath("//div[contains(@class, 'alert-dismissible')]");

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testRegistration() {
		System.out.println("Thread ID in test method" + getClass().getSimpleName() + ": " + Thread.currentThread().getId());
		// Open the registration page
		driver.get(baseUrl);

		// Fill in registration form
		driver.findElement(firstNameInput).sendKeys("John");
		driver.findElement(lastNameInput).sendKeys("Doe");
		driver.findElement(emailInput).sendKeys("johndoe@example.com");
		driver.findElement(telephoneInput).sendKeys("1234567890");
		driver.findElement(passwordInput).sendKeys("password123");
		driver.findElement(confirmPasswordInput).sendKeys("password123");
		driver.findElement(privacyPolicyCheckbox).click();
		driver.findElement(continueButton).click();
		String warningMessage = driver.findElement(privacyAgreeErrorMessage).getText().trim();

		// Wait for registration success message
		Assert.assertEquals(warningMessage, "Warning: E-Mail Address is already registered!");

	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
