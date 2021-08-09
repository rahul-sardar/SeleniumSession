package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksAndImages {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		boolean flag= false;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?ie=UTF8&ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_CjwKCAjw-qeFBhAsEiwA2G7Nl5SX_R7zrniKeM-F7SzMWUL2vkK22Pe10tiOjETm-cagdIb4ZJLGtBoCkUEQAvD_BwE_k_&ext_vrnc=hi&gclid=CjwKCAjw-qeFBhAsEiwA2G7Nl5SX_R7zrniKeM-F7SzMWUL2vkK22Pe10tiOjETm-cagdIb4ZJLGtBoCkUEQAvD_BwE");
		//driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total Number of anchor and images tag present are "+linkslist.size());
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i=0; i<linkslist.size();i++) {
			if(linkslist.get(i).getAttribute("href")!= null && !linkslist.get(i).getAttribute("href").contains("javascript") && !linkslist.get(i).getAttribute("href").equals("")) {
				flag = Pattern.matches("\n", linkslist.get(i).getAttribute("href"));
				if(flag == false) {
					activelinks.add(linkslist.get(i));
					System.out.println(linkslist.get(i).getAttribute("href").replaceAll("\n", ""));
				}
			}
		}
		
		
		
	  for(int j=0; j<activelinks.size();j++) {
		  if(activelinks.get(j).getAttribute("href")!= null && !activelinks.get(j).getAttribute("href").contains("\n") ) {
			  HttpURLConnection connection = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection(); 
			  String response = connection.getResponseMessage();
			  connection.disconnect();
			  System.out.println(activelinks.get(j).getAttribute("href")+ "------>" +response); 
		  }
	  
	  }
		 
		
		

	}
}

