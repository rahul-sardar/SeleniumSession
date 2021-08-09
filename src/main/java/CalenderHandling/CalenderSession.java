package CalenderHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderSession {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.get("");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}

}
