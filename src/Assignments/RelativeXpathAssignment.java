package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpathAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://www.syntaxprojects.com/Xpath-homework.php");

        //Enter hobbies using Xpath
        WebElement hobbie = driver.findElement(By.xpath(
                "//input[@id=\"yourHobbiesId\"]"));
        hobbie.sendKeys("Working out, reading, coding");

        //Click the 'Click Here' button and verify the message
        WebElement clickHereButton = driver.findElement(By.xpath(
                "//button[@id=\"display_text\"]"));
        clickHereButton.click();

        Thread.sleep(2000);

        //Check the displayed message
        WebElement buttonMessage = driver.findElement(By.xpath(
                "//p[contains(text(),'Button Clicked')]"));
        System.out.println("Message displayed : " + buttonMessage.getText());

        //Enter favorite movie
        WebElement favorite_movie = driver.findElement(By.xpath(
                "//input[@id=\"favoriteMoviesId\"]"));
        favorite_movie.sendKeys("A star is born");

        ////Locate a specific text element on the page and prints it
        WebElement locateText = driver.findElement(By.xpath(
                "//label[contains(text(),'ipsum dolor sit amet')]"));
        System.out.println("Text located using contains (): " + locateText.getText());

        //Enter the city
        WebElement city = driver.findElement(By.xpath("//input[@id=\"yourCity\"]"));
        city.sendKeys("Chicago");

        //Enter email addresses
        WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"][1]"));
        email.sendKeys("oliveraaa@159");

        //Enter client name
        WebElement client_name = driver.findElement(By.xpath(
                "//input[@name=\"clientName\" and  @id=\"clientName\"]"));
        WebElement client_ID = driver.findElement(By.xpath(
                "//input[@name=\"clientId\" or  @id=\"clientId\"]"));
        client_name.sendKeys("Patricia");
        client_ID.sendKeys("195bbb");

        //Enter street number and house number
        WebElement street_No = driver.findElement(By.xpath(
                "//input[starts-with(@name,'Street')]"));
        WebElement house_No = driver.findElement(By.xpath("//input[@name=\"HouseNo\"]"));
        street_No.sendKeys("5700");
        house_No.sendKeys("57");

        //Wait for 5 sec to observe the result
        Thread.sleep(5000);

        //Close the browser
        driver.quit();


    }
}
