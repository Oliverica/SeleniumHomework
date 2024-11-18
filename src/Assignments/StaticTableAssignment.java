package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticTableAssignment {
    public static void main(String[] args) {
        //Navigate to `https://syntaxprojects.com/table-search-filter-demo-homework.php`
        //Print All Entries with the Country "USA"**:
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/table-search-filter-demo-homework.php");

        //Dynamically search the table for entries where the country is **"USA"**.
        //Print all the rows matching criteria
        //Ensure the search and filtering logic is **dynamic** and does not rely on hard-coded xpaths.
        //The code should be flexible enough to accommodate changes in the country name
        //If the country name changes (e.g., from "USA" to "Canada"), the same logic
        //should still work, and the output should reflect the correct entries based on the updated country.
        String countryToSearch = "USA";
        List<WebElement> allRows = driver.findElements(By.xpath(
                "//table[@id='task-table']/tbody/tr"));
        System.out.println("Entries with Country: " + countryToSearch);

        for (WebElement row : allRows) {
            WebElement countryCell = row.findElement(By.xpath(
                    "./td[3]"));

            String countryText = countryCell.getText();

            if (countryText.equals(countryToSearch)) {

                List<WebElement> rowCells = row.findElements(By.tagName("td"));

                for (WebElement cell : rowCells) {
                    System.out.print(cell.getText() + " ");
                }
                System.out.println();
            }
        }
    }
}
