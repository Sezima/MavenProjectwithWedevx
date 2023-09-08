package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safariforpractic {
    public static void main(String[] args) {
//        WebDriver driver = new SafariDriver();
//        driver.get("https://amazom.com");


        WebDriver driver = new ChromeDriver();

        // Perform actions on Firefox
        driver.get("https://amazom.com");
        // ...

        // Close the browser
        driver.quit();
//https://demo-project.wedevx.co/



    }
}

/*
Ошибка, которую вы видите, связана с тем, что вы пытаетесь использовать SafariDriver, который требует, чтобы Safari версии 10 и выше работал на macOS El Capitan или более новей.

Поскольку вы работаете на Linux, SafariDriver не является подходящим вариантом, так как он предназначен исключительно для Safari на macOS.


* */
