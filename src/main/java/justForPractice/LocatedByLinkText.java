package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatedByLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");


        Thread.sleep(10000);

        WebElement linkspage = driver.findElement(By.id("links_page"));
        linkspage.click();


        WebElement textlinks = driver.findElement(By.linkText("Created"));
        textlinks.click();
    }
}
