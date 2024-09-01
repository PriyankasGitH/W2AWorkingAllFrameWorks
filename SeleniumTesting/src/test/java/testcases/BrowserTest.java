package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	
	
	public static String browser = "chrome";
	static WebDriver driver;
	
	public static void main(String[] args) {

		/*
		 * Parent c = new Child1(); Parent c2 = new Child2(); ChromeDriver driver = new
		 * ChromeDriver(); ChromeDriver driver = new FirefoxDriver();
		 */
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("");
		driver.getTitle();
		
		if(browser.equals("chrome")) {
			
			driver = new ChromeDriver();
		}else if(browser.equals("edge")) {
			
			 driver = new EdgeDriver();
		}else if(browser.equals("firefox")) {
			
			 driver = new FirefoxDriver();
		}
		//CTRL + SHIFT + O
		
		driver.get("http://gmail.com");
		String title = driver.getTitle(); //gmail  1234
		System.out.println(title.length());
		
		String expectedTitle = "Google.com";
		
		
		
		if(title.equals(expectedTitle)) {
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case fail");
		}
		
		
		
		//driver.close(); //close browser
		driver.quit(); //close browser
		

	}

}
