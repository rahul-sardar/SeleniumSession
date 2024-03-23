package com.qa.dataproviders.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenLogin {
	@Test(dataProvider = "dataSupplier")
	public void verifyLogin(String email, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();

	}

	@DataProvider
	public String[][] dataSupplier() {

		String[][] data = {  
							{ "amotooricap3@gmail.com", "12345" },
							{ "amotooricap1@gmail.com", "12345" },
							{"testabc@yopmail.com", "12345"}

		};
		return data;

	}
}
