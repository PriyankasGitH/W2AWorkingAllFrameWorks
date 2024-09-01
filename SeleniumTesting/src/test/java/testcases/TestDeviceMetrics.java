package testcases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

public class TestDeviceMetrics {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();

		//devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
			//	Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				//Optional.empty(), Optional.empty(), Optional.empty()));

		Map<String,Object> deviceMetrics = new HashMap<String,Object>(){{
			
			
			put("width",600);
			put("height",1000);
			put("mobile",true);
			put("deviceScaleFactor",50);
			
		}};
		
		((ChromiumDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
		
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
