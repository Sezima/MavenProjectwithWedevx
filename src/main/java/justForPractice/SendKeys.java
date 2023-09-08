package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeys {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();




        driver.get("https://demo-project.wedevx.co/");

        Thread.sleep(10000);

        WebElement full_nameTxtBox = driver.findElement(By.id("name"));

        //sendkeys method takes a string that be popular to the  located txt box in html
        full_nameTxtBox.sendKeys("Osmonbaeva Sezim");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("example@gmail.com");


        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("123 Main St.");

        WebElement perAddress = driver.findElement(By.id("permanentAddress"));
        perAddress.sendKeys("456 Second St.");


        //MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1hw9j7s
        WebElement submit = driver.findElement(By.className("MuiButton-containedPrimary"));
        submit.click();


//        driver.quit();
    }
}
