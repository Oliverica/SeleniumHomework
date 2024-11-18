package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FireFoxBrowserAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //navigate to the URL
        driver.get("https://www.syntaxprojects.com/");

        //maximize the browser window
        driver.manage().window().maximize();

        //print the current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current url: " + currentUrl);

        String expectedUrl = "https://www.syntaxprojects.com/";
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("URL verification passed.");
        } else {
            System.out.println("URL verification failed.");
        }

        //get the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        //verify that the page title matches the expected title
        String expectedTitle = "Syntax - Website to practice Syntax Automation Platform";
        if (pageTitle.trim().equals(expectedTitle)) {
            System.out.println("Title verification passed.");
        } else {
            System.out.println("Title verification failed.");
        }
        //wait 3 sec before closing the browser
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close the browser
        driver.quit();


    }
}
