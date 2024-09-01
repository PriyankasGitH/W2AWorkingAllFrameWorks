package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import extentlisteners.ExtentListeners;

public class TestProperties {

	static Properties OR = new Properties();
	static Properties config = new Properties();
	static FileInputStream fis;
	static WebDriver driver;
	static Logger log = Logger.getLogger(TestProperties.class);

	/*
	 * log4j dep - jar log levels - Info, Debug, Error etc getLogger() - Logger
	 * Appender - Log Level, time stamp, log file (Console, File, SMTP, HTML)
	 * log4j.properties - PropertyConfigurator
	 */

	public static void click(String locatorKey) {

		if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
		}
		log.info("Clicking on an element " + locatorKey);
		ExtentListeners.test.info("Clicking on an element " + locatorKey);
		//test.info("Entering LastName");
	}

	public static void type(String locatorKey, String value) {

		if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);
		}

		log.info("Typing in " + locatorKey + " and entered the value as " + value);
		ExtentListeners.test.info("Typing in " + locatorKey + " and entered the value as " + value);
		
	}
	
	
	public static boolean isElementPresent(String locatorKey) {

		try {
			if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			}
			log.info("Finding an element " + locatorKey);
			ExtentListeners.test.info("Finding an element " + locatorKey);
			
			return true;
		} catch (Throwable t) {
			log.info("Error while Finding an element " + locatorKey);
			ExtentListeners.test.info("Error while Finding an element " + locatorKey);
			return false;
		}
	}
	
	

	public static void main(String[] args) throws IOException {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		log.info("Test Execution started");

		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);

		log.info("OR Properties File Loaded");

		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);

		log.info("Config Properties File Loaded");

		// driver.findElement(By.xpath(OR.getProperty("username_XPATH"))).click();
		System.out.println(OR.getProperty("username_ID"));

		// driver.get(config.getProperty("testsiteurl"))
		System.out.println(config.getProperty("testsiteurl"));

		if (config.getProperty("browser").equals("chrome")) {

			driver = new ChromeDriver();

			log.info("Chrome browser launched !!!");

		} else if (config.getProperty("browser").equals("firefox")) {

			driver = new FirefoxDriver();
			log.info("Firefox browser launched !!!");

		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

		type("username_ID", "trainer@way2automation.com");
		type("password_CSS", "dsfsdfsd");
		
		click("signInBtn_XPATH");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		log.info("Test execution completed !!!");

	}

}
