package justForPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.Select;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class DropDown2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement select= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select selectButton=new Select(select);
        List<WebElement> aToZList=driver.findElements(By.xpath("//div[@class='inventory_item_description']"));
        for(WebElement element:aToZList){
            System.out.println(element.getText());
        }
        List<WebElement> zToA=new ArrayList<>();
        selectButton.selectByValue("za");
        List<WebElement> zToAList=driver.findElements(By.xpath("//div[@class='inventory_item_description']"));
        for(int i=zToAList.size()-1;i>=0;i--){
            zToA.add(zToAList.get(i));
        }
        WebElement select1= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select selectButton1=new Select(select1);
        selectButton1.selectByValue("lohi");
        List<WebElement> lowToHigh=driver.findElements(By.xpath("//div[@class='inventory_item_description']"));
        for(WebElement element:lowToHigh){
            System.out.println(element.getText());
        }
        WebElement select2= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select selectButton2=new Select(select2);
        selectButton2.selectByValue("hilo");
        List<WebElement> highToLow=driver.findElements(By.xpath("//div[@class='inventory_item_description']"));
        for(WebElement element:highToLow){
            System.out.println(element.getText());
        }
        System.out.println("Test1");


            Assertions.assertEquals(aToZList,zToA);
        if (aToZList.equals(zToA)) {
            System.out.println("Lists are equal");
        } else {
            System.out.println("Lists are NOT equal");
        }


    }
}