package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/cssSelector-homework.php");

        //Enter user ID
        WebElement user_ID = driver.findElement(By.cssSelector("#UserID"));
        user_ID.sendKeys("123B");

        //Enter user's name
        WebElement user_name = driver.findElement(By.cssSelector("#UserName"));
        user_name.sendKeys("Mike");

        //Enter Intro to Lecture
        WebElement intro = driver.findElement(By.cssSelector("input[name=\"LectureIntro\"].form-control"));
        intro.sendKeys("Introduction to Selenium");

        //Enter Feedback from Ray
        WebElement feedbackFromRay = driver.findElement(By.cssSelector("input[id=\"FeedbackFromRay\"]"));
        feedbackFromRay.sendKeys("Great explanation on locators");

        //Enter Feedback from Ducky
        WebElement feedbackFromDucky = driver.findElement(By.cssSelector("#FeedbackfromDucky"));
        feedbackFromDucky.sendKeys("The session on CSS selector was extremely helpful");

        //Enter client ID
        WebElement client_ID = driver.findElement(By.cssSelector("input[name=\"ClientID\"]"));
        client_ID.sendKeys("12345A");

        //Enter client email
        WebElement email = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        email.sendKeys("Mike@14569");

        //Enter course topic
        WebElement courseTopic = driver.findElement(By.cssSelector("input[name=\"CourseTopic\"]"));
        courseTopic.sendKeys("Advanced Selenium Webdriver Techniques");

    }
}
