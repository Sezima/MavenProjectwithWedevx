package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateBeName {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");


        Thread.sleep(10000);

        WebElement currentAddress = driver.findElement(By.name("currentAddress"));
        currentAddress.sendKeys("123 Main St");


        WebElement perAddress = driver.findElement(By.name("permanentAddress"));
        perAddress.sendKeys("456 Second St");




    }
}
