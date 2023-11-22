package justForPractice;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertChecking {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);
        String expectedUrl = "https://dbank-qa.wedevx.co/bank/login";
        assertEquals(expectedUrl, driver.getCurrentUrl(), "It didn't go to " + expectedUrl);
    }
    @Given("user inputs his username {string} and password {string}")
    public void user_inputs_his_username_and_password(String username, String password
    ) {
        WebElement userName=driver.findElement(By.id("username"));
        WebElement pwd=driver.findElement(By.id("password"));
        userName.sendKeys(username);
        pwd.sendKeys(password);
    }
    @Given("user clicks on login")
    public void user_clicks_on_login() {
        WebElement signInBtn=driver.findElement(By.id("submit"));
        signInBtn.click();
    }
    @When("user is on home page")
    public void user_is_on_home_page() {
        String expectedUrl="https://dbank-qa.wedevx.co/bank/home";
        assertEquals(expectedUrl,driver.getCurrentUrl(),"It didnt go to "+expectedUrl);
    }
    @When("user clicks on Checking")
    public void user_clicks_on_checking() {
        WebElement checking=driver.findElement(By.id("checking-menu"));
        checking.click();
    }
    @When("user clicks on New Checking")
    public void user_clicks_on_new_checking() {
        WebElement newChecking=driver.findElement(By.id("new-checking-menu-item"));
        newChecking.click();
    }
    @When("user selects {string} account ownership")
    public void user_selects_account_ownership(String string) {
        WebElement individual=driver.findElement(By.id("Individual"));
        individual.click();
    }
    @When("user inputs account name {string}")
    public void user_inputs_account_name(String accountName) {
        WebElement accName=driver.findElement(By.id("name"));
        accName.sendKeys(accountName);
    }
    @When("user inputs inital deposit ${string}")
    public void user_inputs_inital_deposit_$(String deposit) {
        WebElement initialDeposit=driver.findElement(By.id("openingBalance"));
        initialDeposit.sendKeys(deposit);
    }
    @Then("user clicks on submit.")
    public void user_clicks_on_submit() {
        WebElement submit=driver.findElement(By.id("newCheckingSubmit"));
        submit.click();
    }
    @Then("user should be displayed with error message")
    public void user_should_be_displayed_with_error_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.accept();
        if (driver.getPageSource().contains("text in alert"))
            System.out.println("your text");
    }
    @Then("validate no account was created")
    public void validate_no_account_was_created() {

    }
}
