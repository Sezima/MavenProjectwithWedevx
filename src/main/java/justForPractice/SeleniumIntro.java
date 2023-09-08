package justForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumIntro {
    //WebdriverManager is a class that has different browser drivers.


    // for every selenium project that executers test on chrom browser should setop chromdriver al lease 1 time
    public static void main(String[] args) {
        //webdriver manager is a class that has
        //different browser drivers.
        //for every Selenium project that
        //executes tests on chrome browser
        //should setup chromedriver at least 1 time.
        WebDriverManager.chromedriver().setup();

        //WebDriver is a Selenium Interface
        //that represents all browser drivers.
        //implementations are
        //ChromeDriver();
        //SafariDriver()'
        //IEDriver();
        //FirefoxDriver();
        //new ChromeDriver() will open a browser.
        WebDriver driver = new ChromeDriver();

        //get method is a method that directs
        //your browser to a specific webpage.

//        driver.get("https://www.wedevx.co/");
        driver.get("https://www.google.com/");

        driver.quit();
    }
}

// selenium or our java program cannot really go directly talk to the browser. so there is  your java program with selenium Library
// Then there is one executable file which is called Drivers
// And so java is  gonna send the command to the driver, and driver is gonna go deal with the browser driver is actually gonna send the comments to the browser
// So there is this one extra file that is in between our selenium project and the browsers.

