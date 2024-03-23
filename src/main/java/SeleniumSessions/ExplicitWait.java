package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
			
			
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		  wait.until(ExpectedConditions.titleContains("ExplicitlyWait"));
		  System.out.println(driver.getTitle());
		
		  driver.findElement(By.id("display-other-button")).click();
		
		
		
		  By hiddenButton = By.id("hidden"); 
		  wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.elementToBeClickable(hiddenButton));
		  System.out.println(driver.findElement(By.xpath("//button[@id='hidden']")).getText());
		  
		  driver.navigate().to("https://app.hubspot.com/login");
		  UtilityClass util = new UtilityClass(driver);
		  util.waitforpresenceoftitle("HubSpot Login", 10);
		  
		  driver.quit();

		 
		

	}

}
