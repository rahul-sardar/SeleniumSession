package com.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.listeners.example.MyRetryAnalyzer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetryFailedTestCases {
	
	public WebDriver driver = null;
	By emailID = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By headerLogin = By.xpath("(//h2)[2]");
	By headerMyAccount = By.xpath("//div[@id='content']/h2[1]");
	By warningMesssage = By.xpath("//div[contains(@class,'alert-dismissible')]");

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1,retryAnalyzer= MyRetryAnalyzer.class)
	public void loginWithValidCredential() {
		driver.findElement(emailID).sendKeys("testabc@yopmail.com");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(loginButton).click();
		String homePageHeader = driver.findElement(headerMyAccount).getText();
		Assert.assertEquals(homePageHeader, "My Account");
	} 

	@Test(priority = 2, retryAnalyzer= MyRetryAnalyzer.class)
	public void logibWithInvalidEmailandInvalidPassword() {
		driver.findElement(emailID).sendKeys("testabcIdontknow@yopmail.com");
		driver.findElement(password).sendKeys("1234");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(warningMesssage).getText().trim()
				.contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@Test(priority = 3)
	public void logibWithInvalidEmailandValidPassword() {
		driver.findElement(emailID).sendKeys("testabcIdontknow@yopmail.com");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(warningMesssage).getText().trim()
				.contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@Test(priority = 4)
	public void loginWithInvalidCredentials() {
		driver.findElement(emailID).sendKeys("testabcIdontknow@yopmail.com");
		driver.findElement(password).sendKeys("1234ddasmmadmmas5");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(warningMesssage).getText().trim()
				.contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@Test(priority = 5)
	public void loginWithoutProvidingCredentials() {
		driver.findElement(emailID).sendKeys("");
		driver.findElement(password).sendKeys("");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(warningMesssage).getText().trim()
				.contains("Warning: No match for E-Mail Address and/or Password."));

	}


}
