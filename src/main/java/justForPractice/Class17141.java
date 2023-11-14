package justForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Class17141 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("panel2bh-header")).click();
        driver.findElement(By.id("practiceForm_page")).click();
        WebElement firstName=driver.findElement(By.id("firstName"));
        Actions actions=new Actions(driver);
        actions.sendKeys(firstName,"Vader").keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL)
                .sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys("1").sendKeys(Keys.TAB).keyDown(Keys.CONTROL)
                .sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("@wedevx.co").sendKeys(Keys.ENTER).perform();


//        assertValidationErrorsArePresent(driver);
        WebElement errorMessage = driver.findElement(By.id("userMobile"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Validation: Fill in the field as it is required.");
        } else {
            System.out.println("Validation failed.");
        }
    }

//    private static void assertValidationErrorsArePresent(WebDriver driver) {
//        // Example assertion: Check if at least one validation error is present
//        Assert.assertTrue(driver.findElements(By.className("validation-error")).size() > 0,
//                "Validation errors are not displayed");
//    }
}
