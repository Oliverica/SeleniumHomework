package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebelementCommandsAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/selenium_commands_selector-homework.php");

        //Retrieve the text "inspect me to view my custom attribute" from the element and print
        WebElement textElement = driver.findElement(By.xpath("//div[@id='textattr']"));
        String visibleText = textElement.getText();
        System.out.println("The visible text is: " + visibleText);

        //Check if "Musical Festival" checkbox is enabled and click it if true
        WebElement musical_festival_checkbox = driver.findElement(By.xpath(
                "//input[@value='music_festival']"));
        if (musical_festival_checkbox.isEnabled()) {
            musical_festival_checkbox.click();
            System.out.println("Musical festival checkbox clicked.");
        } else {
            System.out.println("Musical festival checkbox disabled");
        }

        //Ensure that the option for "Tech Talk" is disabled.
        WebElement isTech_talkDisabled = driver.findElement(By.xpath(
                "//input[@value='tech_talk']"));
        if (!isTech_talkDisabled.isEnabled()) {
            System.out.println("Tech Talk checkbox is disabled.");
        }
        //Click on "Show More Options" and ensure the "Art Exhibition" option is displayed
        WebElement show_more_optionsBTN = driver.findElement(By.xpath(
                "//button[@class='btn btn-default']"));
        show_more_optionsBTN.click();
        WebElement art_exhibitionBTN = driver.findElement(By.xpath(
                "//label[@id='hiddenRadioLabel']"));
        if (art_exhibitionBTN.isDisplayed()) {
            System.out.println("Art exhibition checkbox is displayed.");
        } else {
            System.out.println("Art exhibition checkbox is not displayed.");

        }
        //Mystery Message: Retrieve the value of the attribute `title` from the element containing the text
        // "Hover me to reveal the secret" and print it on the console.
        WebElement mysteryMessage = driver.findElement(By.xpath("//div[@id='hidden_message']"));
        String mysteryMsgElement = mysteryMessage.getAttribute("title");
        System.out.println("The title attribute is: " + mysteryMsgElement);

        //Check if "Checkbox 1" is enabled and if so, click on it
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='CheckboxFirst']"));
        if (checkbox1.isEnabled()) {
            checkbox1.click();
            System.out.println("Checkbox 1 is clicked.");
        }
        //Ensure that "Checkbox 2" is disabled.
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='disabledCheckbox']"));
        if (!checkbox2.isEnabled()) {
            System.out.println("Checkbox 2 is disabled.");
        }
        // Clear the text from the input box and send the text
        // "here is the custom text entered" using selenium commands
        WebElement input_field = driver.findElement(By.xpath("//input[@id='inputField']"));
        input_field.clear();
        input_field.sendKeys("here is the custom text entered");
        System.out.println("Input field is cleared and new text is entered.");

        ////Wait for 5 sec to observe the result
        Thread.sleep(5000);

        //Close the driver
        driver.quit();


    }
}
