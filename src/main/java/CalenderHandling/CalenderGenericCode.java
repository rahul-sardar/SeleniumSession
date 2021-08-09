package CalenderHandling;


import java.util.Calendar;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderGenericCode {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		//driver.get("https://demo.opencart.com/index.php?route=account/register");
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		
		new WebDriverWait(driver,10)
		  .until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
		
	    selectDate("48", "June", "2000");
		
		


	}
	
	public static String [] getmonthYear(String varMonthYear) {
		
		return varMonthYear.split(" ");
		
	}
	
	public static void selectDate(String expDate, String expMonth, String expYear) {
		
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearVal);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		if(Integer.parseInt(expDate) > 29 && expMonth == "February") {
			System.out.println("Wrong Date : " +expDate + ":" + expMonth );
			return;
		}
		
		while(!(getmonthYear(monthYearVal)[0].equals(expMonth) && getmonthYear(monthYearVal)[1].equals(expYear))) {
			int currentLoopYear = Integer.parseInt(expYear);
			if(currentLoopYear < year) {
				driver.findElement(By.xpath("//a[@title='Prev']")).click();
				monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
				--currentLoopYear;
			}else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
			}
			
		}
		
		try {
			driver.findElement(By.xpath("//a[text()= '"+expDate+"']")).click();
		} catch (Exception e) {
			System.out.println("Wrong Date : " +expDate + ":" + expMonth );
		}
	}

}
