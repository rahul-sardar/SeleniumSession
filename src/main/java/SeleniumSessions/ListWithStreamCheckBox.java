package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWithStreamCheckBox {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Getting all the links present on the page 
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='example']//td[@class=' select-checkbox']"));
		checkBoxList.stream().forEach(ele -> ele.click());
		
	}
}
