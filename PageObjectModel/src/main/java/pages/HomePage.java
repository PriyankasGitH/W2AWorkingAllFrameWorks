package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends  BasePage{

	public HomePage(WebDriver driver) {
		
		super(driver);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[normalize-space()='NEW CARS']")
	private WebElement newCar;

	@FindBy(xpath="//div[contains(text(),'Find New Cars')]")
	private WebElement findNewCar;
	
	

	public NewCarsPage findNewCars() {
		
			new Actions(driver).moveToElement(newCar).perform();
			findNewCar.click();
			return new NewCarsPage(driver);
	}
	
	
	
	public void findUsedCars() {
		
		
	}
	
	
	public void validateFeaturedCars() {
		
		
		
	}
	
}
