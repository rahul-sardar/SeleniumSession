package SeleniumSessions;

import java.time.Duration;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		//driver.manage().window().maximize();;
		//Thread.sleep(6000);
		final By phonenumber = By.name("username");
		By password = By.name("password");
		By loginButton = By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button");
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
		
		/*
		 * When I was using import java.util.NoSuchElementException; instead of import
		 * org.openqa.selenium.NoSuchElementException;., it was not ignoring NosuchElementException so please
		 * keep this in mind
		 */
         
		//We can use this below line also
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			    @Override
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(By.name("username"));
	            }
		 });
		  //Thread.sleep(6000);
		  foo .sendKeys("testgma@gmail.com");
		  driver.findElement(password).sendKeys("Testgma@1");
		  //driver.findElement(loginButton).click(); 
		  driver.quit();
	}


}
