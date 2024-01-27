package justForPractice;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumPractice {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");

        Thread.sleep(2000);
        WebElement webTableButton = driver.findElement(By.id("webTables_page"));
        webTableButton.click();

        Thread.sleep(2000);
        WebElement firstColumnHeader = driver.findElement(By.xpath("//table/thead/tr/th[2]"));
        assertEquals("Dessert (100g serving)", firstColumnHeader.getText() );

    }
}
