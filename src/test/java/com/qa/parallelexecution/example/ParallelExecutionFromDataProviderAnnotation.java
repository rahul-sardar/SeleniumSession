package com.qa.parallelexecution.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExecutionFromDataProviderAnnotation {
	
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

	@DataProvider(parallel=true)
	public String[][] dataSupplier() {

		String[][] data = {  
							{ "amotooricap3@gmail.com", "12345" },
							{ "amotooricap1@gmail.com", "12345" },
							{"testabc@yopmail.com", "12345"},
							{ "amotooricap3@gmail.com", "12345" },
							{ "amotooricap1@gmail.com", "12345" },
							{"testabc@yopmail.com", "12345"}

		};
		return data;

	}
/*
 * If we run this test class directly we will observe 6 browser will open. so parallel execution will
 * happen for each data set.
 * 
 * Now we can control how much parallelism needed for the program. From XML at the suite 
 * Level we can give one flag data-provider-thread-count = 2 then at once 2 browser will 
 * open and once the test is finished the respective browser will be closed and next 2 browser will
 * open.
 */

}
