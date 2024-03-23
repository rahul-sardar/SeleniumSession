package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestWithOptionalParameterFromXml {
	WebDriver driver;

	By emailID = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By headerLogin = By.xpath("(//h2)[2]");
	By headerMyAccount = By.xpath("//div[@id='content']/h2[1]");

	@BeforeTest
	@Parameters({ "urlLogin", "browser" })
	public void setup(@Optional("https://tutorialsninja.com/demo/index.php?route=account/login") String url, String browserName) throws Exception {
		System.out.println("Before Test ...SetUp method Running");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser Passed !! Valid Browser are Chrome And Firefox");
			throw new Exception("NoSuchBrowserException");
		}
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginPageTest() {
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
	@Parameters({ "username", "password" })
	public void loginUser(String userID, String pwd) {
		System.out.println("Test Method 3");
		driver.findElement(emailID).sendKeys(userID);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		String homePageHeader = driver.findElement(headerMyAccount).getText();
		Assert.assertEquals(homePageHeader, "My Account");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
