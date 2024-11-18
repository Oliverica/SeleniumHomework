package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectDropDownAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/basic-select-dropdown-demo-homework.php");

        //Use the **Select** class to select the option **"Pear"** from the dropdown.
        //Use the **getOptions** method to retrieve all options from the dropdown and print them on the console.

        WebElement favFruit = driver.findElement(By.xpath("//select[@id='fav_fruit_selector']"));

        Select select = new Select(favFruit);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText().trim();
            System.out.println(optionText);

            if (optionText.equals("Pear")) {
                option.click();
                System.out.println("Pear is selected.");
                break;
            }
        }

        //Select Multiple Options:
        //First, verify that the **Select** dropdown is multi-select by checking the dropdown’s properties.

        WebElement multiSelectDD = driver.findElement(By.xpath("//select[@id='select_multi_hobbies']"));

        //Verify if dropdown is multiselect
        Select select1 = new Select(multiSelectDD);
        boolean multiSelectHobbies = select1.isMultiple();
        System.out.println("Dropdown is multi-selected.");

        //Using the **Select** class, make the following selections:
        //**Traveling**
        //**Cooking**
        //**Gardening**
        select1.selectByValue("Traveling");
        select1.selectByVisibleText("Cooking");
        select1.selectByIndex(4);

        //Click the **"Get All Selected"** button and print the result on the console.
        List<WebElement> allSelectedOptions = select1.getAllSelectedOptions();
        for (WebElement option : allSelectedOptions) {
            String selectedText = option.getText();
            System.out.println("Selected option: " + selectedText);
        }

        //After a delay of 5 seconds, deselect the **Traveling** option using the **Select** class.
        Thread.sleep(5000);
        select1.deselectByValue("Traveling");

        //Click the **"Get All Selected"** button again and print the result on the console.
        List<WebElement> allSelectedOptionsAfterDiselect = select1.getAllSelectedOptions();
        for (WebElement option : allSelectedOptionsAfterDiselect) {
            String selectedText = option.getText();
            System.out.println("Selected option after diselection: " + selectedText);
        }


    }
}
