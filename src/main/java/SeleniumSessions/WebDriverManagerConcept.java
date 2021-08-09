package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		/*
		 * WebDriverManager concept is like we dont need to download chromedriver and
		 * set system property and all it will do it on its own , it will find the
		 * suitable ChromeDriver according to our os
		 */
	}

}
