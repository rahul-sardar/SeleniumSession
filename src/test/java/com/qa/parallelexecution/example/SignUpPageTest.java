package com.qa.parallelexecution.example;

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

public class SignUpPageTest {

	WebDriver driver;

	By registerAccHeading = By.cssSelector("div#content>h1");
	By formVisible = By.xpath("(//form[@method='post'])[2]");
	By continueButton = By.cssSelector("input.btn-primary");
	By privacyPolicy = By.name("agree");
	
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

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void registerHeadingTest() {
		System.out.println("Thread ID in test method " + getClass().getSimpleName() + ": " + Thread.currentThread().getId());
		System.out.println("Test Method 1");
		Assert.assertTrue(driver.findElement(registerAccHeading).isDisplayed());

	}

	@Test(priority = 2)
	public void formDisplayed() {
		System.out.println("Test Method 2");
		Assert.assertTrue(driver.findElement(formVisible).isDisplayed());

	}

	@Test(priority = 3)
	public void privacyPolicyDisplayed() {
		System.out.println("Test Method 3");
		Assert.assertTrue(driver.findElement(privacyPolicy).isDisplayed());

	}

	@Test(priority = 4)
	public void continueButtonDisplayed() {
		System.out.println("Test Method 4");
		Assert.assertTrue(driver.findElement(continueButton).isDisplayed());

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	

}
