package justForPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GlobusTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://globus-online.kg/?gclid=CjwKCAiAp5qsBhAPEiwAP0qeJq2G8pwO9676SkvaoQgIH8W6nqemwA6FpZczcxw9e0bYSxwwmsPBIhoCNBEQAvD_BwE");

Thread.sleep(3000);
        WebElement meat = driver.findElement(By.linkText("Регистрация"));
        meat.click();

Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@name='REGISTER[NAME]']"));
        username.sendKeys("Sezim");

    }
}
