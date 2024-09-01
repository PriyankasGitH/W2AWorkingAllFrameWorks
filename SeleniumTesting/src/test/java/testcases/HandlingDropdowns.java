package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdowns {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		
		
		//driver.findElements(By.id("abc")).get(1).click();
		
		//WebElement section2 = driver.findElement(By.xpath("//section2"));
		
		//section2.findElements(By.id("abc")).get(1).click();
		
		
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		
		System.out.println("Total values in the drop down are : "+values.size());
		
		System.out.println(values.get(0).getAttribute("lang"));
		System.out.println(values.get(0).getText());
		
		for(int i=0; i<values.size(); i++) {
			
			System.out.println(values.get(i).getAttribute("value"));
		}
		
		
		System.out.println("-----Print all links-----");
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/footer/nav"));
	
		
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		
		
		
		System.out.println("Total links are : "+links.size());
		
		
		
		
		for(WebElement link:links) {
			
			System.out.println(link.getAttribute("href")+"----text is : "+link.getText());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
