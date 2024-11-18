package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvanceXpathAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to the targeted webpage
        driver.get("https://syntaxprojects.com/advanceXpath-homework.php");

        //Enter names of the books
        WebElement book1 = driver.findElement(By.xpath("//input[@id='least-favorite']"));
        book1.sendKeys("Pride and Prejudice");
        WebElement book2 = driver.findElement(By.xpath(
                "//input[@id='least-favorite']/preceding-sibling::input[1]"));
        book2.sendKeys("To kill a Mockingbird");
        WebElement book3 = driver.findElement(By.xpath(
                "//input[@id='least-favorite']/preceding-sibling::input[2]"));
        book3.sendKeys("The Alchemist");

        //Enter the names of the favorite books
        WebElement favoriteBook1 = driver.findElement(By.xpath(
                "//input[@id='favouriteBook']"));
        favoriteBook1.sendKeys("Pride and Prejudice");
        WebElement favoriteBook2 = driver.findElement(By.xpath(
                "//input[@id='favouriteBook']/following-sibling::input[1]"));
        favoriteBook2.sendKeys("To kill a Mockingbird");
        WebElement favoriteBook3 = driver.findElement(By.xpath(
                "//input[@id='favouriteBook']/following-sibling::input[2]"));
        favoriteBook3.sendKeys("The Alchemist");

        //Enter the names in order grandparent, parent, child
        WebElement grandparent = driver.findElement(By.xpath(
                "//div[@id='familyTree']//input[1]"));
        grandparent.sendKeys("Grandparent");
        WebElement parent = driver.findElement(By.xpath(
                "//div[@id=\"familyTree\"]//input[2]"));
        parent.sendKeys("Parent");
        WebElement child = driver.findElement(By.xpath(
                "//div[@id=\"familyTree\"]//input[3]"));
        child.sendKeys("Child");

        //Close the browser
        //driver.quit();


    }
}
