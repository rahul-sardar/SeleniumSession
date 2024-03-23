package com.qa.parallelexecution.example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	By emailID = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By headerLogin = By.xpath("(//h2)[2]");
	By headerMyAccount = By.xpath("//div[@id='content']/h2[1]");
	
	@BeforeSuite
	public void testThreadIDAtSuiteLevel() {
		System.out.println("Thread ID in Before Suite " + getClass().getSimpleName() + ": " + Thread.currentThread().getId());
	}
	
	@BeforeClass
	public void testThreadIDAtClassLevel() {
		System.out.println("Thread ID in Before class " + getClass().getSimpleName() + ": " + Thread.currentThread().getId());
	}
	
	@BeforeMethod
	public void testThreadIDAtMethodLevel() {
		System.out.println("Thread ID in Before method " + getClass().getSimpleName() + ": " + Thread.currentThread().getId());
	}

	@BeforeTest
	public void setup() throws Exception {
		System.out.println("Before Test ...SetUp method Running");
		System.out.println("Thread ID in before test " + getClass().getSimpleName() + ": " + Thread.currentThread().getId());

		 WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void loginPageTest() {
		System.out.println("Thread ID in test method" + getClass().getSimpleName() + ": " + Thread.currentThread().getId());
		System.out.println("Test Method 1");
		Assert.assertEquals(driver.findElement(headerLogin).getText(), "Returning Customer");

	}

	@Test(priority = 2)
	public void titleTest() {
		System.out.println("Test Method 2");
		String title = driver.getTitle();
		System.out.println("Page Title is: " + title);
		Assert.assertEquals(title, "Account Login");
	}

	@Test(priority = 3)
	public void loginUser() {
		System.out.println("Test Method 3");
		driver.findElement(emailID).sendKeys("testabc@yopmail.com");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(loginButton).click();
		String homePageHeader = driver.findElement(headerMyAccount).getText();
		Assert.assertEquals(homePageHeader, "My Account");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
