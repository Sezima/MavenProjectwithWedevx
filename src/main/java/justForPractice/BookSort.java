//package justForPractice;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BookSort {
//    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://automationbookstore.dev/");
//
//        Thread.sleep(2000);
//
//        // Locate the input bar for filtering books by title
//        WebElement searchBar = driver.findElement(By.id("searchBar"));
//
//        // Filter the books by titles
//        filterBook(searchBar, "Test Automation");
//        filterBook(searchBar, "Cucumber");
//        filterBook(searchBar, "Java");
//        filterBook(searchBar, "Test");
//
//        // Wait for some time to observe the filtered results
//        Thread.sleep(3000);
//    }
//
//
//    private static void filterBook(WebElement filterInput, String title) throws InterruptedException {
//        // Clear the input field
//        filterInput.clear();
//
//        // Type the title
//        filterInput.sendKeys(title);
//
//        // Press Enter to submit the filter
//        filterInput.sendKeys(Keys.RETURN);
//
//        // Wait for some time to observe the filtered results
//        Thread.sleep(2000);
//    }
//}



package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BookSort {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationbookstore.dev/");

        Thread.sleep(2000);

        // Locate the input bar for filtering books by title
        WebElement searchBar = driver.findElement(By.id("searchBar"));

        // Filter the books by titles
        filterBook(searchBar, "Test Automation");
        filterBook(searchBar, "Cucumber");
        filterBook(searchBar, "Java");
        filterBook(searchBar, "Test");

        // Sort the filtered results by title in ascending order
        sortBooks(driver);

        // Wait for some time to observe the filtered and sorted results
        Thread.sleep(3000);

        // Close the browser
        driver.quit();
    }

    private static void filterBook(WebElement filterInput, String title) throws InterruptedException {
        // Clear the input field
        filterInput.clear();

        // Type the title
        filterInput.sendKeys(title);

        // Press Enter to submit the filter
        filterInput.sendKeys(Keys.RETURN);

        // Wait for some time to observe the filtered results
        Thread.sleep(2000);
    }

    private static void sortBooks(WebDriver driver) throws InterruptedException {
        // Assuming book titles are displayed in a certain format, modify the locator accordingly
        List<WebElement> bookTitles = driver.findElements(By.cssSelector(".book .title"));

        // Sort the book titles alphabetically
        for (int i = 0; i < bookTitles.size() - 1; i++) {
            String title1 = bookTitles.get(i).getText();
            String title2 = bookTitles.get(i + 1).getText();

            // Use if statement for sorting (in ascending order based on title)
            if (title1.compareTo(title2) > 0) {
                // Swap titles if they are not in the correct order
                WebElement temp = bookTitles.get(i);
                bookTitles.set(i, bookTitles.get(i + 1));
                bookTitles.set(i + 1, temp);

                // After swapping, go back to the beginning of the list to recheck
                i = -1;
            }
        }

        // Wait for some time to observe the sorted results
        Thread.sleep(2000);
    }
}
