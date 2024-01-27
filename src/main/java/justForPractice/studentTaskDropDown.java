package justForPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class studentTaskDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

        WebElement formsButton = driver.findElement(By.id("panel2bh-header"));
        formsButton.click();

        Thread.sleep(3000);

        WebElement practiceFormButton = driver.findElement(By.id("practiceForm_page"));
        practiceFormButton.click();

        Thread.sleep(3000);
        WebElement selectStateButton = driver.findElement(By.id("react-select-6-input"));
        Select stateDropDownText = new Select(selectStateButton);

        Thread.sleep(3000);
        List<WebElement> allStatesOption =  stateDropDownText.getOptions();

        for(WebElement state: allStatesOption) {
            System.out.println(state.getText());
        }

    }
}