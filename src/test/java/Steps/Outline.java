package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Outline {

    @Given("some precondition")
    public void some_precondition() {
        System.out.println("given pre-condition step");
    }
    @When("some action is performed with {string}")
    public void some_action_is_performed_with(String string) {
        System.out.println("when step: " + string);
    }
    @Then("some expected outcome is achieved with {string}")
    public void some_expected_outcome_is_achieved_with(String string) {
        System.out.println("then step: " + string);
    }

}
