package justForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class slideGpt {

        public static void main(String[] args) {
            // Set up ChromeDriver
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            // Navigate to the website
            driver.get("https://practice-automation.com/slider/");

            // Locate the slider element
            WebElement slider = driver.findElement(By.id("slider"));
            // Validate the default value is 25
            validateSliderValue(driver, "25");

            // Reset the slider to 0
            moveSliderTo(driver, slider, 0);
            validateSliderValue(driver, "0");

            // Slide the slider to 30
            moveSliderTo(driver, slider, 30);
            validateSliderValue(driver, "30");

            // Slide the slider to 60
            moveSliderTo(driver, slider, 60);

            // Slide it to 50 straight away
            moveSliderTo(driver, slider, 50);
            validateSliderValue(driver, "50");

            // Slide the slider to 99
            moveSliderTo(driver, slider, 99);
            validateSliderValue(driver, "99");

            // Close the browser
            driver.quit();
        }

    // Method to move the slider to a specific value
    private static void moveSliderTo(WebDriver driver, WebElement slider, int targetValue) {
        Actions actions = new Actions(driver);
        int currentValue = Integer.parseInt(driver.findElement(By.id("value")).getText());
        int offset = targetValue - currentValue;
        actions.dragAndDropBy(slider, offset * 5, 0).perform(); // Adjust the multiplier as needed
    }

    // Method to validate the slider value
    private static void validateSliderValue(WebDriver driver, String expectedValue) {
        WebElement result = driver.findElement(By.id("value"));
        if (!result.getText().equals(expectedValue)) {
            throw new RuntimeException("Slider value validation failed. Expected: " + expectedValue +
                    ", Actual: " + result.getText());
        }
        }

        }




