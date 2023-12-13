package com.simplilearn.seleniumtest.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonHomepageTest {
	
	public static void main(String[] args) {
        // Step 1: Define the test domain URL & driver path
        String siteUrl = "https://www.amazon.in/";
        String driverPath = "drivers/mac/geckodriver";
        
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Step 3: Instantiate the Selenium WebDriver for Firefox
        WebDriver driver = new FirefoxDriver();

        try {
            // Step 4: Launch the browser and open the site URL
            driver.get(siteUrl);
            
            String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
            String actualTitle = driver.getTitle();

            if (expectedTitle.equals(actualTitle)) {
                System.out.println("Test is Passed!");
            } else {
                System.out.println("Test is Failed!");
                System.out.println("Expected Title: " + expectedTitle);
                System.out.println("Actual Title: " + actualTitle);
            }

            // Step 5: Get and print the current URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            
            // You can add further steps to interact with elements or perform validations here

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the browser
            driver.quit();
        }
    }
}
