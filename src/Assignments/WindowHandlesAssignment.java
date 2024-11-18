package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class WindowHandlesAssignment {
    public static void main(String[] args) throws InterruptedException {

        //Navigate to `https://syntaxprojects.com/window-popup-modal-demo-homework.php`
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo-homework.php");

        //Store the current window handle
        String mainPage = driver.getWindowHandle();

        //1. Click on Button B1, ensure that B1 button opens a new window, verify "Welcome to B1! page"
        WebElement buttonB1 = driver.findElement(By.xpath(
                "//a[@class='btn btn-primary followeasy']"));
        buttonB1.click();

        Set<String> allHandles = driver.getWindowHandles();

        for (String windowHandle : allHandles) {
            if (!windowHandle.equals(mainPage)) {
                driver.switchTo().window(windowHandle);

                //Wait for the h2 element with the expected message
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
                String text = textElement.getText();

                //Verify text content in B1 window
                if (text.equals("Welcome to B1! page")) {
                    System.out.println("Verification passed: 'Welcome to B1! page' is displayed.");
                } else {
                    System.out.println("Verification failed: Unexpected text in B1 window");
                }
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //1. Click on Button B2, ensure that B2 button opens a new window, verify "Welcome to B2 page"
        WebElement button2 = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        System.out.println("Attempting to click B2");
        button2.click();

        Set<String> windows = driver.getWindowHandles();
        for (String windowHandle : windows) {
            if (!windowHandle.equals(mainPage)) {
                driver.switchTo().window(windowHandle);

                Thread.sleep(1000);

                System.out.println("Switched to new window (B2) with title" + driver.getTitle());
                System.out.println("Page URL(B2): " + driver.getCurrentUrl());

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement h2Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
                String pageText = h2Element.getText();
                System.out.println("Current page h2 text: " + pageText);

                if (!pageText.equals("Welcome to B2 page")) {
                    Thread.sleep(2000);
                    pageText = h2Element.getText();

                }
                //Verify the text content in the new window
                if (pageText.equals("Welcome to B2 page")) {
                    System.out.println("Verification passed: 'Welcome to B2 page' is displayed.");
                } else if (pageText.equals("Welcome to B1! page")) {
                    System.out.println("Note: 'Welcome to B1! page' is displayed instead of 'Welcome to B2 page'.");
                } else {
                    System.out.println("Verification failed: Unexpected text in B2 window.");

                }
                //driver.switchTo().window(mainPage);
                //break;
            }
        }
    }
}











