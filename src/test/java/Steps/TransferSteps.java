package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//One java step definitions file per one feature file
public class TransferSteps {


//     @Given("User with account number {int} is registered") this is regex
    @Given("User with account number {int} is registered")
    public void user_with_account_number_is_registered(int param) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("My first give steps. What ride with wedevx");
        System.out.println("Print out account number: " + param);
    }
    @Given("User with account number {int} deposited ${int}")
    public void user_with_account_number_deposited_$(Integer accountNum, double depositAccount) {
        System.out.println("Print out accountNumber: " + accountNum);
        System.out.println("Print out DepositAccount: " + depositAccount);
    }
    @When("User with account number {int} transfers ${int}")
    public void user_with_account_number_transfers_$(Integer accountNum, double transferAmount) {
        System.out.println("Print Transfer Amount: " + transferAmount);

    }
    @Then("User with account number {int} should have ${int} in balance")
    public void user_with_account_number_should_have_$_in_balance(Integer accountNum, double balance) {
        System.out.println("Print balance: ");
    }
    @Then("User should see Insufficient Funds message")
    public void user_should_see_insufficient_funds_message() {
        System.out.println("Then");
    }

//    do myself

    @Then("User should see Insufficient funds message")
    public void user_should_see_Insufficient_funds_message() {
        System.out.println("test");
        System.out.println("test");

    }

    @Given("Users on {string}")
    public void users_on(String envUrl) {
        System.out.println("going to: " + envUrl);
    }

}
