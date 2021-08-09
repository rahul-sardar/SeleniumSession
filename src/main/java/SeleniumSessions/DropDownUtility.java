package SeleniumSessions;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {
	
	/**
	 * This Function will select a particular value from dropdown list.
	 * @param element
	 * @param value
	 */
	public static void selectValueFromDropDownList (WebElement element,String value){
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	/**
	 * This Method will return all the option present in dropdown 
	 * @param element
	 */
	public static ArrayList<String> getDropDownValues (WebElement element){
		System.out.println("=================================");
		ArrayList<String> arrayList = new ArrayList<String>() ;
		Select select = new Select(element);
		List<WebElement> droplist= select.getOptions();
		System.out.println("Total number of values in dropdown is "+droplist.size()); 
		
		for(int i=0; i<droplist.size(); i++) {
		String text= droplist.get(i).getText();
		arrayList.add(text);
		//System.out.println(text);
		
	}
    return arrayList;
	}
	
	
	/**
	 * This method is used to select value from dropdown without using select class
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public static void selectdropdownwithoutselect(WebDriver driver, String locator, String value) {
		List<WebElement> dropList = driver.findElements(By.xpath(locator));
		System.out.println("Total Number of elements present in dropdown is "+dropList.size());
		
		for(int i=0; i<dropList.size(); i++) {
			String text= dropList.get(i).getText();
			System.out.println(text);
			if(text.equals(value)) {
				dropList.get(i).click();
			}
		}
	}
}