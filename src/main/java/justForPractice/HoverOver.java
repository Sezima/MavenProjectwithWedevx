package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HoverOver {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo-project.wedevx.co/");

        WebElement widgets = driver.findElement(By.id("panel4bh-header"));
        widgets.click();


        WebElement toolTips = driver.findElement(By.id("toolTips_page"));
        toolTips.click();

        WebElement textBox = driver.findElement(By.xpath("//label[contains(text(), 'Hover')]/.."));

        Actions actions = new Actions(driver);

        actions.moveToElement(textBox).perform();

        String hoverOverMessage = textBox.getAttribute("aria-label");
        System.out.println(hoverOverMessage);

        Thread.sleep(3000);
        driver.quit();



    }
}
