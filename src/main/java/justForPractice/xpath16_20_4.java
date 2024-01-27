package justForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath16_20_4 {
    public static void main(String[] args) throws InterruptedException {
        final String firstName = "Johny";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        Thread.sleep(2000);

        WebElement customersBtn = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        customersBtn.click();
        Thread.sleep(2000);

        WebElement addcustomer = driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        addcustomer.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Don");
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("12345");
        Thread.sleep(3000);

        WebElement addCustomerBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        addCustomerBtn.click();
        Thread.sleep(10000);

        WebElement customers = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        customers.click();

        Thread.sleep(5000);
        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Accept the alert (clicking OK)
        alert.accept();

        Thread.sleep(5000);
        WebElement deleteButton = driver.findElement(By.xpath("//td[text()='Johny']/following-sibling::td[4]/button[text()='Delete']"));
        deleteButton.click();


        driver.quit();
    }
}
