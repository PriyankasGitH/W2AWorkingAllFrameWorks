package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	

	@Test(priority = 1)
	public void doUserReg() {

		System.out.println("Executing UserReg test");
		Assert.fail("Submit button missing hence failing the test");
	}

	
	@Test(priority = 2,dependsOnMethods = "doUserReg")
	public void doLogin() {

		System.out.println("Executing Login test");
	}
	
	
	@Test(priority = 3)
	public void isSkip() {
		
		throw new SkipException("Skipping the test as the run mode is NO");
	}

}
