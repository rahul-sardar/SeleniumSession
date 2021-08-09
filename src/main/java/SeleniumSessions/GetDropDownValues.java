package SeleniumSessions;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDropDownValues {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		//driver.manage().window()
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(5000);
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		
        /*selectValueFromDropDownList(day, "1");
        selectValueFromDropDownList(month, "Feb");
        selectValueFromDropDownList(year, "1996");
        getDropDownValues(day);
        getDropDownValues(month);
        getDropDownValues(year);*/
		
		//Here we have created separate class DropDownUtility
		//and call methds
		DropDownUtility.selectValueFromDropDownList(day, "23");
		DropDownUtility.selectValueFromDropDownList(month, "Feb");
		DropDownUtility.selectValueFromDropDownList(year, "1995");
		
		ArrayList<String> dayValues= DropDownUtility.getDropDownValues(day);
		System.out.println(dayValues);
		
		ArrayList<String> monthValues=DropDownUtility.getDropDownValues(month);
		System.out.println(monthValues);
		
		ArrayList<String> yearValues=DropDownUtility.getDropDownValues(year);
		System.out.println(yearValues);

        driver.close();
	}
	
	 
	/*public static void selectValueFromDropDownList (WebElement element,String value){
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	public static void getDropDownValues (WebElement element){
		System.out.println("=================================");
		Select select = new Select(element);
		List<WebElement> droplist= select.getOptions();
		System.out.println("Total number of values in dropdown is "+droplist.size()); 
		for(int i=0; i<droplist.size(); i++) {
		String text= droplist.get(i).getText();
		System.out.println(text);
		
	}*/

}
