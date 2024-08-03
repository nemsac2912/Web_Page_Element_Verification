package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebElementTest {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            
            driver.get("https://demo.seleniumeasy.com");
            
            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            
            Thread.sleep(1500);
         // Scroll the webpage by a specified amount with smooth scrolling
            int totalScrollAmount = 500; // Define the total amount to scroll in pixels
            int scrollIncrement = 50; // Define the amount to scroll in each increment
            int delay = 250; // Define the delay between each scroll in milliseconds
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int scrolled = 0; scrolled < totalScrollAmount; scrolled += scrollIncrement) {
                js.executeScript("window.scrollBy(0, arguments[0]);", scrollIncrement);
                Thread.sleep(delay);
            }
            
            Thread.sleep(2000);

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
            
            Thread.sleep(2000);
            // Scroll the webpage by a specified amount with smooth scrolling
            int totalScrollAmount2 = 300; // Define the total amount to scroll in pixels
            int scrollIncrement2 = 50; // Define the amount to scroll in each increment
            int delay2 = 250; // Define the delay between each scroll in milliseconds
            
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            for (int scrolled = 0; scrolled < totalScrollAmount2; scrolled += scrollIncrement2) {
                js.executeScript("window.scrollBy(0, arguments[0]);", scrollIncrement2);
                Thread.sleep(delay2);
            }
            Thread.sleep(2000);
            
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
            Thread.sleep(2000);
            
            WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='showInput();']")));
            if (button2 != null) {
                System.out.println("'Show Message' Button is present");
                button2.click();
            } 
            else 
            {
                System.out.println("'Show Message' Button is not present");
            }
            
            WebElement displayedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("display")));
            if (displayedMessage.isDisplayed())
            {
            	System.out.println("Entered Message is displayed");
            	Thread.sleep(2000);
            }
            else
            {
            	System.out.println("Entered Message is not displayed");
            	Thread.sleep(2000);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
