package com.simplilearn.seleniumtest.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonLinkVerificationTest {

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
        
        linkTest1();
        
        Thread.sleep(1000);
        
        linkTest2();
        
        Thread.sleep(1000);

 // Invoke the testSearch2 method
        
        // Close the browser session after tests are done
        driver.quit();
    }

    private static void linkTest2() {
		// TODO Auto-generated method stub
		
	}

	private static void linkTest1() throws InterruptedException {
        Thread.sleep(1000);
        WebElement link = driver.findElement(By.xpath("//a[@href='https://www.amazon.in/gp/bestsellers/']"));
        link.click();
        
        Thread.sleep(1000);
        
        String expectedTitle = "Amazon.in : Bestsellers: The most popular items on Amazon";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Link Test is Passed!");
        } else {
            System.out.println("Link Test is Failed!");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }
    }
        
    private static void linkTest21() throws InterruptedException {
        Thread.sleep(1000);

        WebElement link = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(8)"));
        link.clear();
            
        Thread.sleep(1000);
            
        String expectedTitle = "Amazon.in: Electronics";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Search Test is Passed!");
        } else {
            System.out.println("Search Test is Failed!");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }
        
        // Add further actions/assertions based on the search results
    }
}