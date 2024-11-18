package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IframeAssignment {
    public static void main(String[] args) {

        //Navigate to `https://syntaxprojects.com/handle-iframe-homework.php`

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://syntaxprojects.com/handle-iframe-homework.php");

        //Enter the username, select a city, and click on the age checkbox while correctly handling iframes.
        driver.switchTo().frame(0);
        WebElement username = driver.findElement(By.xpath("//input[@name='Username']"));
        username.sendKeys("Olivera");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("dropdownIframe");
        WebElement citySelection = driver.findElement(By.xpath("//select[@id='cities']"));

        Select select = new Select(citySelection);

        List<WebElement> cities = select.getOptions();
        for (WebElement city : cities) {
            String cityText = city.getText().trim();

            if (cityText.equals("Chicago")) {
                city.click();
                System.out.println("Chicago is selected");
                break;
            }
        }
        driver.switchTo().frame("checkbox-iframe");

        WebElement ageCB = driver.findElement(By.xpath("//input[@class='cb1-element']"));
        ageCB.click();

    }
}
