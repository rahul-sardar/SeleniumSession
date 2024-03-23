package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionExampleTests {
	
	
	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	    }

	    @Test
	    public void testAssertEquals() {
	        String expectedTitle = "Register Account";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle);
	    }

	    @Test
	    public void testAssertNotEquals() {
	        String expectedTitle = "Register";
	        String actualTitle = driver.getTitle();
	        Assert.assertNotEquals(actualTitle, expectedTitle);
	    }

	    @Test
	    public void testAssertTrue() {
	        boolean isEmailDisplayed = driver.findElement(By.id("input-email")).isDisplayed();
	        Assert.assertTrue(isEmailDisplayed);
	    }

	    @Test
	    public void testAssertFalse() {
	    	 boolean isAddressDisplayed = isElementPresent(By.id("input-address-1"));
	         Assert.assertFalse(isAddressDisplayed, "Address input field is displayed when it shouldn't be.");
	    }
	    
		/*
		 * Helper method to check if element is present If we directly use
		 * driver.findElement() and if element is not present the we will get the error
		 * as Unable to locate element and test case will fail.
		 */
	    private boolean isElementPresent(By by) {
	        try {
	            driver.findElement(by);
	            return true;
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return false;
	        }
	    }

	    @Test
	    public void testNullAssertion() {
	    	 // Simulating a scenario where the element's attribute value is null
	        String nullValue = null;  // For demonstration purposes
	        Assert.assertNull(nullValue, "The attribute value is null.");
	    }

	    @Test
	    public void testAssertNotNull() {
	        String defaultValue = driver.findElement(By.id("input-firstname")).getAttribute("value");
	        Assert.assertNotNull(defaultValue);
	    }

	    @Test
	    public void testAssertSame() {
	        String str1 = "Hello";
	        String str2 = "Hello";
	        Assert.assertSame(str1, str2);
	    }

	    @Test
	    public void testAssertNotSame() {
	        String str1 = new String("Hello");
	        String str2 = new String("Hello");
	        Assert.assertNotSame(str1, str2);
	    }

	    @Test
	    public void testAssertFail() {
	        Assert.fail("This test intentionally fails");
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	    
	    
	

}

/*
 * testAssertEquals(): Checks if two values are equal. 
 * testAssertNotEquals(): Verifies if two values are not equal. 
 * testAssertTrue(): Ensures a condition or statement is true. 
 * testAssertFalse(): Checks if a condition or statement is false. 
 * testAssertNull(): Verifies if a value or object is null.
 * testAssertNotNull(): Checks if a value or object is not null.
 * 
 * testAssertSame(): This assertion checks if two objects refer to the exact
 * same instance in memory. In Java, objects are stored in memory, and when you
 * assign an object to another variable, both variables point to the same memory
 * location. Using assertSame() asserts that both objects are indeed pointing to
 * the same memory location, indicating they are the same instance.
 * 
 * testAssertNotSame(): Conversely, this assertion checks if two objects do not
 * refer to the same instance in memory. If two objects are separate instances
 * (i.e., stored in different memory locations), assertNotSame() will pass,
 * indicating that they are distinct objects.
 * 
 * testAssertFail(): Fails the test intentionally with a custom message.
 */



