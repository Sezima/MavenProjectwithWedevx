package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class KeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://demo-project.wedevx.co/");

        WebElement buttonsPage = driver.findElement(By.id("panel2bh-header"));
        buttonsPage.click();

        Thread.sleep(5000);

        WebElement practiceForm = driver.findElement(By.id("practiceForm_page"));
        practiceForm.click();

        Thread.sleep(5000);


        WebElement firstName = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
//        it's not working
//        actions.sendKeys(firstName, "Airi").keyDown(Keys.chord(Keys.CONTROL, "a").sendKeys("c").sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").perform();


        firstName.sendKeys("Airi");
        firstName.sendKeys(Keys.CONTROL + "a");
        firstName.sendKeys(Keys.CONTROL + "c");
        firstName.sendKeys(Keys.TAB, Keys.CONTROL + "v");




    }
}
