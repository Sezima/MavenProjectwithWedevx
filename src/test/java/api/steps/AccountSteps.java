package api.steps;

import api.domains.*;
import api.utils.ObjectMapperUtils;
import api.utils.RestHttpRequest;
import io.cucumber.datatable.DataTable;
import utils.DBUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountSteps {
    public static int testUserId = 0;
    Response usersGetResponse;
    private AccountResponseModel accountResponseModel;
    private Response errorResponse;


    @Given("the user is authenticated with ADMIN privileges for account")
    public void the_user_is_authenticated_with_admin_privileges() {

    }
    @When("the user sends GET request to {string}")
    public void theUserSendsGETRequestTo(String endpoint, List<Map<String, String>> queryParams) {

        if (queryParams != null && !queryParams.isEmpty()) {
            String paramKey = queryParams.get(0).get("paramKey");
            System.out.println("paramkey: " + paramKey);
            String paramValue = queryParams.get(0).get("paramValue");
            System.out.println("paramValue: " +paramValue);
            if (paramKey != null && paramValue != null && !paramKey.equals("null") && !paramValue.equals("null")) {
                // Send GET request with query parameters
//                usersGetResponse = RestHttpRequest.sendGetRequestWithQueryParam(endpoint, paramKey, paramValue);
                usersGetResponse = RestHttpRequest.sendGetRequestWithPathParam(endpoint, paramKey, paramValue);
            } else {
                // Send GET request without query parameters
                usersGetResponse = RestHttpRequest.sendGetRequest(endpoint);
            }
        } else {
            // Send GET request without query parameters
            usersGetResponse = RestHttpRequest.sendGetRequest(endpoint);
        }
    }





    @Then("the user gets {string} status code with the following response")
    public void the_user_gets_status_code_with_the_following_response(String string, io.cucumber.datatable.DataTable dataTable) {

    }


    @When("the following banking account is created")
    public void the_following_banking_account_is_created(List<AccountModel> accounts) throws JsonProcessingException {
        AccountModel account = accounts.get(0);
        System.out.println(account);

        String accountBodyPayload = ObjectMapperUtils.objectMapper.writeValueAsString(account);

        Response createAccountResponse = RestHttpRequest.sendPostRequestWithPathParam("user/{id}/account", "id", String.valueOf(api.steps.UserSteps.testUserId), accountBodyPayload);
        createAccountResponse.prettyPrint();
        createAccountResponse.then()
                .assertThat().statusCode(200);

        accountResponseModel = ObjectMapperUtils.objectMapper.readValue(createAccountResponse.asString(), AccountResponseModel.class);
    }

    @Then("the following account details are returned in the response")
    public void the_following_account_details_are_returned_in_the_response(List<AccountModel> accounts) {
        AccountModel account = accounts.get(0);
        assertEquals(account.getAccountName(), accountResponseModel.getName(), "Account Name mismatch");
        assertEquals(account.getAccountTypeCode(), accountResponseModel.getAccountType().getCode(), "Account Type Code mismatch");
        assertEquals(account.getOpeningDeposit(), accountResponseModel.getOpeningBalance(), "Account Opening Balance mismatch");
        assertEquals(account.getOwnerTypeCode(), accountResponseModel.getOwnershipType().getCode(), "Account Ownership Type Code mismatch");
        assertEquals(account.getAccountStandingName(), accountResponseModel.getAccountStanding().getName(), "Account Standing Name mismatch");

        if(account.getAccountTypeCode().equals("SCK")){
            AccountTypeModel expectedAccountModel = AccountTypeModel.createDefaultSCKAccountTypeModel();
//            assertEquals(expectedAccountModel.getId(), accountResponseModel.getId(), "SCK: Account ID mismatch");
            assertEquals(expectedAccountModel.getCode(), accountResponseModel.getAccountType().getCode(), "SCK: Account Type Code mismatch");
            assertEquals(expectedAccountModel.getCategory(), accountResponseModel.getAccountType().getCategory(), "SCK: Account Type Category mismatch");
            assertEquals(expectedAccountModel.getName(), accountResponseModel.getAccountType().getName(), "SCK: Account Name mismatch");
            assertEquals(expectedAccountModel.getInterestRate(), accountResponseModel.getInterestRate(), "SCK: Account Interest Rate mismatch");
            assertEquals(expectedAccountModel.getMinDeposit(), accountResponseModel.getAccountType().getMinDeposit(), "SCK: Account Min Deposit mismatch");
            assertEquals(expectedAccountModel.getOverdraftFee(), accountResponseModel.getAccountType().getOverdraftFee(), "SCK: Account Overdraft Fee mismatch");
            assertEquals(expectedAccountModel.getOverdraftLimit(), accountResponseModel.getAccountType().getOverdraftLimit(), "SCK: Account Overdraft Limit mismatch");

        }
    }

    @Then("the following account details are saved in the db")
    public void the_following_account_details_are_saved_in_the_db() {
        String accountQuery = String.format("SELECT * FROM account WHERE id=%d", accountResponseModel.getId());
        Map<String, Object>  accountDBResponse = DBUtils.runSQLSelectQuery(accountQuery).get(0);
        String currentBalance = String.format("%.2f", accountResponseModel.getCurrentBalance());
        String openingBalance = String.format("%.2f", accountResponseModel.getOpeningBalance());

        String expectedDateOpened = RestHttpRequest.formatJsonDate(accountResponseModel.getDateOpened());
        String expectedDateClosed = RestHttpRequest.formatJsonDate(accountResponseModel.getDateClosed());
        String actualDateOpened = DBUtils.formatSqlDate(accountDBResponse.get("date_opened"));
        String actualDateClosed = DBUtils.formatSqlDate(accountDBResponse.get("date_closed"));


        assertEquals(accountResponseModel.getId(), Integer.parseInt(accountDBResponse.get("id").toString()), "DB: Account ID mismatch");
        assertEquals(currentBalance, accountDBResponse.get("current_balance").toString(), "DB: Account Current Balance mismatch");
        assertEquals(openingBalance, accountDBResponse.get("opening_balance").toString(), "DB: Account Opening Balance mismatch");
        assertEquals(accountResponseModel.getInterestRate(), accountDBResponse.get("interest_rate"), "DB: Account Interest Rate mismatch");
        assertEquals(accountResponseModel.getPaymentAmount(), accountDBResponse.get("payment_amount"), "DB: Account Payment Amount mismatch");
        assertEquals(accountResponseModel.getPaymentTerm(), accountDBResponse.get("payment_term"), "DB: Account Payment Term mismatch");
        assertEquals(accountResponseModel.getAccountNumber()+"", accountDBResponse.get("account_number").toString(), "DB: Account Number mismatch");
        assertEquals(accountResponseModel.getName(), accountDBResponse.get("name"), "DB: Account Name mismatch");
        assertEquals(expectedDateOpened, actualDateOpened, "DB: Account Date Opened mismatch");
        assertEquals(expectedDateClosed, actualDateClosed, "DB: Account Date Closed mismatch");
        assertEquals(accountResponseModel.getPaymentDue(), accountDBResponse.get("payment_due"), "DB: Account Payment Due mismatch");
        assertEquals(accountResponseModel.getOwnershipType().getId()+"", accountDBResponse.get("ownership_type_id").toString(), "DB: Account Ownership Type ID mismatch");
        assertEquals(accountResponseModel.getAccountType().getId()+"", accountDBResponse.get("account_type_id").toString(), "DB: Account Type ID mismatch");
        assertEquals(accountResponseModel.getAccountStanding().getId()+"", accountDBResponse.get("account_standing_id").toString(), "DB: Account Standing ID mismatch");


    }

    @When("attempting to create an account with the following data")
    public void attempting_to_create_an_account_with_the_following_data(List<AccountModel> accounts) throws JsonProcessingException {
        AccountModel account = accounts.get(0);
        String accountBodyPayload = ObjectMapperUtils.objectMapper.writeValueAsString(account);

        System.out.println(accountBodyPayload);
        errorResponse = RestHttpRequest.sendPostRequestWithPathParam("user/{id}/account", "id", String.valueOf(UserSteps.testUserId), accountBodyPayload);
    }
    @Then("{string} status code is received with the following response")
    public void status_code_is_received_with_the_following_response(String code, List<Map<String, String>> error) {
        int statusCode = Integer.parseInt(code);
        errorResponse
                .then()
                .assertThat()
                .statusCode(statusCode);

        String errorMessage = errorResponse.asString();
        boolean actualResult;
        if(error.get(0).get("type").equals("noName")){
            actualResult = errorMessage.contains(error.get(0).get("error").substring(error.get(0).get("error").indexOf("\""), error.get(0).get("error").indexOf(","))) &&
                    errorMessage.contains(error.get(0).get("error").substring(error.get(0).get("error").indexOf(",")+1));
        } else if(error.get(0).get("type").equals("boundary")){
            errorMessage = errorMessage.substring(errorMessage.indexOf("[")+1, errorMessage.indexOf("]"));
            actualResult = errorMessage.equals(error.get(0).get("error"));
        } else {
            errorMessage = errorMessage.substring(errorMessage.indexOf("[")+1, errorMessage.indexOf("]"));
            actualResult = errorMessage.equals(error.get(0).get("error")) ;
        }
        System.out.println(errorMessage + " | " + error.get(0).get("error"));
        assertTrue(actualResult);
    }
    @Then("the following account details are not saved in the db")
    public void the_following_account_details_are_not_saved_in_the_db() {
       List<Map<String, Object>> resultSet = DBUtils.runSQLSelectQuery("SELECT * FROM account where name = ''");
       assertEquals(0, resultSet.size());
    }


    @When("attempting to create an account with a wrong user id and the following data")
    public void attempting_to_create_an_account_with_a_wrong_user_id_and_the_following_data(List<AccountModel> accounts) throws JsonProcessingException {
        AccountModel account = accounts.get(0);
        System.out.println(account);

        String accountBodyPayload = ObjectMapperUtils.objectMapper.writeValueAsString(account);

        errorResponse = RestHttpRequest.sendPostRequestWithPathParam("user/{id}/account", "id", String.valueOf(1000), accountBodyPayload);
        errorResponse.prettyPrint();
        errorResponse.then()
                .assertThat().statusCode(404);
    }
    @Then("{string} status code is received with the following response details")
    public void status_code_is_received_with_the_following_response_details(String string, List<ErrorResponse> errorResponses) throws JsonProcessingException {
        ErrorResponse errorResponseMap = errorResponses.get(0);
        ErrorResponse actualErrorResponse = ObjectMapperUtils.objectMapper.readValue(errorResponse.asString(), ErrorResponse.class);

        System.out.println(errorResponseMap.getTimestamp() +  "  ||  " + actualErrorResponse.getTimestamp());
//        assertEquals(errorResponseMap.getTimestamp(), actualErrorResponse.getTimestamp(), "Timestamp mismatch");
        assertEquals(errorResponseMap.getStatus(), actualErrorResponse.getStatus(), "Status Code mismatch");
        assertEquals(errorResponseMap.getError(), actualErrorResponse.getError(), "Error mismatch");
        assertEquals(errorResponseMap.getMessage(), actualErrorResponse.getMessage(), "Message mismatch");
        assertEquals(errorResponseMap.getPath(), actualErrorResponse.getPath(), "Path mismatch");

    }


    @Given("blank")
    public void blank() {
    }
}
