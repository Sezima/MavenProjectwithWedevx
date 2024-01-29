package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.DBUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Driver.getDriver;

public class RegistrationSteps{

    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    List<Map<String, Object>> nextValList = new ArrayList<>();
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

    @And("the user clicked on the submit button")
    public void theUserClickedOnTheSubmitButton() {

        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickNextButton();
    }

    @Then("The following user info should be saved in the DB")
    public void theFollowingUserInfoShouldBeSavedInTheDB(List<Map<String, String>> expectedUserProfileInfoInDBList) {

        Map<String, String> expectedUserInfoMap = expectedUserProfileInfoInDBList.get(0);

        String queryUserTable = String.format("SELECT * FROM users WHERE username = '%s'", expectedUserInfoMap.get("email"));
        String queryUserProfile = String.format("SELECT * FROM user_profile WHERE email_address = '%s'", expectedUserInfoMap.get("email"));

        List<Map<String, Object>> actualUserinfoList = DBUtils.runSQLSelectQuery(queryUserTable);
        List<Map<String, Object>> actualUserProfileInfoList = DBUtils.runSQLSelectQuery(queryUserProfile);

        assertEquals(1, actualUserinfoList.size(), "registration generated unexpected number of users");
        assertEquals(1, actualUserProfileInfoList.size(), "registration generated unexpected number of users");

        Map<String, Object> actualUserInfoMap = actualUserinfoList.get(0);
        Map<String, Object> actualUserProfileInfoMap = actualUserProfileInfoList.get(0);


        assertEquals(expectedUserInfoMap.get("title"), actualUserProfileInfoMap.get("title"), "registration generated wrong title");
        assertEquals(expectedUserInfoMap.get("firstName"), actualUserProfileInfoMap.get("first_name"), "registration generated wrong first name");
        assertEquals(expectedUserInfoMap.get("lastName"), actualUserProfileInfoMap.get("last_name"), "registration generated wrong last name");
        assertEquals(expectedUserInfoMap.get("gender"), actualUserProfileInfoMap.get("gender"), "registration generated wrong gender");
        //assertEquals(expectedUserInfoMap.get("dateOfBirth"), actualUserProfileInfoMap.get("dob"), "registration generated wrong date of birth");
        assertEquals(expectedUserInfoMap.get("ssn"), actualUserProfileInfoMap.get("ssn"), "registration generated wrong ssn");
        assertEquals(expectedUserInfoMap.get("email"), actualUserProfileInfoMap.get("email_address"), "registration generated wrong email address");
        assertEquals(expectedUserInfoMap.get("address"), actualUserProfileInfoMap.get("address"), "registration generated wrong address");
        assertEquals(expectedUserInfoMap.get("locality"), actualUserProfileInfoMap.get("locality"), "registration generated wrong locality");
        assertEquals(expectedUserInfoMap.get("region"), actualUserProfileInfoMap.get("region"), "registration generated wrong region");
        assertEquals(expectedUserInfoMap.get("postalCode"), actualUserProfileInfoMap.get("postal_code"), "registration generated postal_code");
        assertEquals(expectedUserInfoMap.get("country"), actualUserProfileInfoMap.get("country"), "registration generated wrong country");
        assertEquals(expectedUserInfoMap.get("homePhone"), actualUserProfileInfoMap.get("home_phone"), "registration generated wrong home phone");
        assertEquals(expectedUserInfoMap.get("mobilePhone"), actualUserProfileInfoMap.get("mobile_phone"), "registration generated wrong mobile phone");
        assertEquals(expectedUserInfoMap.get("workPhone"), actualUserProfileInfoMap.get("work_phone"), "registration generated wrong  work phone");
        assertEquals(nextValList.get(0).get("next_val"), actualUserInfoMap.get("id"), "ID mismatch");

        long expectedUserProfileId = Integer.parseInt(String.valueOf(nextValList.get(0).get("next_val")));
        assertEquals(++expectedUserProfileId, actualUserInfoMap.get("id"), "ID mismatch");
        System.out.println(expectedUserProfileId);

    }




    @Given("The user with {string} is not in DB")
    public void theUserWithIsNotInDB(String email) {

        String queryForUserProfile = String.format("DELETE from user_profile where email_address='%s'", email);
        String queryForUsers = String.format("DELETE from users where username ='%s'", email);

//        String queryToGetNextValInHibernateSeqTable = String.format("select * from hibernate_sequence");
//      nextValList  = DBUtils.runSQLSelectQuery(queryToGetNextValInHibernateSeqTable);

        DBUtils.runSQLUpdateQuery(queryForUserProfile);
        DBUtils.runSQLUpdateQuery(queryForUsers);
    }

}

