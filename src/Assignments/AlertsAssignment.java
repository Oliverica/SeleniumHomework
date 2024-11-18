package Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsAssignment {
    public static void main(String[] args) throws InterruptedException {

        // Click on the **"Enter Your Name"** button.
        // Accept the alert and provide a name.
        // Retrieve the name that appears on the screen UI and print it on the console, verifying that the correct name
        //is displayed.
        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/javascript-alert-box-demo-homework.php");

        //Click on the "Birthday Reminder" button.
        //When the alert appears, accept the alert.
        try {
            WebElement birthdayReminder = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
            birthdayReminder.click();

            //Wait for alert to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert confirmAlert = driver.switchTo().alert();
            confirmAlert.accept();

            //Click on the **"Delete File"** button.
            //When the confirmation alert appears, **dismiss** the alert.
            //Print the status of the action (e.g., "File deletion canceled") that appears on the screen, to the console.
            WebElement deleteFile = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
            deleteFile.click();

            Thread.sleep(2000);

            confirmAlert.dismiss();
            System.out.println("File deletion canceled.");

            //Click on the **"Enter Your Name"** button.
            //Accept the alert and provide a name.
            //Retrieve the name that appears on the screen UI and print it on the console, verifying that the correct name
            //is displayed.
            WebElement enterYourName = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
            enterYourName.click();

            confirmAlert = driver.switchTo().alert();
            confirmAlert.sendKeys("Olivera");
            confirmAlert.accept();

            WebElement nameDisplay = driver.findElement(By.id("prompt-demo"));
            String displayedText = nameDisplay.getText();
            String name = displayedText.replace("You have entered ", "").replace(" ", "");
            System.out.println("Name displayed on UI: " + name);


        } catch (org.openqa.selenium.NoAlertPresentException e) {

        }


    }

}

