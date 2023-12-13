package com.simplilearn.seleniumtest.timeouts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadHandler {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        setUp();
        testFileUpload();
        tearDown();
    }

    public static void setUp() {
        String siteUrl = "https://www.makemytrip.com/";
        String driverPath = "drivers/mac/geckodriver";

        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        driver.get(siteUrl);
    }

    public static void testFileUpload() {
        // Perform Login
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("shilpaalok@gmail.com");

        // Fill in the password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("shilpa2708");

        // Submit the form
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.submit();

        // Wait for the dashboard to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));

        // Wait for the Utilities link to be clickable and click on it
        WebElement utilitiesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Utilities')]")));
        utilitiesLink.click();

        // Wait for the Upload File link to be clickable and click on it
        WebElement uploadFileLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Upload File')]")));
        uploadFileLink.click();

        String filePath = null; // Set this to the actual path of the file you want to upload

        // Click on 'Choose File' button and select a file from your computer
        driver.findElement(By.name("file")).sendKeys(filePath);

        // Wait for the file upload confirmation button to be clickable
        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));

        // Click on 'Upload' button
        uploadButton.click();

        // Wait for the success message to be displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'File has been uploaded successfully.')]")));

        System.out.println("File Uploaded Successfully!");
    }

    public static void tearDown() {
        driver.quit();
    }
}