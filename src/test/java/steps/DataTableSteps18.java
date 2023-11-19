//package steps;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.And;
////import io.cucumber.junit.Cucumber;
////import org.junit.runner.RunWith;
////import io.cucumber.junit.platform.engine.Cucumber;
//import io.cucumber.junit.platform.engine.Cucumber;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@
//    public class DataTableSteps18 {
//        static WebDriver driver;
//
//        @Given("^the user is on the registration page$")
//        public void givenTheUserIsOnTheRegistrationPage() {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://dbank-qa.wedevx.co/bank/login");
//
//            WebElement signUpBtn = driver.findElement(By.xpath("//a[text()=' Sign Up Here']"));
//            signUpBtn.click();
//        }
//
//        @When("^the user fills in the registration form with the following data$")
//        public void whenTheUserFillsInTheRegistrationForm(DataTable dataTable) {
//            // Get data from the DataTable
//            Map<String, String> data = dataTable.asMap(String.class, String.class);
//
//            WebElement selectTitle = driver.findElement(By.id("title"));
//            selectTitle.click();
//            Select select = new Select(selectTitle);
//            select.selectByValue(data.get("Title"));
//
//            WebElement firstName = driver.findElement(By.id("firstName"));
//            firstName.sendKeys(data.get("FirstName"));
//
//            // Continue filling out other form fields...
//        }
//
//        @And("^the user submits the form$")
//        public void andTheUserSubmitsTheForm() {
//            WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
//            submitBtn.click();
//        }
//
//        @Then("^the account creation is successful$")
//        public void thenTheAccountCreationIsSuccessful() {
//            WebElement successTxt = driver.findElement(By.xpath("//span[text()='Success']"));
//            assertEquals("Success", successTxt.getText());
//            driver.quit();
//        }
//    }
