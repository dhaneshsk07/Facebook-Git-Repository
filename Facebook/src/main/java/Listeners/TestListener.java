package Listeners;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Cholickal.FacebookBaseClass.BaseTest;
import Reporting.ExtentReportManager;
import Utils.Screenshot;

public class TestListener extends BaseTest implements ITestListener {
	
	//public ExtentTest testReport;
	
	//private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // This method is invoked when a test starts
        System.out.println("Test started: " + result.getName());
    }
    
  

    @Override
    public void onTestSuccess(ITestResult result) {
        // This method is invoked when a test is successful
        System.out.println("Test passed: " + result.getName());
        Reporter.log("Test passed: " + result.getName());
        
     // Log success in the report
     //   testReport.pass("Test Passed");
        
        ExtentReportManager.createTest(result.getName()).pass("Test Passed"); 
        
        //testReport.get().log(Status.PASS, "Test Passsed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	// This method is invoked when a test fails
        System.out.println("Test failed: " + result.getName());
        Reporter.log("Test failed: " + result.getName());

        // Retrieve WebDriver instance from the BaseTest class
        WebDriver driver = ((BaseTest) result.getInstance()).driver;

        // Capture screenshot on failure
        Screenshot ss = new Screenshot();
        Screenshot.captureScreenshot(driver, result.getName());  // check now its correct but 
        
        ExtentReportManager.createTest(result.getName()).fail("Test Failed E");
        ExtentReportManager.addScreenshotToReport(driver, result.getName());
        // Capture screenshot and save it with the test name
        
        //testReport.get().log(Status.FAIL, "Test Failed due to an error");
        
        System.out.println("extent report sop  " + result.getName());
    }
    
//    @Override
//    public void onTestFailure(ITestResult result) {
//        // This method is invoked when a test fails
//        System.out.println("Test failed: " + result.getName());
//        Reporter.log("Test failed: " + result.getName());
//
//        // Retrieve WebDriver instance from the BaseTest class
//        WebDriver driver = ((BaseTest) result.getInstance()).driver;
//
//        // Capture screenshot on failure
//        Screenshot ss = new Screenshot();
//        String screenshotPath = ss.captureScreenshot(driver, result.getName());  // Capture screenshot and get the path
//
//        // Add screenshot to the Extent Report
//        ExtentReportManager.addScreenshotToReport(driver,screenshotPath);  // Pass screenshot path to the report manager
//
//        // Mark the test as failed in the ExtentReport
//        ExtentTest extentTest = ExtentReportManager.getTest(result.getName());  // Get the test from ExtentReportManager
//        extentTest.fail("Test failed due to an error.");  // Explicitly mark the test as failed
//    }
//    
//    
    

 
	@Override
    public void onTestSkipped(ITestResult result) {
        // This method is invoked when a test is skipped
        System.out.println("Test skipped: " + result.getName());
        Reporter.log("Test skipped: " + result.getName());
        
     // Log skipped test in the report
        //testReport.skip("Test Skipped");
        
        ExtentReportManager.createTest(result.getName()).skip("Test Skipped");
        
       // testReport.get().log(Status.SKIP, "Test Skipped due to invalid error");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is invoked when a test fails but within success percentage
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        // This method is invoked before the test suite starts
        System.out.println("Test suite started");
    }

    @Override
    public void onFinish(ITestContext context) {
        // This method is invoked after the test suite finishes
        System.out.println("Test suite finished");
    }
}
