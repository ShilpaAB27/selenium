package com.simplilearn.seleniumtest.timeouts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitTest {
	
	private static WebDriver driver;



	public static void main(String[]args) {
		
		setUp();
		testMobileNavLink();
	}
	
	public static void setUp() {
		
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/mac/geckodriver";
		
		System.setProperty("webdriver.geckodriver.driver",driverPath);
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(siteUrl);
		}

	
	
	public static void testMobileNavLink() {
	    driver = null;
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(7)"));
	    System.out.println("Is link loaded: " + mobileLink.isDisplayed());
	    System.out.println("Is link enabled: " + mobileLink.isEnabled());
	    mobileLink.click();
	    
	    String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in -"; 
	    String actualTitle = driver.getTitle();

	    if (expectedTitle.equals(actualTitle)) {
	        System.out.println("Test is Passed!");
	    } else {
	    	
	    }
	        System.out.println("Test is Failed!");
	        System.out.println("Expected Title: " + expectedTitle);
	        System.out.println("Actual Title: " + actualTitle);
    }
}