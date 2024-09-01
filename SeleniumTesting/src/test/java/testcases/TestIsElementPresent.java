package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIsElementPresent {

	static WebDriver driver;

	public static boolean isElementPresent(String id) {

		try {
			driver.findElement(By.id(id));
			return true;
		} catch (Throwable t) {

			return false;
		}
	}

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("http://gmail.com");

		driver.manage().window().maximize();

		System.out.println(isElementPresent("identifierId"));

		driver.findElement(By.id("identifierId")).sendKeys("java@way2automation.com");

	}

}
