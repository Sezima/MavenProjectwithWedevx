package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CheckingModal16_17_1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://practice-automation.com/modals/");

        WebElement simpleModalButton = driver.findElement(By.id("simpleModal"));
        simpleModalButton.click();

        Thread.sleep(2000);
        // Locate the title and text elements on the modal
        WebElement titleElement = driver.findElement(By.id("pum_popup_title_1318"));
        WebElement textElement = driver.findElement(By.xpath("//div[@class='pum-content popmake-content']/p[text()='Hi, I’m a simple modal.']"));

        // Print the title and text
        System.out.println("Title: " + titleElement.getText());
        System.out.println("Text: " + textElement.getText());

//        WebElement closeButton = driver.findElement(By.xpath("//button[@class='pum-close popmake-close' and @aria-label='Close']"));
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].click();", closeButton);
//


        WebElement closeButton = driver.findElement(By.xpath("//button[@class='pum-close popmake-close' and @aria-label='Close']"));
        if (closeButton.isDisplayed() && closeButton.isEnabled()) {
            closeButton.click();
        }

    }
}
