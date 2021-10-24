package ExcelReadingWriting;

import java.text.DateFormatSymbols;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumSessions.DropDownUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterisedDataDrivenTestingExcel {

	public static void main(String[] args) {
				//Launching the browser
				WebDriverManager.chromedriver().setup(); 
				WebDriver driver = new ChromeDriver();
				//driver.get("https://demo.opencart.com/index.php?route=account/register");
				driver.get("https://en-gb.facebook.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.linkText("Create New Account")).click();
				
				
		        Xls_Reader reader = new Xls_Reader("/Users/rahulmac/Downloads/SeleniumTestingData.xlsx");
		        int rowCount= reader.getRowCount("TestData");
		        System.out.println("Rows Present in excel sheet is:" +rowCount);
				
				//Fetching the data
		        for(int i =2; i<=rowCount; i++) {
						String FirstName = reader.getCellData("TestData","firstname", i);
						System.out.println(FirstName);
						
						String LastName = reader.getCellData("TestData","lastname", i);
						System.out.println(LastName);
						
						String Email = reader.getCellData("TestData","emailaddress", i);
						System.out.println(Email);
						
						String Password = reader.getCellData("TestData","Password", i);
						System.out.println(Password);
						
						String Pincode = reader.getCellData("TestData","pincode", i);
						System.out.println(Pincode);
						
						String Phone = reader.getCellData("TestData","Phone", i);
						System.out.println(Phone);
						
						String gender = reader.getCellData("TestData","Gender", i);
						System.out.println(gender);
						
						String Birthday = reader.getCellData("TestData","DOB", i); //It returns in day/month/year
						String [] dob = dobFormat(Birthday);
			
						driver.findElement(By.name("firstname")).clear();
						driver.findElement(By.name("firstname")).sendKeys(FirstName);
						
						driver.findElement(By.name("lastname")).clear();
						driver.findElement(By.name("lastname")).sendKeys(LastName);
						
						driver.findElement(By.name("reg_email__")).clear();
						driver.findElement(By.name("reg_email__")).sendKeys(Email);
						
						driver.findElement(By.name("reg_email_confirmation__")).clear();
						driver.findElement(By.name("reg_email_confirmation__")).sendKeys(Email);
						
						driver.findElement(By.id("password_step_input")).clear();
						driver.findElement(By.id("password_step_input")).sendKeys(Password);
						
						
						List<WebElement> radioButtonlist = driver.findElements(By.xpath("//input[@type='radio']/preceding-sibling::label")); 
						for(int j=0; j<radioButtonlist.size(); j++) { 
							  String text= radioButtonlist.get(j).getText(); 
							  if(text.equals(gender)) { 
								  radioButtonlist.get(j).click(); 
							  }
						 }
						 
						WebElement day = driver.findElement(By.id("day"));
						String locatormonth= "//select[@id='month']/option";
						WebElement year = driver.findElement(By.id("year"));
							
						//Here we have created separate class DropDownUtility
						//and call methds
						DropDownUtility.selectValueFromDropDownList(day, dob[0]);
						DropDownUtility.selectdropdownwithoutselect(driver,locatormonth,dob[1]);
						DropDownUtility.selectValueFromDropDownList(year, dob[2]);
						
		        }					
					  
		//		  driver.quit();
				  
		 			

	}
	/*
	 * Here we are getting a date from excel and splitting it in month day and year
	 * Month is coming in number so converting it to short month name and then 
	 * passing it as a parameter to select drop down values
	 */
	public static String [] dobFormat(String birthday) {
				String [] dob = birthday.split("/");
				String [] months= new DateFormatSymbols().getShortMonths();
				dob[1]= months[Integer.parseInt(dob[1])-1];		
				return dob;	
	}

		
		
		
		
		
		

	}


