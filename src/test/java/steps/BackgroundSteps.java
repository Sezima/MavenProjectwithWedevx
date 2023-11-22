package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundSteps {
//    @Given("user is on {string}")
//    public void user_is_on(String string) {
//
//    }

    @Given("user is logged in as {string} {string}")
    public void user_is_logged_in_as(String string, String string2) {

    }

    @When("user clicks on the transaction")
    public void user_clicks_on_the_transaction() {

    }

    @Then("user should see all transactions")
    public void user_should_see_all_transactions() {

    }

    @Given("user balance is {int}")
    public void user_balance_is(Integer int1) {

    }

    @When("user deposits {int}")
    public void user_deposits(Integer int1) {

    }

    @Then("user balance should be {int}")
    public void user_balance_should_be(Integer int1) {

    }

    @When("user withdraws {int}")
    public void user_withdraws(Integer int1) {

    }


    @Given("user is on {string}")
    public void user_is_on(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("user inputs his username {string} and password {string}")
    public void user_inputs_his_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("user clicks on login")
    public void user_clicks_on_login() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user is on home page")
    public void user_is_on_home_page() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user clicks on Checking")
    public void user_clicks_on_checking() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user clicks on New Checking")
    public void user_clicks_on_new_checking() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user selects {string} account ownership")
    public void user_selects_account_ownership(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user inputs account name {string}")
    public void user_inputs_account_name(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user inputs initial deposit ${string}")
    public void user_inputs_initial_deposit_$(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user clicks on submit.")
    public void user_clicks_on_submit() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user should be displayed with error message")
    public void user_should_be_displayed_with_error_message() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("validate no account was created")
    public void validate_no_account_was_created() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("the user fills in the registration form with the following data")
    public void the_user_fills_in_the_registration_form_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        // Ваш код для заполнения регистрационной формы данными из DataTable
        // Пример:
        // Map<String, String> data = dataTable.asMap(String.class, String.class);
        // Здесь вы можете использовать данные из data для заполнения формы
    }

    @When("the user submits the form")
    public void the_user_submits_the_form() {
        // Ваш код для отправки формы
    }

    @Then("the account creation is successful")
    public void the_account_creation_is_successful() {
        // Ваш код для проверки успешного создания аккаунта
    }

}
