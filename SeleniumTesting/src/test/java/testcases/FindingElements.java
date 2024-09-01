package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindingElements {
	

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//implicit (Presence condition) and explicit waits (Presence )
		//driver.manage().window().maximize();
		
		
		//Options opt = driver.manage();
		//Window win  =opt.window();
		//win.maximize();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		String title = driver.getTitle();
		title.length();
		
		driver.getTitle().length();
		
		
		//WebElement username = driver.findElement(By.id("identifierId"));
		//username.sendKeys("trainer@way2automation.com");
		
		driver.findElement(By.id("identifierId")).sendKeys("java@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("sdfsdfds");
		
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("sdfsdfsf");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		
		
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span"))).getText());
		
		
		
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span")).getText());
		
		
		driver.quit();
		
	}

}
