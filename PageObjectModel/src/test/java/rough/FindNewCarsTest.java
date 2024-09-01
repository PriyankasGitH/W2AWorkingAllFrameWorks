package rough;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import pages.NewCarsPage;

public class FindNewCarsTest {

	public static void main(String[] args) {


		Map<String,Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
		HomePage home = new HomePage(driver);
		NewCarsPage newCar = home.findNewCars();
		newCar.gotoKia();
		
		
		
		//new HomePage(driver).findNewCars().gotoKia();
		
	}

}
