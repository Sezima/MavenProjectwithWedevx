package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop3 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://practice-automation.com/gestures/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement img=  driver.findElement(By.id("dragMe"));
        WebElement box2=driver.findElement(By.id("div2"));
        action.dragAndDrop(img,box2).perform();
    }
}
