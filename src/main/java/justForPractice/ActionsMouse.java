package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

public class ActionsMouse {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo-project.wedevx.co/");

        WebElement buttonsPage = driver.findElement(By.id("buttons_page"));
        buttonsPage.click();


        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        // I can't use 2 times click like doubleClick.click() doubleClick.click() i should use actions

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();

        //I can meet about actions in interview
        //How do you perform advanced mouse interactions. for example like double click or right click
        //And i can answer i use actions class from selenium that also has methods double click / right click ect

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClick).perform();

        WebElement clickMe = driver.findElement(By.id("TiIX0"));
        actions.click(clickMe).perform();


    }
}
