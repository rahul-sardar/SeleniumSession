package com.qa.dataproviders.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizingArrayParameter {
	@Test(dataProvider = "dataSupplier")
	public void verifyLogin(String [] data) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(data[0]);
		driver.findElement(By.id("input-password")).sendKeys(data[1]);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();

	}

	@DataProvider
	public String[][] dataSupplier() {

		String[][] data = {  
							{ "amotooricap3@gmail.com", "12345" },
							{ "amotooricap1@gmail.com", "12345" },
							{"testabc", "12345"}

		};
		return data;

	}
	
	/*
	 * If for every set of data in dataProvider we have a large number of data then instead of writing lots of parameter
	 * under test method , we can write a single dimensional array and catch the data over there
	 * Since we are passing string data we are using string array
	 */
}
