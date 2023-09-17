package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferSteps {
    @Given("User with account number {int} is registered")
    public void user_with_account_number_is_registered(Integer accountNum) {
        System.out.println("This is Given");
        System.out.println("This is account number: " + accountNum);
    }

    @Given("User with account number {int} deposits ${double}")
    public void user_with_account_number_deposites_$(Integer accountNum, double depositAmount) {
        System.out.println("this is And");
        System.out.println("this is account number: " + accountNum);
        System.out.println("this is deposit amount: " + depositAmount);

    }

    @When("User with account number {int} transfers ${double}")
    public void user_with_account_number_transfers_$(Integer accountNum, double transferAmount) {
        System.out.println("this is When");
        System.out.println("this is account number: " + accountNum);
        System.out.println("this is transfer amount: " + transferAmount);

    }

    @Then("User with account number {int} should have ${double} in balance")
    public void user_with_account_number_should_have_$_in_balance(Integer accountNum, double balance) {
        System.out.println("this is Then");
        System.out.println("this is account number: " + accountNum);
        System.out.println("this is balance amount: " + balance);

    }

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
