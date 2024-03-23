package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestWithAnnotation {


	WebDriver driver;

	By emailID = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By headerLogin = By.xpath("(//h2)[2]");
	By headerMyAccount = By.xpath("//div[@id='content']/h2[1]");

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
	public void setup() throws Exception {
		System.out.println("Before Method ...SetUp method Running");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();  
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	  
	}

	@Test(priority = 1)
	public void loginPageTest() {
		System.out.println("Test Method 1");
		Assert.assertEquals(driver.findElement(headerLogin).getText(), "Returning Customer");

	}

	@Test(priority = 2 /* ,enabled = false*/) 
	public void titleTest() {
		System.out.println("Test Method 2");
		String title = driver.getTitle();
		System.out.println("Page Title is: "+title);
		Assert.assertEquals(title, "Account Login");

	}

	@Test(priority=3 /* ,enabled = false*/)
	public void loginUser() {
		driver.findElement(emailID).sendKeys("abcdef@yopmail.com");
		driver.findElement(password).sendKeys("Testgma@1");
		driver.findElement(loginButton).click();
		String homePageHeader= driver.findElement(headerMyAccount).getText();
		Assert.assertEquals(homePageHeader, "My Account");
	}  

	@AfterMethod
	public void tearDown() {
		System.out.println("After Method Running");
		driver.close();
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


