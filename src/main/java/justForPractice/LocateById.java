package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateById {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo-project.wedevx.co/");


        //findElement - is a method that located ONE specific web element in an html by one of the locators

        //returns a webelement object
        WebElement element =  driver.findElement(By.id("panel1bh-header"));
                // //panel1bh-header

        Thread.sleep(10000); //10sec


        //click is a method that click on the idenitfied web element
        element.click();
    }
}
