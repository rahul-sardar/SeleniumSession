package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWithStreamExample {

	public static void main(String[] args) {
		long startTime;
		long endTime;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Getting all the links present on the page 
		List<WebElement> linkslistAllLinks = driver.findElements(By.tagName("a"));
		linkslistAllLinks.addAll(driver.findElements(By.tagName("img")));
		
		By linksList = By.tagName("a");
		List<WebElement> industry_list = driver.findElements(linksList);
		industry_list.stream().forEach(ele -> System.out.println(ele.getText()));
		System.out.println(industry_list.size());
		
		List<String> collectListName= industry_list.
				stream()
				   .filter(ele -> !ele.getText().equals("") && !ele.getText().equals(""))
				     .map(ele -> ele.getText())
				       .collect(Collectors.toList());
		collectListName.stream().forEach(ele -> System.out.println(ele));
		System.out.println(collectListName.size());
		
		List<String> collectListURL= linkslistAllLinks.
				stream()
				   .filter(ele -> ele.getAttribute("href")!= null && !ele.getAttribute("href").equals(""))
				     .map(ele -> ele.getAttribute("href"))
				       .collect(Collectors.toList());
		collectListURL.stream().forEach(ele -> System.out.println(ele));
		System.out.println(collectListURL.size());

	}

}
