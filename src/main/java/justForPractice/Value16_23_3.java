package justForPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Value16_23_3 {
//    public static void main(String[] args) {
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://www.wikipedia.org/");
//
//        WebElement numberOfArticles = driver.findElement(By.xpath("//div[@class='central-featured']//div[6]//bdi[@dir='ltr']"));
//        String dirAttributeValue = numberOfArticles.getAttribute("dir");
//
//        // Print the value of the "dir" attribute
//        System.out.println("Value of 'dir' attribute: " + dirAttributeValue);
//
//        driver.quit();
//    }
public static void main(String[] args) throws InterruptedException {
    // Setup WebDriver
    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();

    // Open Wikipedia
    driver.get("https://www.wikipedia.org/");

    // Wait for the page to load
    Thread.sleep(2000);


    WebElement centralFeaturedLang = driver.findElement(By.xpath("//div[@class='central-featured']//div[contains(@class, 'lang6')]"));
    WebElement frenchArticles = centralFeaturedLang.findElement(By.xpath(".//a[1]"));

    // Print the value
    System.out.println("Number of French articles: " + frenchArticles.getText());

    // Close the browser
//    driver.quit();
}
}
