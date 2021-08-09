package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	
	public static String getTitleByJS(WebDriver driver) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title= js.executeScript("return document.title;").toString();
		return title;
	}	
	
	/**
	 * To generate an alert on webpage
	 *
	 * @param driver
	 * @param message
	 */
	public static void generateAlertJS(WebDriver driver, String message) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('" + message + "')");
		
	}	
	
	public static void refreshBrowserByJS(WebDriver driver) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
		
	}	
	
	public static void sendKeysUsingIdJS(WebDriver driver, String Id, String Value) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('"+ Id +"').value='"+ Value +"'");
		
	}
	
	public static void clickElementByJS(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	/**
	 * It will navigate to url passed 
	 * @param driver
	 * @param Urlhere
	 */
	public static void navigateToUrlUsingJS(WebDriver driver,String Urlhere) {
		System.out.println(Urlhere);
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.location='"+Urlhere+"'");
		
	}	
	
	/**
	 * to navigate back to previous page
	 * @param driver
	 */
	public static void navigateBackToPreviousPageUsingJS(WebDriver driver) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(-1)");
		
	}	
	
	/**
	 * Its draws an border around an element 
	 * @param driver
	 * @param element
	 */
	public static void drawBorder(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border= '3px solid red'", element);
		
	}	
	
	
	
	/**
	 * Its used to FLASH an element on the webpage 
	 * sometimes we need to see where our driver control is present so this method can be used
	 * @param driver
	 * @param element
	 */
	public static void flash(WebDriver driver, WebElement element) {
	    String bgcolor= element.getCssValue("backgroundColor");
	    for(int i=0;i<10;i++) {
	    	changecolor("rgb(199,16,49)", driver, element);
	    	changecolor(bgcolor, driver, element);
	    }
		
	}
	
	
	/**
	 * This method change the background color of the passed element
	 * it is made private so outside the class it become inaccessible
	 * @param color
	 * @param driver
	 * @param element
	 */
	private static void changecolor(String color, WebDriver driver, WebElement element) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		
	}
	
	/**
	 * It will scroll till bottom of the webpage
	 * 
	 * @param driver
	 */
	public static void scrollPageDown(WebDriver driver) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	
	/**
	 * Scroll till it find the element
	 * JavaScript method scrollIntoView() scrolls the page until the mentioned
	 *  element is in full view 
	 * @param driver
	 * @param element
	 */
	public static void scrollIntoView(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	
	
	/**
	 * This method will return all the text present on the page
	 * @param driver
	 * @return
	 */
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	
	
	
	/**
	 * executeScript("window.scrollBy(x-pixels,y-pixels)");
     x-pixels is the number at x-axis, it moves to the left if number is positive and 
     it move to the right if number is negative .y-pixels is the number at y-axis, 
     it moves to the down if number is positive and it move to the up 
     if number is in negative .
	 * @param driver
	 * @param pixels
	 */
	public static void scrollByPixels(WebDriver driver, String xpixels, String ypixels) {
	    JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy('"+xpixels+"', '"+ypixels+"')");
		
	}
	
}
