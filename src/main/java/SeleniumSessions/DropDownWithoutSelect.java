package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		//driver.manage().window()
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(5000);
		String locatorday= "//select[@id='day']/option";
		String locatormonth= "//select[@id='month']/option";
		String locatoryear= "//select[@id='year']/option";

		
		DropDownUtility.selectdropdownwithoutselect(driver, locatorday, "5");
		DropDownUtility.selectdropdownwithoutselect(driver, locatormonth, "Feb");
		DropDownUtility.selectdropdownwithoutselect(driver, locatoryear, "1996");



	}

}
