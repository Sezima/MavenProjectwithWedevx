package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo-project.wedevx.co/");

        WebElement checkBox = driver.findElement(By.id("checkBox_page"));
        checkBox.click();


        WebElement checkBoxChild1 = driver.findElement(By.xpath("//label[@id='child1']//input"));
        System.out.println("child1 is selected: " + checkBoxChild1.isSelected()); //true
        checkBoxChild1.click();
        System.out.println("child1 is selected after click: " + checkBoxChild1.isSelected()); //false
    }
}
