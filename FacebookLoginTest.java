package com.simplilearn.seleniumtest.timeouts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLoginTest {

    static WebDriver driver;
    static WebDriverWait Wait;

    public static void main(String[] args) {

        setUp();
        testFailureLogin();

    }

    public static void setUp() {

        String siteUrl = "https://www.facebook.com";
        String driverPath = "drivers/mac/geckodriver";

        System.setProperty("webdriver.geckodriver.driver", driverPath);

        driver = new FirefoxDriver();

        Wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        driver.get(siteUrl);
    }
    
    
    public static void testFailureLogin() {
    	
    	driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
    	driver.findElement(By.id("pass")).sendKeys("abc@123");
    	driver.findElement(By.name("login")).submit();

    	// Wait for error message element to be visible
    	WebElement errorMsg = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login_error")));
    	

    	String expectedErrorText = "The password you entered is incorrect. Forget Password";

    	if (expectedErrorText.equals(errorMsg.getText())) {
    	    System.out.println("Test Passed! Expected Error Text matches Actual Error Text: " + errorMsg.getText());
    	} else {
    	    System.out.println("Test Failed!");
    	    System.out.println("Expected Error Text: " + expectedErrorText);
    	    System.out.println("Actual Error Text: " + errorMsg.getText());
    	}

    }
}