package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        JavascriptExecutor js = (JavascriptExecutor) driver;

//        in js window.location='url' -> driver.get('url')
        js.executeScript("window.location='https://www.etsy.com/'");

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0, 2000)");

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0, -1000)");

        Thread.sleep(5000);

        WebElement helpCenterLink = driver.findElement(By.xpath("//a[contains(text(), 'Help Center']"));
        js.executeScript("arguments[0].scrollIntoView()", helpCenterLink);

        Thread.sleep(2000);

        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
        js.executeScript("arguments[0].scrollIntoView()", signInButton);

        Thread.sleep(2000);

        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red')", signInButton);
        Thread.sleep(3000);

        js.executeScript("arguments[0].click()", signInButton);


    }
}
