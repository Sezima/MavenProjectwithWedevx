package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FluentWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo-project.wedevx.co/");

        WebElement dynamicProperties = driver.findElement(By.id("dynamicProperties_page"));
        dynamicProperties.click();

//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(5, TimeUnit.SECONDS)
//                .pollingEvery(500, TimeUnit.MILLISECONDS)  // Adjust this value as needed
//                .ignoring(NoSuchElementException.class);
//
//        WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
//        enableButton.click();

        // Rest of your code
    }


    //крч есть такой способ но этот код не работает






}
