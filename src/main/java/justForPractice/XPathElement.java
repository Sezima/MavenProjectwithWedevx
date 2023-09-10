package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");


        Thread.sleep(2000);




        Thread.sleep(2000);

        WebElement brokenLinksImage = driver.findElement(By.id("broken_page"));
        brokenLinksImage.click();

        Thread.sleep(2000);

        WebElement brokenPage = driver.findElement(By.xpath("//button[@id='broken_page']"));
        brokenPage.click();


        Thread.sleep(2000);

        WebElement brokenImage = driver.findElement(By.xpath("//img[@src='/image/gg.png']"));
        System.out.println(brokenImage.getText());
        String attributeValue = brokenImage.getAttribute("src");
        System.out.println(attributeValue);

        System.out.println(brokenImage.getAttribute("alt"));


        System.out.println(brokenPage.getAttribute("alt"));


        Thread.sleep(2000);


        WebElement validImage = driver.findElement(By.xpath("//a[@href='https://www.wedevx.co/']"));
        System.out.println(validImage.getText());




    }
}


/*
- ***findElement*** method is used to access a single web element on a page.
- It returns the first matching element.
- It throws a **NoSuchElementException**

exception when it fails to find the element.

- ***findElements*** method returns the **list** of all matching elements.
- It returns an **empty list** when the element is not available or doesn’t exist on the page. It doesn’t throw NoSuchElementException.*/
