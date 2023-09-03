package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import models.Order;


import java.util.List;
import java.util.Map;

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
        System.out.println(dataTable.cell(1, 1));
        System.out.println(dataTable.cell(3, 2));

    }

    @When("I transfer the following amounts between accounts:")
    public void i_transfer_the_following_amounts_between_accounts(DataTable dataTable) {
        System.out.println(dataTable.cell(2, 2));

    }

    @Then("the account balances should be updated as follows:")
    public void the_account_balances_should_be_updated_as_follows(DataTable dataTable) {

    }


    //    data table to list <Map>
    @Given("the following orders:")
    public void the_following_orders(List<Map<String, String>> orders) {
        System.out.println("product: " + orders.get(0).get("Product"));
        System.out.println("product: " + orders.get(2).get("Product"));
        System.out.println("Quantity: " + orders.get(1).get("Quantity"));

        for (Map<String, String> mapMap : orders) {
            System.out.println(mapMap.get("Order ID"));
            System.out.println(mapMap.get("Product"));
            System.out.println(mapMap.get("Quantity"));
        }

    }


    //data table to list of map
    @Given("the following orders exist in the db:")
    public void the_following_orders_exist_in_the_db(List<Order> orders) {
        for(Order order : orders){
            System.out.println(order.getOrderID());
            System.out.println(order.getProduct());
            System.out.println(order.getQuantity());
        }
    }

}
