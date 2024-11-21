package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



import Utils.Screenshot;

import org.openqa.selenium.WebDriver;

import java.io.File;

public class ExtentReportManager {
    
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    // Initialize the ExtentReports
    public static ExtentReports initializeReports() {
        if (extentReports == null) {
            // Create the HTML report file path
            String reportFilePath = "test-output/ExtentReport/ExtentReport.html";

            // Create an ExtentHtmlReporter
            //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);

            
            
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFilePath); //html reporter changed to sparkreporter
            
            // Initialize ExtentReports with the HTML reporter
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        return extentReports;
    }

    // Create a new test case in the report
    public static ExtentTest createTest(String testName) {
        extentTest = extentReports.createTest(testName);
        return extentTest;
    }

    // Flush the report data to the file
    public static void flushReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    // Attach screenshot to the report
    public static void addScreenshotToReport(WebDriver driver, String testName) {
        String screenshotPath = Screenshot.captureScreenshot(driver, testName);
        extentTest.addScreenCaptureFromPath(screenshotPath);
    }
}
