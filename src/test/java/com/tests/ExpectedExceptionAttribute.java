package com.tests;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExpectedExceptionAttribute {
	
	WebDriver driver;
	
	@Test(priority=1, expectedExceptions= {NoSuchElementException.class})
	public void verifyExpection() {
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@title='My Account12345']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("testabc@yopmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();

	}
	
	@Test(priority=2, expectedExceptions= {ArithmeticException.class})
	public void verifyLogin() {
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@title='My Account']")).click();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	/*
	 * Used for negative testing. Generally used to check whether the particular exception coming or not 
	 * for a particular scenario. We have to verify for any particular expection to be thrown
	 * 
	 * If the mention exception didn't come in the test then we will get ExpectedExceptionAttribute exception and test case will fail.
	 */

}
