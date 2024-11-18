package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarWithNavigation {
    public static void main(String[] args) throws InterruptedException {
        //Navigate to `https://syntaxprojects.com/jquery-date-picker-demo-homework.php`
        //So that I can ensure the correct "To" and "From" dates are selected from the calendar.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");

        String fromDate = "November 2024";
        String toDate = "March 2025";

        driver.findElement(By.xpath("//input[@id='from_date']")).click();
        selectDate(driver, fromDate);

        driver.findElement(By.xpath("//input[@id='to_date']")).click();
        selectDate(driver, toDate);

        driver.quit();
    }

    //Method to select a target date  in the date picker
    public static void selectDate(WebDriver driver, String targetDate) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Split target  date into month and year for comparison
        String targetMonth = targetDate.split(" ")[0];
        String targetYear = targetDate.split(" ")[1];

        boolean dateNotReached=true;

        while (dateNotReached){
            WebElement dateElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//div[@class='ui-datepicker-title']")));
            String displayedDate=dateElement.getText();
            String displayedMonth=displayedDate.split(" ")[0];
            String displayedYear=displayedDate.split(" ")[1];

            System.out.println("Current date: " + displayedDate);
            //Check if the displayed month and year match the target month and year
            if (displayedMonth.equals(targetMonth) && displayedYear.equals(targetYear)){
                dateNotReached=false;  //Target date is reached
            }else {
                //Click the next button to navigate to the next month
                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "//a[@class='ui-datepicker-next ui-corner-all' and @title='Next']")));
                nextButton.click();
                Thread.sleep(500);
            }
        }
    }
}
