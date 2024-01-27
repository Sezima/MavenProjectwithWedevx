package justForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class seleniumPractice16_26 {
@Test
    public void test1() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demo-project.wedevx.co/");
        Thread.sleep(2000);

        WebElement webTablesButton = driver.findElement(By.id("webTables_page"));
        webTablesButton.click();
        Thread.sleep(2000);

        WebElement firstColumHeather = driver.findElement(By.xpath("//table/thead/tr/th[2]"));
        assertEquals("Dessert (100g serving)", firstColumHeather.getText());

    }
}



