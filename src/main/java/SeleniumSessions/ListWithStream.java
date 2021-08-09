package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWithStream {

	public static void main(String[] args) {
		
		long startTime;
		long endTime;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		By industry_options = By.xpath("//select[@name='Industry']/option");
		List<WebElement> industry_list = driver.findElements(industry_options);
		
		//For Sequential Stream
		startTime = System.currentTimeMillis();
		industry_list.stream().forEach(ele -> System.out.println(ele.getText()));
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken for sequential stream is  "+(endTime-startTime));
		
		
		//For Parallel Stream
		startTime = System.currentTimeMillis();
		industry_list.stream().forEach(ele -> System.out.println(ele.getText()));
		endTime = System.currentTimeMillis();
		System.out.println("Time Taken for Parallel stream is  "+(endTime-startTime));
		
	}

}
