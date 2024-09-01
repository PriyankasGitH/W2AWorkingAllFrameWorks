package testnglearning;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterzXML {
	
	public WebDriver driver;
	public Capabilities cap;
	
	
	@Parameters({"browser","url"})
	@Test
	public void browserTest(String b, String u) throws MalformedURLException {
		//hub and node
		Date d = new Date();
		
		if(b.equals("chrome")) {
			
			//cap =  new ChromeOptions();
		}else if(b.equals("firefox")) {
			
			cap =  new FirefoxOptions();
		}
		
		
		driver =  new RemoteWebDriver(new URL("http://13.233.174.250:4444"),cap);
		System.out.println(b+"----"+u+"---"+d.toString());
		
		driver.get(u);
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("hello browser : "+b);
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
