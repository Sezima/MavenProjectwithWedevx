package justForPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class simpleText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage with the modal
        driver.get("https://practice-automation.com/modals/");
        Thread.sleep(2000);

        // Click on the element with the id "simpleModal" to open the modal
        driver.findElement(By.id("simpleModal")).click();
        Thread.sleep(1000);

        // Find the element by its class name using a valid CSS selector

        String te = driver.findElement(By.xpath("//div[@id='popmake-1318']//div[2]")).getText();

        // Print the text
        System.out.println(te);

        // Close the browser
        driver.quit();
    }
}
