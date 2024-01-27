package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class slider {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://practice-automation.com/slider/");

        WebElement slider = driver.findElement(By.id("slideMe"));

        Actions actions = new Actions(driver);

        //Value by default is 25, reset it to 0 first
         actions.dragAndDropBy(slider, -10, 25).perform();
        Thread.sleep(3000);

        // Ensure the default value is 25

        Assertions.assertEquals("0", driver.findElement(By.id("value")).getText());


//        //Now slide it to 30 and validate the result
//        actions.dragAndDropBy(slider, 130, 25).perform();
//        Assertions.assertEquals("30", driver.findElement(By.id("value")).getText());
//
//        //After slide it to 60 and to 50 straight away, validate the result
//
//        actions.dragAndDropBy(slider, 60, 25).perform();
//        actions.dragAndDropBy(slider, -10, 25).perform();
//        Assertions.assertEquals("50", driver.findElement(By.id("value")).getText());
//
//        actions.dragAndDropBy(slider, 99, 25).perform();
//        Assertions.assertEquals("99", driver.findElement(By.id("value")).getText());
        driver.close();






    }
}
