package testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTabsAndPopups {

	public static void main(String[] args) {



		WebDriver driver = new ChromeDriver();
		driver.get("https://sso.teachable.com/secure/673/identity/sign_up");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		System.out.println("-----Generating window ids from first window-----");
		
		Set<String> winids = driver.getWindowHandles(); //
		Iterator<String> iterator = winids.iterator();
		
		String firstWindow = iterator.next(); //first window id
		
		System.out.println(firstWindow);
		
		driver.findElement(By.linkText("Privacy Policy")).click();
		
		
		
		System.out.println("-----Generating window ids from second window-----");
	
	
		
		
		winids = driver.getWindowHandles(); //2
		iterator = winids.iterator();
		
		System.out.println(iterator.next()); //
		String secondWindow = iterator.next(); //2nd
		System.out.println(secondWindow);
		
		driver.switchTo().window(secondWindow);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.partialLinkText("Login")).click();
		
		
		driver.close(); //2nd
		driver.switchTo().window(firstWindow);
		
		driver.close(); //1st
		
		//driver.quit();

	

	}

}
