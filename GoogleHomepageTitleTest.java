package com.simplilearn.seleniumtest.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleHomepageTitleTest {
	
	public static void main(String[] args) {
        // step1: formulate a test domain url & driver path
        String siteUrl = "https://www.google.com/";
        String driverPath = "drivers/mac/geckodriver";

        // step2: set system properties for selenium dirver
        System.setProperty("webdriver.Firefox.driver", driverPath);

        // step3: instantiate selenium webdriver
        WebDriver driver = new ChromeDriver();

        // step4: launch browser
        driver.get(siteUrl);
        
        
        String title = "Google";
        
        if(title.equals(driver.getTitle())) {
            System.out.println("Test is Passed!");
        } else {
            System.out.println("Test is Failed!");
            System.out.println("Expected Title: " + title);
            System.out.println("Actual Title: " + driver.getTitle());
        }

    

        // step7: close the browser
        driver.quit();
    }

}
