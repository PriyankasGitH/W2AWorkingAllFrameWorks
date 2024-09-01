package testnglearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class TestParameterization {
	
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	@Test(dataProvider = "dp")
	public void doLogin(String username, String password) {
		
		//System.out.println(username+"----"+password);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@DataProvider(name = "dp")
	public Object[][] getData() {
		
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		String sheetName = "LoginTest";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		
		System.out.println("Total rows are : "+rowNum+"---Total cols are : "+colNum);
		System.out.println("Data from excel : "+excel.getCellData(sheetName, 0, 2));
		
		Object[][] data = new Object[rowNum-1][colNum];
		
		/*
		//1st row
		data[0][0] = excel.getCellData(sheetName, 0, 2);
		data[0][1] = excel.getCellData(sheetName, 1, 2);
		
		//2nd row
		data[1][0] = excel.getCellData(sheetName, 0, 3);
		data[1][1] = excel.getCellData(sheetName, 1, 3);
		
		//3rd row
		data[2][0] = excel.getCellData(sheetName, 0, 4);
		data[2][1] = excel.getCellData(sheetName, 1, 4);
		
		*/
		
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
				//data[1][0] = excel.getCellData(sheetName, 0, 3);
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
				
			}
			
			
		}
		
		
		return data;
		
	}

}
