package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUP {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("http://demo.guru99.com/test/upload/");
			Thread.sleep(5000);
			
			driver.findElement(By.name("uploadfile_0")).sendKeys("/Users/rahulmac/Downloads/tenor1.gif");

	}

}
