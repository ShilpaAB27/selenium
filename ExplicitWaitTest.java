package com.simplilearn.seleniumtest.timeouts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {

    static WebDriver driver;
    static WebDriverWait Wait;

    public static void main(String[] args) {

        setUp();
        testMobileLink();

    }

    public static void setUp() {

        String siteUrl = "https://www.amazon.in";
        String driverPath = "drivers/mac/geckodriver";

        System.setProperty("webdriver.geckodriver.driver", driverPath);

        driver = new FirefoxDriver();

        Wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(siteUrl);
    }

    public static void testMobileLink() {

        WebElement mobileLink = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(7)")));

        System.out.println("Is Link Loaded ::" + mobileLink.isDisplayed());
        System.out.println("Is Link Enabled ::" + mobileLink.isEnabled());

        mobileLink.click();

        String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Test is Passed!");
        } else {
            System.out.println("Test is Failed!");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }
    }
}