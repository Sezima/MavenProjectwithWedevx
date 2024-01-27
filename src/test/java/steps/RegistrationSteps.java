package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utils.ConfigReader;


import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Driver.getDriver;

public class RegistrationSteps{

    RegistrationPage registrationPage = new RegistrationPage(getDriver());

    @Given("User navigates to digital Bank signup page")
    public void user_navigates_to_digital_bank_signup_page() {
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.registrationpageurl"));
        assertEquals("Digital Bank", getDriver().getTitle(), "Registration page Title mismatch");
    }

    @When("User creates account with following fields")
    public void user_creates_account_with_following_fields(List<Map<String, String>> registrationTestDataListMap) {
        registrationPage.fillOutRegistrationForm(registrationTestDataListMap);
    }

    @Then("User should be displayed with the message {string}")
    public void user_should_be_displayed_with_the_message(String expectedSuccessMessage) {
        assertEquals(expectedSuccessMessage, registrationPage.getMessage(), "Success message mismatch");
    }

    @Then("User should see the {string} required field message {string}")
    public void userShouldSeeTheRequiredFieldMessage(String fieldName, String expectedErrorMessage) {
        String actualErrorMessage = registrationPage.getRequiredFieldErrorMessage(fieldName);
        assertEquals(expectedErrorMessage, actualErrorMessage, "The error message of required " + fieldName + " field mismatch.");
    }

    @Then("The following user info should be saved in the DB")
    public void theFollowingUserInfoShouldBeSavedInTheDB(List<Map<String, String>> expectedUserProfileInfoInDBList) {
        // Placeholder for future implementation or leave it empty if not implementing yet
    }


}

