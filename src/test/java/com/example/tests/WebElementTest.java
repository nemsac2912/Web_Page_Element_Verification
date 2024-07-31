package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebElementTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            
            driver.get("https://demo.seleniumeasy.com");
            
            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Test Button Presence
            WebElement button = driver.findElement(By.id("btn_basic_example"));
            if (button != null) {
                System.out.println("Button is present");
            } else {
                System.out.println("Button is not present");
            }

            // Test Button Click
            button.click();
            // Add assertions or checks to verify post-click behavior
            
         // Wait for the "Simple Form Demo" link to be present and clickable
            WebElement simpleFormDemoLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Simple Form Demo")));
            simpleFormDemoLink.click();

            // Wait for the input field to be present
            WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-message")));
            inputField.sendKeys("Hello Selenium!");

            // Verify the input field's value
            if ("Hello Selenium!".equals(inputField.getAttribute("value"))) {
                System.out.println("Input field works correctly");
            } else {
                System.out.println("Input field does not work correctly");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
