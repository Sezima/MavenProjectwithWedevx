package Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import models.Order;
public class BackgroundStep {


    @Given("user is on {string}")
    public void user_is_on(String string) {
 }
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


}
