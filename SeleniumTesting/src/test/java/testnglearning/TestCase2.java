package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	
	@Test
	public void validateTitles() {
		

		System.out.println("Beginning");
		
		String expectedTitle = "Gmail.com"; //reading excel
		String actualTitle = "Google.com"; //driver.getTitle
		
		/*
		if(expectedTitle.equals(actualTitle)) {
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case fail");
		}*/
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertTrue(false,"Test case failed as element is not present");
		softAssert.fail("Condition not met hence failing the test");
		
		
		System.out.println("Ending");
		
		softAssert.assertAll();
		
		
		
	}

}
