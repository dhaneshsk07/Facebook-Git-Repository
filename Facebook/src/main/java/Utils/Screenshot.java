
package Utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Screenshot {

    // Folder path for storing failed screenshots
    private static final String SCREENSHOT_DIR = "E:\\Selenium Project\\Facebook\\test-output\\FBfailedSS\\";

    public static String captureScreenshot(WebDriver driver, String testName) {  // make static and string for extent reports
        // Create the Failed-Screenshots folder if it doesn't exist
        File screenshotDir = new File(SCREENSHOT_DIR);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();  // Create the directory if it doesn't exist
        }

        // Capture the screenshot as a file
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the destination file path for saving the screenshot
        File destFile = new File(SCREENSHOT_DIR + testName + ".png");

        try {
            // Copy the screenshot to the destination path
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
     // Return the screenshot file path
        return destFile.getAbsolutePath();
    }
     
    
}
