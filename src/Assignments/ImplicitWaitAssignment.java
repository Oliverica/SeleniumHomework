package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitAssignment {
    public static void main(String[] args) {

        //Navigate to `https://syntaxprojects.com/synchronization-waits-homework.php`
        //to verify the functionality of selecting **Option 1** in the checkbox after the appropriate wait time.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/synchronization-waits-homework.php");


        //Click on the button labeled **"Click me"**.
        //Use an appropriate wait method to wait until the checkbox options appear.
        //Once the checkboxes are visible, select **Option 1** from the list of checkboxes.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement clickMeBtn = driver.findElement(By.xpath(
                "//button[@id='show_text_synchronize_three']"));
        clickMeBtn.click();

        WebElement opt1 = driver.findElement(By.xpath("//input[@value='Option-1']"));
        if (!opt1.isSelected()) {
            opt1.click();
        }
    }
}
