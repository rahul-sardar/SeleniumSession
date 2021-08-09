package SeleniumSessions;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowMultiplePopUpHandle {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		driver.findElement(By.linkText("Like us On Facebook")).click();
		
		/*
		 * Now there are three windows open after above steps
		 * will use getwindowHandles() to get windows id of all the open windows
		 * getWindowHandle() to get window handle of current open window
		 */
		
		
		
		  Set<String> handler = driver.getWindowHandles(); 
		  Iterator<String> itr =handler.iterator();
		  
		  String parentWinId = itr.next(); System.out.println("Parent Window Id is: "
		  +parentWinId);
		  
		  String childWinId1 = itr.next(); System.out.println("Child Window Id 1 is: "
		  +childWinId1);
		  
		  driver.switchTo().window(childWinId1);
		  System.out.println("Page Title of Child Window 1 is: "+driver.getTitle());
		  driver.close();
		  
		  driver.switchTo().window(parentWinId);
		  System.out.println("Page Title of Parent Window is: "+driver.getTitle());
		  
		  driver.findElement(By.linkText("Follow On Twitter")).click();
		  Thread.sleep(5000);
		  
		  handler = driver.getWindowHandles(); itr =handler.iterator();
		  
		  parentWinId = itr.next();
		  System.out.println("Parent Window Id is: "+parentWinId);
		  
		  String childWinId2 = itr.next();
		  System.out.println("Child Window Id 2 is: "+childWinId2);
		  
		  driver.switchTo().window(childWinId2);
		  System.out.println("Page Title of Child Window 2 is: "+driver.getTitle());
		  driver.close();
		  
		  driver.switchTo().window(parentWinId);
		  System.out.println("Page Title of Parent Window is: "+driver.getTitle());
		  driver.close();
		 
		
	}

}
