package justForPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class WorkingWithTable16_21_New {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-automation.com/tables/");


        WebElement findChinaRow = driver.findElement(By.xpath("//td[contains(text(), 'China')]/parent::tr"));
        String chinaRank = findChinaRow.findElement(By.xpath("td[1]")).getText();
        String chinaPopulation = findChinaRow.findElement(By.xpath("td[2]")).getText();

        System.out.printf("China; Rank - %s; Population (million) - %s", chinaRank, chinaPopulation);
        System.out.println();
        Thread.sleep(4000);


        WebElement countryColumnHeader = driver.findElement(By.xpath("//th[contains(@aria-label, 'Country')]"));
        countryColumnHeader.click();


        WebElement tableBody = driver.findElement(By.xpath("//tbody[@class='row-hover']"));
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));


        int counter = 0;
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            if (columns.size() >= 3) {
                System.out.print(columns.get(1).getText() + ": Rank: " + columns.get(0).getText() + "; country population: " + columns.get(2).getText());
                System.out.println();
                counter++;

                // Break out of the loop after printing for the third row
                if (counter >= 3) {
                    break;
                }
            }
        }

        driver.quit();
    }

}




