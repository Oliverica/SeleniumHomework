package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBoxesAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/basic-checkbox-demo-homework.php");

        //Subscribe to Newsletter
        //Check if the "Subscribe to Newsletter" checkbox is enabled, and then click on it.
        WebElement subscribeToNewsletter = driver.findElement(By.xpath(
                "//input[@id='newsletter']"));
        if (subscribeToNewsletter.isEnabled()) {
            subscribeToNewsletter.click();
            System.out.println("Subscribe to Newsletter checkbox is clicked.");
        }
        //Select Your Hobbies:
        //Retrieve the list of all checkboxes in the **Select Your Hobbies** section.
        //Traverse through the list and select the **Reading** and **Cooking** checkboxes.
        List<WebElement> checkBoxesList = driver.findElements(By.xpath(
                "//input[@class='cb-element']"));
        System.out.println("Total  checkboxes found: " + checkBoxesList.size());

        for (WebElement hobbieCheckBox : checkBoxesList) {
            String hobby = hobbieCheckBox.getAttribute("id");

            if (hobby.equals("reading") || hobby.equals("cooking")) {
                hobbieCheckBox.click();
                System.out.println(hobby + " checkbox is clicked");

            }
        }
        //Select Your Interests:
        //Verify that the **Support** and **Music** checkboxes are not displayed by default.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SelectYourInterests = driver.findElement(By.xpath(
                "//div[text()='Select your Interests']"));

        WebElement support = driver.findElement(By.xpath("//input[@value='Support']"));
        WebElement music = driver.findElement(By.xpath("//input[@value='Music']"));
        if (!support.isDisplayed() && music.isDisplayed()) {
            System.out.println("Checkboxes are not displayed by default.");
        }
        //Click on the show/hide interests section
        WebElement show_hide = driver.findElement(By.xpath(
                "//button[@id='toggleCheckboxButtons']"));
        show_hide.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//input[@value='Music']")));

        //Select the **Music** checkbox
        if (!music.isSelected()) {
            music.click();
            System.out.println("Music checkbox is selected.");
        }
        //Verify that the **Receive Notifications** checkbox is disabled.
        WebElement receiveNotifications = driver.findElement(By.xpath(
                "//input[@value='Receive-Notifications']"));
        if (!receiveNotifications.isEnabled()) {
            System.out.println("Receive Notifications checkbox is disabled.");
        }
        //Click on the "Enable Checkboxes" button, and then select the **Receive Notifications** checkbox.
        WebElement enableCheckboxes = driver.findElement(By.xpath(
                "//button[@id='enabledcheckbox']"));
        enableCheckboxes.click();
        if (!receiveNotifications.isSelected()) {
            receiveNotifications.click();
            System.out.println("Receive Notifications checkbox is selected.");
        }

        //Wait for 5 sec to observe the result
        Thread.sleep(5000);

        //Close the driver
        driver.quit();



    }


}


