package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class IgnoreAnnotationAtClassLevel {

	WebDriver driver;

	By emailID = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By headerLogin = By.xpath("(//h2)[2]");
	By headerMyAccount = By.xpath("//div[@id='content']/h2[1]");

	@BeforeMethod
	public void setup() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void loginPageTest() {
		Assert.assertEquals(driver.findElement(headerLogin).getText(), "Returning Customer");
	}

	@Test(priority = 2)
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title is: " + title);
		Assert.assertEquals(title, "Account Login");

	}

	@Test(priority = 3 )
	public void loginUser() {
		driver.findElement(emailID).sendKeys("abcdef@yopmail.com");
		driver.findElement(password).sendKeys("Testgma@1");
		driver.findElement(loginButton).click();
		String homePageHeader = driver.findElement(headerMyAccount).getText();
		Assert.assertEquals(homePageHeader, "My Account");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("After Method Running");
		driver.close();
	}

}

/*
 * Ignore annotation at class level will ignore all the test present inside that class.
 */
