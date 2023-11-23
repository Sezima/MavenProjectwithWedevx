package justForPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import java.util.concurrent.TimeUnit;

public class MultipleBrowsersSetUp {

    public static void main(String[] args) {
        WebDriver driver = multiBrowserSetup("");

        // Example: Open a website using the driver
        driver.get("https://dbank-qa.wedevx.co/bank/");

        // Perform additional actions as needed

        // Close the driver when done
        driver.quit();
    }

    private static WebDriver multiBrowserSetup(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "headless":
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1920,1080");
                options.addArguments("disable-extensions");
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("--proxy-server='direct://'");
                options.addArguments("--proxy-bypass-list=*");
                options.addArguments("--start-maximized");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
