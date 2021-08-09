package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		By mouseHoverLocator= By.id("nav-link-accountList");
		By signUp = By.linkText("Sign in");
		System.out.println("Title of the Page is = " +JavaScriptUtility.getTitleByJS(driver));
		
		UtilityClass util = new UtilityClass(driver);
		util.mouseHoverAnElement(mouseHoverLocator);
		util.waitforelementtobevisible(signUp, 10);
		WebElement signUpelement= util.getElement(signUp);
		JavaScriptUtility.clickElementByJS(driver, signUpelement);

		
		JavaScriptUtility.sendKeysUsingIdJS(driver, "ap_email", "rahulsardar7021@gmail.com");
		WebElement createAccountButton= driver.findElement(By.linkText("Create your Amazon account"));
		WebElement continueButton=driver.findElement(By.id("continue"));
		JavaScriptUtility.drawBorder(driver, continueButton);
		JavaScriptUtility.flash(driver, createAccountButton);
		JavaScriptUtility.navigateBackToPreviousPageUsingJS(driver);
		JavaScriptUtility.scrollPageDown(driver);
		JavaScriptUtility.scrollByPixels(driver, "0","-1000");
		
		
		/*
		 * //With the help of actions class we can scroll top //and bottom of the page
		 * Actions actions = new Actions(driver); // Page Down
		 * actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform(); // Page Up
		 * actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		 */
		
		
		
		
		
		JavaScriptUtility.navigateToUrlUsingJS(driver,"https://www.facebook.com/");
		System.out.println("Title of the Page is = " +JavaScriptUtility.getTitleByJS(driver));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement createAccountButtonFB= driver.findElement(By.linkText("Create New Account"));
		JavaScriptUtility.flash(driver, createAccountButtonFB);
		JavaScriptUtility.navigateBackToPreviousPageUsingJS(driver);
		System.out.println(JavaScriptUtility.getPageInnerText(driver));
		JavaScriptUtility.generateAlertJS(driver, "This Is Amazon Page");
	}

}
