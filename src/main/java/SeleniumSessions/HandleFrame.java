package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		Thread.sleep(2000);
		
		/*This will not work because title is under frame , 
		 * first we need to shift control to frame 
		 * org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"body > h2"}
		 * we can try with id xpath, name still we will get same same exception
		 * String text = driver.findElement(By.cssSelector("body > h2")).getText();
		 * System.out.println(text);
		 * 
		 * driver.quit();
		 */
		
		WebElement frameelement = driver.findElement(By.name("main"));
		driver.switchTo().frame(frameelement);
		String text = driver.findElement(By.cssSelector("body > h2")).getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();// First switch back to default content then switch back to next frame
		
		//WebElement frameelement2 = driver.findElement(By.xpath("//frame[@name='bot']"));
		//driver.switchTo().frame(frameelement2);
		driver.switchTo().frame("bot");
		
		String footertext = driver.findElement(By.cssSelector("body > h2")).getText();
		System.out.println(footertext);
		driver.switchTo().defaultContent();
		driver.quit();
		
	}

}
