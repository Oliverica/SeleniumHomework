package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverCommandsAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to Google and print the title of the page
        driver.get("www.google.com");
        System.out.println("Google Page Title: " + driver.getTitle());

        //Navigate to Syntax Projects and print the title of the page
        driver.get("https://www.syntaxprojects.com/");
        System.out.println("Syntax Page Title: " + driver.getTitle());

        //Navigate back to Google
        driver.navigate().back();

        //Refresh the page
        driver.navigate().refresh();

        //Close the browser
        driver.quit();
    }
}
