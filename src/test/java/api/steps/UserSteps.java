package api.steps;

import api.domains.User;
import api.domains.UserProfile;
import api.domains.UserProfileModel;
import api.utils.ObjectMapperUtils;
import api.utils.RestHttpRequest;
import utils.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserSteps {
    public static int testUserId = 0;
    Response usersGetResponse;

    @Given("the user with email {string} and ssn {string} is not in the db")
    public void the_user_with_email_and_ssn_is_not_in_the_db(String email, String ssn) throws SQLException {
        DBUtils.deleteUser(email, ssn);
    }

    @Given("the following user is created in the db")
    public void the_following_user_is_created_in_the_db(List<UserProfileModel> userProfiles) throws JsonProcessingException, com.fasterxml.jackson.core.JsonProcessingException {
        String createBodyPayload = ObjectMapperUtils.objectMapper.writeValueAsString(userProfiles.get(0));
        System.out.println(createBodyPayload);

        Response createUserRequestResponse = RestHttpRequest.sendPostRequest("/user", createBodyPayload);
        User testUser = ObjectMapperUtils.objectMapper.readValue(createUserRequestResponse.asString(), User.class);
        System.out.println(testUser);
        testUserId = (int) testUser.getId();

    }

    @Given("the user is authenticated with ADMIN privileges")
    public void theUserIsAuthenticatedWithADMINPrivileges() {

    }
//
//    @When("the user sends GET request to {string}")
//    public void theUserSendsGETRequestTo(String endpoint, List<Map<String, String>> queryParams) {
//        if (endpoint.contains("{") && endpoint.contains("}")){
//            System.out.println("LOLOLOLOL");
//            usersGetResponse = RestHttpRequest.sendGetRequestWithPathParam(endpoint, queryParams.get(0).get("paramKey"), queryParams.get(0).get("paramValue"));
//        }else if(!queryParams.get(0).get("paramKey").equals("null") && !queryParams.get(0).get("paramValue").equals("null")){
//            System.out.println("HOHOHOH");
//            usersGetResponse = RestHttpRequest.sendGetRequestWithQueryParam(endpoint, queryParams.get(0).get("paramKey"), queryParams.get(0).get("paramValue"));
//        } else{
//            System.out.println("POPOPOPO");
//            usersGetResponse = RestHttpRequest.sendGetRequest(endpoint);
//        }
////        usersGetResponse = RestHttpRequest.sendGetRequest(endpoint);
//
//    }

//    private HttpRespons e usersGetResponse;

//    @When("the user sends GET request to {string}")
//    public void theUserSendsGETRequestTo(String endpoint, List<Map<String, String>> queryParams) {
//        if (queryParams != null && !queryParams.isEmpty()) {
//            String paramKey = queryParams.get(0).get("paramKey");
//            String paramValue = queryParams.get(0).get("paramValue");
//            if (paramKey != null && paramValue != null && !paramKey.equals("null") && !paramValue.equals("null")) {
//                // Send GET request with query parameters
//                usersGetResponse = RestHttpRequest.sendGetRequestWithQueryParam(endpoint, paramKey, paramValue);
//            } else {
//                // Send GET request without query parameters
//                usersGetResponse = RestHttpRequest.sendGetRequest(endpoint);
//            }
//        } else {
//            // Send GET request without query parameters
//            usersGetResponse = RestHttpRequest.sendGetRequest(endpoint);
//        }
//    }

//    @Then("the user gets {string} status code with the following response")
//    public void theUserGetsStatusCodeWithTheFollowingResponse(String statuscode, List<User> expectedUserResponse) throws com.fasterxml.jackson.core.JsonProcessingException {
//        usersGetResponse.prettyPrint();
//        usersGetResponse.then().assertThat().statusCode(Integer.parseInt(statuscode));
//
//
//        User actualUserResponse = ObjectMapperUtils.objectMapper.readValue(usersGetResponse.asString(), User.class);
//        for(int i = 0; i < expectedUserResponse.size(); i++){
//            assertEquals(expectedUserResponse.get(i).getId(), actualUserResponse.get(i).getId(), "User: ID mismatch");
//            assertEquals(expectedUserResponse.get(i).getUsername(), actualUserResponse.get(i).getUsername(), "User: Username mismatch");
//            assertEquals(expectedUserResponse.get(i).isEnabled(), actualUserResponse.get(i).isEnabled(), "User: Enabled mismatch");
//            assertEquals(expectedUserResponse.get(i).isAccountNonExpired(), actualUserResponse.get(i).isAccountNonExpired(), "User: Account Non Expired mismatch");
//            assertEquals(expectedUserResponse.get(i).isAccountNonLocked(), actualUserResponse.get(i).isAccountNonLocked(), "User: Account Non Locked mismatch");
//            assertEquals(expectedUserResponse.get(i).isCredentialsNonExpired(), actualUserResponse.get(i).isCredentialsNonExpired(), "User: Credentials Non Expired mismatch");
//
//            UserProfile expectedUserProfile = expectedUserResponse.get(i).getUserProfile();
//            UserProfile actualUserProfile = actualUserResponse.get(i).getUserProfile();
//            assertEquals(expectedUserProfile.getId(), actualUserProfile.getId(), "User Profile: ID mismatch");
//            assertEquals(expectedUserProfile.getTitle(), actualUserProfile.getTitle(), "User Profile: Title mismatch");
//            assertEquals(expectedUserProfile.getFirstName(), actualUserProfile.getFirstName(), "User Profile: First Name mismatch");
//            assertEquals(expectedUserProfile.getLastName(), actualUserProfile.getLastName(), "User Profile: Last Name mismatch");
//            assertEquals(expectedUserProfile.getGender(), actualUserProfile.getGender(), "User Profile: Gender mismatch");
//            assertEquals(expectedUserProfile.getDob(), actualUserProfile.getDob(), "User Profile: DOB mismatch");
//            assertEquals(expectedUserProfile.getDom(), actualUserProfile.getDom(), "User Profile: DOM mismatch");
//            assertEquals(expectedUserProfile.getSsn(), actualUserProfile.getSsn(), "User Profile: SSN mismatch");
//            assertEquals(expectedUserProfile.getEmailAddress(), actualUserProfile.getEmailAddress(), "User Profile: Email Address mismatch");
//            assertEquals(expectedUserProfile.getPassword(), actualUserProfile.getPassword(), "User Profile: Password mismatch");
//            assertEquals(expectedUserProfile.getAddress(), actualUserProfile.getAddress(), "User Profile: Address mismatch");
//            assertEquals(expectedUserProfile.getLocality(), actualUserProfile.getLocality(), "User Profile: Locality mismatch");
//            assertEquals(expectedUserProfile.getRegion(), actualUserProfile.getRegion(), "User Profile: Region mismatch");
//            assertEquals(expectedUserProfile.getPostalCode(), actualUserProfile.getPostalCode(), "User Profile: Postal Code mismatch");
//            assertEquals(expectedUserProfile.getCountry(), actualUserProfile.getCountry(), "User Profile: Country mismatch");
//            assertEquals(expectedUserProfile.getHomePhone(), actualUserProfile.getHomePhone(), "User Profile: Home Phone mismatch");
//            assertEquals(expectedUserProfile.getMobilePhone(), actualUserProfile.getMobilePhone(), "User Profile: Mobile Phone mismatch");
//            assertEquals(expectedUserProfile.getWorkPhone(), actualUserProfile.getWorkPhone(), "User Profile: Work Phone mismatch");
//    }
}



//    SELECT account.owner_id, users.id FROM account JOIN users ON  account.owner_id=users.id WHERE name = 'Elon Musk Second Checking' LIMIT 1
