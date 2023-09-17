package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Claim;

import java.util.List;

public class ScenarioOutlineSteps {


    @Given("some precondition")
    public void some_precondition() {
        System.out.println("some precondition step");
    }
    @When("some action is performed with {string}")
    public void some_action_is_performed_with(String string) {
        System.out.println("when step " + string);
    }
    @Then("some expected outcome is achieved with {string}")
    public void some_expected_outcome_is_achieved_with(String string) {
        System.out.println("then step " + string);
    }




    @Given("the customer has {string} coverage")
    public void the_customer_has_coverage(String string) {
        System.out.println("Coverage " + string);
    }

    @Given("the customer has a claim with the following details:")
    public void the_customer_has_a_claim_with_the_following_details(List<Claim> claims) {
        for(Claim claim : claims){
            System.out.println("Claim Id: " + claim.getClaimId());
            System.out.println("Amount: " + claim.getAmount());
            System.out.println("Date: " + claim.getDate());
            System.out.println("Description: " + claim.getDescription());
            System.out.println("Supporting Documents: " + claim.getSupportingDocuments());
        }
    }

    @When("the customer submits the claim")
    public void the_customer_submits_the_claim() {
        System.out.println("Submit");
    }

    @Then("the claim should be processed successfully")
    public void the_claim_should_be_processed_successfully() {
        System.out.println("Validate");
    }
}
