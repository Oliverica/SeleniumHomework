package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DropDownWithoutSelectTag {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/no-select-tag-dropdown-demo-homework.php");

        //Retrieve all options from the "Choose your Dream Fruit" dropdown.
        //Traverse through the list of options, and select **Mango**.
        //Ensure that the selection process is done by iterating through the options and not by directly clicking on the
        //option using Xpath or any direct locator to the item.

        //Locate the dropdown button and click it to open the list
        WebElement dropDown = driver.findElement(By.xpath("//div[@id='dream_fruits']"));
        dropDown.click();

        //Retrieve all the options inside the dropdown
        List<WebElement> dream_fruit = driver.findElements(By.xpath(
                "//ul[@class='dropdown-menu single-dropdown-menu']/li/a"));
        System.out.println("Number of options found: " + dream_fruit.size());

        for (WebElement fruit : dream_fruit) {
            String fruitText = fruit.getText().trim();

            if (fruitText.equals("Mango")) {
                fruit.click();
                System.out.println("Mango option is selected.");
            }

        }
        //Retrieve all options from the "Choose your Favorite Hobby" dropdown.
        //Traverse through the list and select **Reading**.
        //Ensure that the desired option is selected by iterating through the options, not by directly clicking on it using
        //Xpath or any other direct locator to the item.
        WebElement favoriteHobbie = driver.findElement(By.xpath("//div[@id='favorite_hobbies']"));
        favoriteHobbie.click();

        List<WebElement> favorite_hobbie = driver.findElements(By.xpath(
                "//ul[@class='dropdown-menu multi-dropdown-menu']/li"));
        System.out.println("Number of options found: " + favorite_hobbie.size());

        for (WebElement hobbie : favorite_hobbie) {
            String favHobbie = hobbie.getText().trim();
            if (favHobbie.equals("Reading")) {
                hobbie.click();
                System.out.println("Reading option is selected");
            }
        }
        //Wait for 5 sec to observe the result
        Thread.sleep(5000);

        //Close the driver
        driver.quit();
    }
}
