package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v124.security.Security;

public class HandlleBadSSL {

	public static void main(String[] args) {


		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--ignore-certificate-errors");
		//options.addArguments("--disable-notifications");

		//WebDriver driver = new ChromeDriver(options);
		
		WebDriver driver = new ChromeDriver();
		
		
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		
		
		
		devTools.send(Security.enable());
		devTools.send(Security.setIgnoreCertificateErrors(true));
		
		
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	

	}

}
