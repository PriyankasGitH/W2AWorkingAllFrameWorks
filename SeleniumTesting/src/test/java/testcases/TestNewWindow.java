package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNewWindow {

	public static void main(String[] args) {



		WebDriver driver = new ChromeDriver();
		driver.get("https://sso.teachable.com/secure/673/identity/sign_up");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://gmail.com");
		System.out.println(driver.getTitle());
		
		
		
		System.out.println(driver.getWindowHandles().size());
		
		
		
		
		
		
	}

}
