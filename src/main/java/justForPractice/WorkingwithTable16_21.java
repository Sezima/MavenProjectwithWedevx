package justForPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashMap;
import java.util.Map;

public class WorkingwithTable16_21 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//task1: Go to https://practice-automation.com/tables/
        driver.get("https://practice-automation.com/tables/");
//task2: Create a map of products and their prices from the Simple Table. Print the map using toString() method without iteration or extraction
        Map<String, String> mapTable = new LinkedHashMap<>();

        String item1 = driver.findElement(By.xpath("//figure[@class='wp-block-table']/table/tbody[1]/tr[2]/td[1]")).getText();
        String price1 = driver.findElement(By.xpath("//figure[@class='wp-block-table']/table/tbody[1]/tr[2]/td[2]")).getText();
        String item2 = driver.findElement(By.xpath("//figure[@class='wp-block-table']/table/tbody[1]/tr[3]/td")).getText();
        String price2 = driver.findElement(By.xpath("//figure[@class='wp-block-table']/table/tbody[1]/tr[3]/td[2]")).getText();
        String item3 = driver.findElement(By.xpath("//figure[@class='wp-block-table']/table/tbody[1]/tr[4]/td")).getText();
        String price3 = driver.findElement(By.xpath("//figure[@class='wp-block-table']/table/tbody[1]/tr[4]/td[2]")).getText();

        mapTable.put(item1, price1);
        mapTable.put(item2, price2);
        mapTable.put(item3, price3);

        System.out.println(mapTable.toString());




//task3: Print Chinas population and rank in the format: China; Rank - 1; Population (million) - 1,439.3;
        WebElement findChinaRow = driver.findElement(By.xpath("//td[contains(text(), 'China')]/parent::tr"));
        String chinaRank = findChinaRow.findElement(By.xpath("td[1]")).getText();
        String chinaPopulation = findChinaRow.findElement(By.xpath("td[2]")).getText();

        System.out.printf("China; Rank - %s; Population (million) - %s", chinaRank, chinaPopulation);
        System.out.println();
        Thread.sleep(4000);
//task4: Sort the Table by country name


        WebElement tableSort = driver.findElement(By.xpath("//th[text()='Country']"));
        tableSort.click();
        Thread.sleep(2000);

//task5: Print the same info for first three countries from top after sorting*/
        String countryRank1 = driver.findElement(By.xpath("//tr[@class='row-9 even']/td[1]")).getText();
        String country1 = driver.findElement(By.xpath("//tr[@class='row-9 even']/td[2]")).getText();
        String countryPopulation1 = driver.findElement(By.xpath("//tr[@class='row-9 even']/td[3]")).getText();

        String countryRank2 = driver.findElement(By.xpath("//tr[@class='row-7 odd']/td[1]")).getText();
        String country2 = driver.findElement(By.xpath("//tr[@class='row-7 odd']/td[2]")).getText();
        String countryPopulation2 = driver.findElement(By.xpath("//tr[@class='row-7 odd']/td[3]")).getText();

        String countryRank3 = driver.findElement(By.xpath("//tr[@class='row-2 even']/td[1]")).getText();
        String country3 = driver.findElement(By.xpath("//tr[@class='row-2 even']/td[2]")).getText();
        String countryPopulation3 = driver.findElement(By.xpath("//tr[@class='row-2 even']/td[3]")).getText();

        System.out.println(country1 + ": Rank: " + countryRank1 + "; country population: " + countryPopulation1);
        System.out.println(country2 + ": Rank: " + countryRank2 + "; country population: " + countryPopulation2);
        System.out.println(country3 + ": Rank: " + countryRank3 + "; country population: " + countryPopulation3);
        driver.quit();






    }

    }
