package RobotClassEvent;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab {
//	Robot robot;
	public static void main(String[] args)   {
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.navigate().to("https://www.google.com/");
		System.out.println("Title of the Page is " +driver.getTitle());
		
		
		
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL); // with robot class you can easily achieve anything if you know the shortcut keys
		        robot.keyPress(KeyEvent.VK_T); // here, we have just pressed ctrl+2
		        //robot.delay(5000);
		        robot.keyRelease(KeyEvent.VK_CONTROL); // once we press and release ctrl+2, it will go to the second tab.
		        robot.keyRelease(KeyEvent.VK_T); //if you again want to go back to first tab press and release vk_1
		        System.out.println("Title of the Page is " +driver.getTitle());

			
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		//driver.get("http://www.facebook.com");
        //driver.quit();

	}

}
