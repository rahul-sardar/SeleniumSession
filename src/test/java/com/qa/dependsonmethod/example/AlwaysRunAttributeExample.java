package com.qa.dependsonmethod.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlwaysRunAttributeExample {
	
	WebDriver driver;
	By firstNameInput = By.cssSelector("#input-firstname");
	By lastNameInput = By.id("input-lastname");
	By submitButton = By.xpath("//input[@type='submit']");	
	By searchInput = By.name("search");
	By searchButton = By.cssSelector("#search button");
	By editLink = By.linkText("Edit your account information");
			

    @BeforeClass
    public void setUp() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
    }
    
    @Test
    public void login() {
    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        
        driver.findElement(By.id("input-email")).sendKeys("testabc@yopmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(submitButton).click();
        Assert.assertTrue(driver.findElement(editLink).isDisplayed());

    }

    @Test(dependsOnMethods = "login",  alwaysRun=true)
    public void testAddProductToCart() {
        // Search for the product "hp"
        
        driver.findElement(searchInput).sendKeys("hp");
        driver.findElement(searchButton).click();

        // Click on the product link
       
        driver.findElement(By.xpath("//h4/a[contains(text(),'HP')]")).click();

        // Add the product to the wishlist
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
        
        // Verify if the product is added to the wishlist
        WebElement successMessage = driver.findElement(By.cssSelector("#product-product .alert-dismissible"));
        Assert.assertTrue(successMessage.getText().trim().contains("Success: You have added"));
    }

    @Test(dependsOnMethods = {"login", "testAddProductToCart"}, alwaysRun=true)
    public void testRemoveProductFromCart() {
        // Go to the cart page
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/wishlist");

        // Remove the product from the cart
        driver.findElement(By.xpath("//a[@data-original-title= 'Remove']")).click();

        // Verify if the product is removed from the cart
        String emptyCartMessage = driver.findElement(By.cssSelector("#account-wishlist .alert-dismissible")).getText().trim();
        Assert.assertTrue(emptyCartMessage.contains("Success: You have modified your wish list"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}


/*
 * Now at some situation even though test method which are depending on is failing
 * then also we want to run the dependent method
 * then we can use "alwaysrun" attribute
 * Dependent test wont skip even though main test fails
 */ 
