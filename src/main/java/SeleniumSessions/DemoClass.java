package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass {
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://wegodeliver.here.com/");
	driver.findElement(By.xpath("//*[text()='Skip']")).click();
	driver.findElement(By.xpath("//*[text()='Accept cookies']")).click();
	Thread.sleep(20000);
	driver.findElement(By.xpath("//input[@id='input-depot-loca']")).sendKeys("Hello there");


	}
}
