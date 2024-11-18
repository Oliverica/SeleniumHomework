package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToLocatorsAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Navigate to target webpage
        driver.get("https://www.syntaxprojects.com/locator-homework.php");

        //Maximize the window
        driver.manage().window().maximize();

        //Using CSS selector for Full Name field
        WebElement full_name = driver.findElement(By.cssSelector("#fullName"));
        full_name.sendKeys("Olivera Zekovic");

        WebElement email = driver.findElement(By.cssSelector("#yourEmail"));
        email.sendKeys("oliverica123@567");
        //Validate email before submission
        String emailValue = email.getAttribute("value");
        if (!emailValue.contains("@")) {
            System.out.println("Invalid email format: Missing '@' symbol.");
        } else {
            System.out.println("Email is valid.");
        }

        //Using Xpath for Client Name field
        WebElement client_name = driver.findElement(By.xpath("//input[@id=\"clientNameId\"]"));
        client_name.sendKeys("Olivera");

        //Client ID
        WebElement client_ID = driver.findElement(By.xpath("//input[@id=\"ClientId\"]"));
        client_ID.sendKeys("1235489966");

        //Client feedback
        WebElement client_feedback = driver.findElement(By.xpath("//input[@id=\"ClientfeedbackId\"]"));
        client_feedback.sendKeys("This project meets expectations.");

        //Project name
        WebElement project_name = driver.findElement(By.xpath("//input[@id=\"ProjectNameId\"]"));
        project_name.sendKeys("Automation Testing Project");

        //Project deadline time
        WebElement project_deadline_time = driver.findElement(By.cssSelector("#ProjectTimeId"));
        project_deadline_time.sendKeys("01/01/2025");

        //Current address
        WebElement current_address = driver.findElement(By.xpath("//textarea[@name=\"CurrentAddress\"]"));
        current_address.sendKeys("W Irving Park Rd, Chicago, Illinois");

        //Permanent address
        WebElement permanent_address = driver.findElement(By.cssSelector("#PermanentAddressId"));
        permanent_address.sendKeys("W Irving Park Rd, Chicago, Illinois");

        //Click on the 'Click Here' link to open a new tab
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        //Submit the form
        WebElement submit = driver.findElement(By.name("btn"));
        submit.click();
    }

}

