package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPATH {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");


        Thread.sleep(2000);

        WebElement formsSelectionButton = driver.findElement(By.id("panel2bh-header"));
        formsSelectionButton.click();

        Thread.sleep(2000);

        WebElement practiceFormButton = driver.findElement(By.id("practiceForm_page"));
        practiceFormButton.click();

        Thread.sleep(2000);

        WebElement titleElement = driver.findElement(By.xpath("//h3"));
        System.out.println(titleElement.getText());

    }
}
