package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitAssignment {
    public static void main(String[] args) {

        //Navigate to `https://syntaxprojects.com/synchronization-explicit-wait-homework.php`
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/synchronization-explicit-wait-homework.php");

        //Click on the button **"Click me to change text!"**.
        //Wait until the text changes to **"Ssyntaxtechs"**, then print the text **"Ssyntaxtechs"** on the console.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickToChangeTxtBtn = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//button[@id='changetext_button']")));
        clickToChangeTxtBtn.click();
        String buttonText = clickToChangeTxtBtn.getText();
        System.out.println(buttonText);

        //Click on the button **"Click me to enable button"**.
        //Wait for the button to be enabled, and once it's enabled, click on it.
        WebElement enableButton = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//button[@id='enable_button']")));
        enableButton.click();
        WebElement button = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[3]"));
        button.click();

        //Click on the button **"Click me to check the checkbox"**.
        //Wait for the checkbox to be checked, then print the status of **isSelected** on the console
        // to verify if the checkbox is enabled.
        WebElement clickToCheck = driver.findElement(By.xpath("//button[@id='checkbox_button']"));
        clickToCheck.click();

        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@id='checkbox']")));
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkbox']"));
        if (checkbox.isSelected()) {
            System.out.println("Checkbox is selected: " + checkbox.isSelected());
        } else {
            System.out.println("Checkbox is selected: " + checkbox.isSelected());
        }


    }
}

