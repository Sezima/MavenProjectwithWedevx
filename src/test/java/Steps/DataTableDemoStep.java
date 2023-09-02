package Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
public class DataTableDemoStep {


    @Given("a bank account with account number {string} and balance {string} in USD")
    public void a_bank_account_with_account_number_and_balance_in_usd(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("a bank account with account number {string} and balance {string} in EUR")
    public void a_bank_account_with_account_number_and_balance_in_eur(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I transfer ${int} from account {string} to account {string} in EUR")
    public void i_transfer_$_from_account_to_account_in_eur(Integer int1, String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the account balance for account {string} should be {string}")
    public void the_account_balance_for_account_should_be(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




//    data table below


    @Given("the following bank accounts with their respective balances:")
    public void the_following_bank_accounts_with_their_respective_balances(DataTable dataTable) {

    }
    @When("I transfer the following amounts between accounts:")
    public void i_transfer_the_following_amounts_between_accounts(DataTable dataTable) {

    }
    @Then("the account balances should be updated as follows:")
    public void the_account_balances_should_be_updated_as_follows(DataTable dataTable) {

    }





}
