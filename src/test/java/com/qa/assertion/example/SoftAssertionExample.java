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
