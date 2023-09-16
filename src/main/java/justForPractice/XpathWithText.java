package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathWithText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");


        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("//button[@id='buttons_page']"));
        button.click();

        Thread.sleep(2000);

        WebElement doubleClickMeButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        doubleClickMeButton.click();
        doubleClickMeButton.click();
    }
}


//input[starts-with(@id, 'abc')]

//input[ends-with(@id, 'abc')]

//input[ends-with(text(), 'abc')]

//input[contains(text(), 'abc')]