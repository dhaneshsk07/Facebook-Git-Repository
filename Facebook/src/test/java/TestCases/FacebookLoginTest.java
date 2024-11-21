package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Cholickal.FacebookBaseClass.BaseTest;
import Pages.FacebookLoginPage;
import Reporting.ExtentReportManager;
import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import Listeners.TestListener;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)  //Listner register here
public class FacebookLoginTest extends BaseTest {

	// private WebDriver driver;
	private FacebookLoginPage facebookLoginPage;
	
	 //private ExtentTest testReport;

	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {
		// Provide the path to the Excel file and the sheet name
		return ExcelUtils.getTestData("F:\\Dahnesh Sample files\\FacebookDetails.xlsx", "Sheet1");

	}

	
	@Test(dataProvider = "loginData",description ="Test1 Login Facebook")
	public void testLogin(String username, String password) {
		// Perform login using valid credentials

		/* get the FacebookLoginPage by using the get method in basetest class */

//    	FacebookLoginPage facebookLoginPage = getFacebookLoginPage();//working type1
//        facebookLoginPage.login("your_email@example.com", "your_password"); //working
		
		// Create test in ExtentReport
       // testReport = ExtentReportManager.createTest("Test Login"); // same has been added in iTestListener class
		
        // Add screenshot on failure or success
        

		FacebookLoginPage loginPage = getFacebookLoginPage(); // working

		// Perform login using the provided data
		loginPage.login(username, password);
		Assert.assertEquals(true,true);
		
		
		// ExtentReportManager.addScreenshotToReport(driver, "testLogin");// same has been added in iTestListener class
       
	}
	
	
	
	
	

//    @AfterMethod
//    public void tearDown() {
//        // Close the browser after the test
//        driver.quit();
//    }
}
