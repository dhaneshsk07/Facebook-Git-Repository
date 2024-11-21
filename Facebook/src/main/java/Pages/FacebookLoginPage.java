package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Cholickal.FacebookBaseClass.BaseTest;

//Page object Model
public class FacebookLoginPage  {

    private WebDriver driver;

    // Locators for the Facebook login page elements
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.name("login");

    // Constructor to initialize the WebDriver
    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter the email
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    // Method to click the login button
    public void clickLogin() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    // Method to perform login action
    public void login(String email, String password) {
        enterEmail(email);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        enterPassword(password);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clickLogin();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

