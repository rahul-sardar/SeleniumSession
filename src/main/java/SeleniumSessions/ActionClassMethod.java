package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);
		WebElement mouseHoverElement1 = driver.findElement(By.id("ctl00_HyperLinkLogin"));
		
        //Handling Mouse hover
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverElement1).build().perform();
		Thread.sleep(2000);
		WebElement mouseHoverElement2 = driver.findElement(By.linkText("SpiceClub Members"));
		action.moveToElement(mouseHoverElement2).build().perform();
		Thread.sleep(2000);
		
		String text= driver.findElement(By.linkText("Member Login")).getText();
		System.out.println(text);
		
		//Handling Right click element
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightclickelement = driver.findElement(By.className("context-menu-one"));
		action.contextClick(rightclickelement).build().perform();
		String text2= driver.findElement(By.xpath("//ul/li[contains(@class, 'context-menu-icon-copy')]/span")).getText();
		System.out.println(text2);

		//Hnadling Drag and drop
		driver.navigate().to("https://demoqa.com/droppable/");
		Thread.sleep(3000);
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		action.clickAndHold(dragElement).moveToElement(dropElement).release().build().perform();
		Thread.sleep(5000);
		//action.dragAndDrop(dragElement, dropElement).build().perform();
		
		

		
		
		
		driver.quit();
		
		//driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		//Thread.sleep(2000);
		

	}

}
