package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
	  
	  @BeforeTest
	  @Parameters({"urlRegister" , "browser"})
	  public void setup(String urlHere, String browser) throws Exception {
		  System.out.println("Before Test ...SetUp method Running");
		  System.out.println("Thread ID in " + getClass().getSimpleName() + ": " + Thread.currentThread().getId());

		  if(browser.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();  
		  }else if(browser.equalsIgnoreCase("firefox")){
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		  }else {
			  System.out.println("Invalid Browser Passed !! Valid Browser are Chrome And Firefox");
			  throw new Exception("NoSuchBrowserException");
		  }
          driver.get(urlHere);
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();	
		  
	  }
	  

	  @Test(priority=1)
	  public void registerHeadingTest() {
		  System.out.println("Test Method 1");
		  Assert.assertTrue(driver.findElement(registerAccHeading).isDisplayed());
		  
	  }
	  
	  @Test(priority=2)
	  public void formDisplayed() {
		  System.out.println("Test Method 2");
		  Assert.assertTrue(driver.findElement(formVisible).isDisplayed());
		  
	  }
	  
	  @Test(priority=3)
	  public void privacyPolicyDisplayed() {
		  System.out.println("Test Method 3");
		  Assert.assertTrue(driver.findElement(privacyPolicy).isDisplayed());
		  
	  }

	  @Test(priority=4)
	  public void continueButtonDisplayed() {
		  System.out.println("Test Method 4");
		  Assert.assertTrue(driver.findElement(continueButton).isDisplayed());
		  
	  }
	  
	  @AfterTest
	  public void tearDown() {
		  driver.close();
	  }



}
