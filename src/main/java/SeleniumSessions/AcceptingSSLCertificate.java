package SeleniumSessions;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AcceptingSSLCertificate {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://expired.badssl.com/");
		System.out.println("Title of the Page is " +driver.getTitle());
		
		//Accepting SSL Certificate (untrusted SSL )
		driver = new ChromeDriver(options);
		driver.navigate().to("https://expired.badssl.com/");
		System.out.println("Title of the Page is " +driver.getTitle());
		
		
	}

}
