package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NewCarsPage extends  BasePage {
	
	
	
	public NewCarsPage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//div[normalize-space()='Kia']")
	private WebElement kia;

	public KiaCarsPage gotoKia() {
		
		
		kia.click();
		return new KiaCarsPage(driver);
		
	}
	
	
	@FindBy(xpath="//div[normalize-space()='Toyota']")
	private WebElement toyota;

	public ToyotaCarsPage gotoToyota() {
		
		toyota.click();
		return new ToyotaCarsPage(driver);
	}
	
	
	@FindBy(xpath="//div[normalize-space()='BMW']")
	private WebElement bmw;

	public BMWCarsPage gotoBMW() {
		
		bmw.click();
		return new BMWCarsPage(driver);
	}
	
	
	@FindBy(xpath="//div[normalize-space()='Tata']")
	private WebElement tata;

	public TataCarsPage gotoTata() {
		
		tata.click();
		return new TataCarsPage(driver);
		
	}

}
