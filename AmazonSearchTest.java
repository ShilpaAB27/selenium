package com.simplilearn.seleniumtest.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonSearchTest {

    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        // Step 1: Define the test domain URL & driver path
        String siteUrl = "https://www.amazon.in";
        String driverPath = "drivers/mac/geckodriver";

        // Step 2: Set system properties for Selenium driver
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Step 3: Instantiate Selenium WebDriver (Firefox)
        driver = new FirefoxDriver();

        // Step 4: Launch the browser and open the site URL
        driver.get(siteUrl);

        // Step 5: Perform search
        testSearch1();
        testSearch2();
        
        Thread.sleep(2000);
        driver.close();
    }

    private static void testSearch1() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone 15 pro max");
        searchBox.submit();
        
        Thread.sleep(2000);
        
        String expectedTitle = "Amazon.in : iphone 15 pro max";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Test is Passed!");
        } else {
            System.out.println("Test is Failed!");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }
            
            
        }
        
      private static void testSearch2() throws InterruptedException {
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.clear();
            searchBox.sendKeys("Apple mac book");
            searchBox.submit();
            
            Thread.sleep(2000);
            
            String expectedTitle = "Amazon.in : Apple mac book";
            String actualTitle = driver.getTitle();

            if (expectedTitle.equals(actualTitle)) {
                System.out.println("Test is Passed!");
            } else {
                System.out.println("Test is Failed!");
                System.out.println("Expected Title: " + expectedTitle);
                System.out.println("Actual Title: " + actualTitle);
            }


        // Add further actions/assertions based on the search results
    }
}
