package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
	
	WebDriver driver;
	public UtilityClass(WebDriver driver) {
		this.driver= driver;
	}
	
	/**
	 * This method will find an element if we pass an 
	 * by locator to it.
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element =driver.findElement(locator);
		return element;
	}
	
/**
 * This Method will use fluent wait for an element to be located	
 * @param driver
 * @param locator
 * @param timeout
 * @param pollingtime
 * @return
 */
	public static WebElement fluentwaitforElement(WebDriver driver, final By locator, int timeout, int pollingtime ) {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofSeconds(pollingtime))
	            .ignoring(NoSuchElementException.class);
			WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			    @Override
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
		    });
			return element;
	
	}
	/**
	 * This Method Explicit wait for presence of element
	 * This Method Pass if it found an element on dom
	 * It doesn't check on webpage fot that use ExpectedConditions.visibleOf();
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitforpresenceofelement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getElement(locator); //It will return weblelement for that particular locator
	}
	
	public String waitforpresenceoftitle(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.titleIs(title));
        return driver.getTitle(); //It will return weblelement for that particular locator
	}
	
	public WebElement waitforelementtobeclickable(By locator, int timeout) {
		WebElement element= getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
         
	}
	
	public WebElement waitforelementtobevisible(By locator, int timeout) {
		WebElement element= getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
         
	}
	
	public void mouseHoverAnElement(By locator) {
		Actions action = new Actions(driver);
		
		action.moveToElement(getElement(locator)).build().perform();
         
	}

	
	public  static void takescreenshots(WebDriver driver,String filename) {
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshotfile, new File("./target/ScreenShots/"+filename+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		
	}
	
}
