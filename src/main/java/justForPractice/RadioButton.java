package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo-project.wedevx.co/");

        WebElement element = driver.findElement(By.id("panel1bh-header"));
        element.click();

        WebElement radioButton = driver.findElement(By.id("radioButton_page"));
        radioButton.click();


        WebElement impressiveButton = driver.findElement(By.xpath("//input[@value='Impressive']"));
        impressiveButton.click();

        //assertTrue(impressiveButton.isSelected())
        System.out.println(impressiveButton.isSelected()); //true
        System.out.println("isEnabled: " + impressiveButton.isEnabled()); // true
        System.out.println("isDisplayed: " + impressiveButton.isDisplayed()); //false

        WebElement yesButton = driver.findElement(By.xpath("//input[@value='Yes']"));
        System.out.println(yesButton.isSelected());

        // if we have attribut like disabled we can't click on button


        WebElement noButton = driver.findElement(By.xpath("//input[@value='No']"));
        System.out.println("No button is Enabled? - " + noButton.isEnabled()); //false because it's indeed disabled
        //noButton.click(); // we are getting error intersected exception









    }
}
