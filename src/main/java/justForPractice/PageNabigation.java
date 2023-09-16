package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageNabigation {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://dbank-qa.wedevx.co/bank/");

        Thread.sleep(2000);

        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),' Sign Up Here')]"));
        signUpLink.click();

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);

        Thread.sleep(10000);
        driver.close();
    }



}
