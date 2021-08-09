package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthorisationPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		/*Launch this url you will see authenytication pop up
		 * see below how url changed to handle it
		 * driver.get("https://the-internet.herokuapp.com/basic_auth");
		 * Thread.sleep(8000);
		 */
		String username= "admin";
		String password= "admin";
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		Thread.sleep(8000);
		driver.quit();
		

	}

}
