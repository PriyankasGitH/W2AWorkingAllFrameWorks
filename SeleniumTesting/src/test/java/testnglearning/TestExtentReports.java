package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;

public class TestExtentReports {

	
	/*
	public ExtentSparkReporter htmlReporter; //create HTML Files
	public ExtentReports extent; ///Add config, system properties test cases
	public ExtentTest test; //pass, fail, skip
	
	@BeforeTest
	public void setUpReport() {
		
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Way2Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Tester", "Rahul Arora");
		extent.setSystemInfo("Build No", "1234");
		extent.setSystemInfo("Organization", "Way2Automation");
		
		
		
	}*/
	
	@Test
	public void doLogin() {
			
		//test = extent.createTest("Login Test");
		//type("","");
		ExtentListeners.test.log(Status.INFO, "Entering username");
		ExtentListeners.test.info("Entering password");
		//test.info("Clicking on login button");
		
	}

	@Test
	public void doUserReg() {
		
		//test = extent.createTest("User Reg Test");
		ExtentListeners.test.info("Entering firstName");
		ExtentListeners.test.info("Entering LastName");
		
		Assert.fail("Failing the test case");
		
	}
	
	
	@Test
	public void isSkip() {
		
		//test = extent.createTest("Skip Test");
		//type("","");
		ExtentListeners.test.info("Entering firstName");
		ExtentListeners.test.info("Entering LastName");
		
		throw new SkipException("Skipping the test case");
	}
	
	/*
	@AfterMethod
	public void updateStatus(ITestResult result) {
		
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName+" - FAILED", ExtentColor.RED);
			
			
			test.fail("Test case failed");
			test.fail(m);
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName+" - SKIPPED", ExtentColor.AMBER);
			
			test.skip("Test case Skipped");
			test.skip(m);
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName+" - PASS", ExtentColor.GREEN);
			
			
			test.pass("Test case pass");
			test.pass(m);
		}
		
	}
	
	
	
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}*/
	
}
