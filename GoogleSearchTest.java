package com.simplilearn.seleniumtest.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {

    public static void main(String[] args) {
        // Step 1: Define the test domain URL & driver path
        String siteUrl = "https://www.google.com/";
        String driverPath = "drivers/mac/geckodriver"; // Update GeckoDriver path accordingly

        // Step 2: Set system properties for the Selenium driver (Firefox)
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Step 3: Instantiate the Selenium WebDriver for Firefox
        WebDriver driver = new FirefoxDriver();

        try {
            // Step 4: Launch the browser and open the site URL
            driver.get(siteUrl);

            // Step 5: Perform the Google search
            // Find the search box, enter a search query, and submit
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("selenium documentation");
            searchBox.submit();

            Thread.sleep(2000);

            String expectedTitle = "selenium documentation - Google Search"; // Update expected title
            String actualTitle = driver.getTitle();

            if (expectedTitle.equals(actualTitle)) {
                System.out.println("Test is Passed !");
            } else {
                System.out.println("Test is Failed !");
                System.out.println("Expected Title: " + expectedTitle);
                System.out.println("Actual Title: " + actualTitle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the browser
            driver.quit();
        }
    }
}
