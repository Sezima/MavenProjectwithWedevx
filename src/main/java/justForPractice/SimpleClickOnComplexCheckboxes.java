package justForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SimpleClickOnComplexCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo-project.wedevx.co/");

        WebElement checkBox = driver.findElement(By.id("webTables_page"));
        checkBox.click();

        Thread.sleep(2000);

        // Check checkboxes on the main tab
        WebElement checkboxCupcake = driver.findElement(By.xpath("//input[@aria-labelledby='enhanced-table-checkbox-3']"));
        checkboxCupcake.click();
        Thread.sleep(2000);

        // Assuming you are using By.xpath in Selenium
        WebElement checkboxEclair = driver.findElement(By.xpath("//input[@aria-labelledby='enhanced-table-checkbox-2']"));
        checkboxEclair.click();
        Thread.sleep(2000);


        WebElement checkboxMarshmallow = driver.findElement(By.id("enhanced-table-checkbox-4"));
        checkboxMarshmallow.click();
        Thread.sleep(2000);

        // Click on the next page
        WebElement nextPageButton = driver.findElement(By.xpath("//button[@aria-label='Go to next page']"));
        nextPageButton.click();
        Thread.sleep(2000);




        // Check checkboxes on the next page
        WebElement checkboxLollipop = driver.findElement(By.id("enhanced-table-checkbox-3"));
        checkboxLollipop.click();

        WebElement checkboxNougat = driver.findElement(By.id("enhanced-table-checkbox-1"));
        checkboxNougat.click();

        // Close the browser
        driver.quit();
    }



}








