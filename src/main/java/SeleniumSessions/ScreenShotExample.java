package SeleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotExample {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		final By phonenumber = By.name("username");
		By password = By.name("password");
		By loginButton = By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button");
		
		WebElement element= UtilityClass.fluentwaitforElement(driver,phonenumber,20,3);
		
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(screenshotfile, new File("./target/ScreenShots/loginpage.png"));
		
		
		element.sendKeys("Testgma@gmail.com");
		driver.findElement(password).sendKeys("testgma@1");
		driver.findElement(loginButton).click();
		UtilityClass.takescreenshots(driver, "logindata");
		driver.quit();

	}

}
