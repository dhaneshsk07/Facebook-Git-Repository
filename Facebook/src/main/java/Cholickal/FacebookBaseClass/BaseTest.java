package Cholickal.FacebookBaseClass;



import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.model.Test;


import Pages.FacebookLoginPage;
import Reporting.ExtentReportManager;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    //protected WebDriver driver;
    public WebDriver driver;
    

    @BeforeMethod 
    public void setUp() {
        // Get browser type from system property (default to "chrome")
        String browser = System.getProperty("browser", "chrome");
        
        

        // Initialize WebDriver based on the browser type
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(); 
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browser);
        }

        // Initialize Extent Reports
        ExtentReportManager.initializeReports();
        
      
      
        
        // Common browser settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");  // Set your base URL here
    }
    

   
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        
        // Flush reports to the file
        ExtentReportManager.flushReports();
    }
    
    // Utility method to get the Facebook login page (can be used in test classes)
    public FacebookLoginPage getFacebookLoginPage() {
        return new FacebookLoginPage(driver);
    }
}

