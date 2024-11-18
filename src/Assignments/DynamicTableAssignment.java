package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class DynamicTableAssignment {
    public static void main(String[] args) throws InterruptedException {

        //Navigate to `http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login`
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        //Look for an Employee ID on Page 3:take any employee id on page 3 manually.

        //Write dynamic code logic that goes to the website, searches for the employee ID across multiple pages ,
        //and once found, selects the checkbox associated with that employee.

        //Log in
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        //Navigate to the Employee list page
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        //Set the target employee ID to search for
        String empID = "44459512";
        //Locate all IDs in the current page's table
        List<WebElement> allIDs = driver.findElements(By.xpath(
                "//table[@id='resultTable']/tbody/tr//td[2]"));

        boolean idNotFound = true;
        while (idNotFound) {
            int count = 1;
            //Check each ID in the current page
            for (WebElement idCell : allIDs) {
                String idText = idCell.getText();
                if (idText.equals(empID)) {

                    System.out.println(count);

                    //Find the checkbox
                    WebElement checkbox = driver.findElement(By.xpath(
                            "//table/tbody/tr[" + count + "]/td[1]"));
                    checkbox.click();
                    idNotFound = false;
                    System.out.println("Checkbox for Employee ID " + empID + " is clicked.");
                }
                count = count + 1;
            }
            if (idNotFound) {
                WebElement nextButton = driver.findElement(By.xpath("(//a[text()='Next'])[1]"));
                nextButton.click();
                allIDs = driver.findElements(By.xpath(
                        "//table[@id='resultTable']/tbody/tr//td[2]"));

            }
        }
    }
}