package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.io.FileHandler;

public class TestIFrames {
	
	static WebDriver driver;
	
	public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(screenshotFile, new File("./screenshot/"+fileName));
	}
	
	
	public static void captureElementScreenshot(WebElement element) throws IOException {
		
		Date d = new Date();
		String fileName = "Element_ "+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		 File screenshotFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(screenshotFile, new File("./screenshot/"+fileName));
	}

	public static void main(String[] args) throws IOException {

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		

		driver.switchTo().frame("iframeResult");

		//driver.findElement(By.xpath("/html/body/button")).click();
		
		WebElement elem = driver.findElement(By.id("mySubmit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		
		captureElementScreenshot(elem);

		driver.switchTo().defaultContent();
		
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());

		for (WebElement frame : frames) {

			System.out.println(frame.getAttribute("id"));
		}
		
		captureScreenshot();
		
		
		
	}

}
