package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo-homework.php");

        //Select the Juice radio button from the list of favorite beverages.
        WebElement juice = driver.findElement(By.xpath("//input[@value='Juice']"));
        if (!juice.isSelected()) {
            juice.click();
            System.out.println("Juice radio button is selected.");
        }
        //Retrieve all radio buttons in the Preferred Working Environment section.
        //Traverse through the list of radio buttons in code and select the Hybrid option.
        List<WebElement> prefWorkEnvironment = driver.findElements(By.xpath(
                "//input[@name='working_enviroment']"));
        for (WebElement prefWork : prefWorkEnvironment) {
            if (prefWork.getAttribute("value").equals("hybrid")) ;
            prefWork.click();
            System.out.println("Hybrid option is selected");
        }
        //If the Spring radio button is disabled, click on the "Enable Buttons" button.
        //Ensure that the Spring option is now enabled, then select it.
        WebElement springBtn = driver.findElement(By.xpath("//input[@value='spring']"));
        WebElement enableBtn = driver.findElement(By.xpath("//button[@id='enabledFruitradio']"));
        if (!springBtn.isEnabled()) {
            enableBtn.click();
            if (!springBtn.isSelected() && springBtn.isEnabled()) {
                springBtn.click();
            }
            System.out.println("Spring option is enabled and selected.");
        }
        //By default, the Winter radio button is hidden. Ensure, through code, that it is not displayed initially.
        // Then click on the "Show Buttons" button.
        //Verify that the Winter option is displayed after clicking and is available for selection.
        WebElement showRadioBtn = driver.findElement(By.xpath("//button[@id='showRadioButtons']"));
        showRadioBtn.click();

        WebElement winter = driver.findElement(By.xpath("//input[@value='winter']"));
        if (winter.isDisplayed() && winter.isEnabled()) {
            System.out.println("Winter option is displayed and available for selection.");
        } else {
            System.out.println("Winter option is either not displayed or not available for selection.");
        }

        //Select the Lunch radio button from the list of favorite meals
        WebElement lunch = driver.findElement(By.xpath("//input[@value='lunch']"));
        if (!lunch.isSelected()) {
            lunch.click();
        }

//Wait for 5 sec to observe the result
        Thread.sleep(5000);

        //Close the driver
        driver.quit();


    }
}
