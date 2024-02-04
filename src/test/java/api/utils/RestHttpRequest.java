package api.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static  utils.ConfigReader.getPropertiesValue;
import static io.restassured.RestAssured.given;

public class RestHttpRequest {
    public static RequestSpecification requestSpecification = RestAssured.given();
    private static String authToken;

    // Static Initializer - no need to call, it already executed
    // once for the entire project
    static {
        requestSpecification.baseUri(getPropertiesValue("digitalbank.api.baseuri"));
        authToken = generateAuthToken();
        addHeaders();
    }

    public static String generateAuthToken(){
        Response authTokenResponse = requestSpecification
                .queryParam("username", getPropertiesValue("digitalbank.admin.username"))
                .queryParam("password", getPropertiesValue("digitalbank.admin.password"))
                .when()
                .post("/auth");
        JsonPath authResponseJsonPath = authTokenResponse.jsonPath();
        String authToken = authResponseJsonPath.getString("authToken");
        return authToken;
    }

    public static void addHeaders(){
        requestSpecification
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken);
    }

    public static String getAuthToken() {
        return authToken;
    }

    public static Response sendPostRequestWithPathParam(String endPoint, String pathParamKey, String pathParamValue, String body){
        Response response = requestSpecification
                .pathParam(pathParamKey, pathParamValue)
                .body(body)
                .when()
                .post(endPoint);
        return response;
    }
    public static Response sendPostRequest(String endPoint, String body){
        Response response = requestSpecification
                .body(body)
                .when()
                .post(endPoint);
        response.prettyPrint();
        return response;
    }

    public static String formatJsonDate(String jsonDate) {
        if(jsonDate == null){
            return null;
        }
        // Parse JSON date and format it to the desired format
        LocalDateTime dateTime = LocalDateTime.parse(jsonDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    }

    public static Response sendGetRequest(String endpoint){
        return requestSpecification
                .when()
                .get(endpoint);
    }
    public static Response sendGetRequestWithQueryParam(String endpoint, String pathParamKey, String pathParamValue){
        Response result = requestSpecification
                .queryParam(pathParamKey, pathParamValue)
                .when()
                .get(endpoint);
        result.prettyPrint();
        return result;
    }
    public static Response sendGetRequestWithPathParam(String endpoint, String pathParamKey, String pathParamValue){
        return requestSpecification
                .pathParam(pathParamKey, pathParamValue)
                .when()
                .get(endpoint);
    }

    public static int changeUserPassword(String currentPassword, String newPassword){
        String jsonPayload = String.format("{\n" +
                "  \"currentPasword\": \"%s\",\n" +
                "  \"newPassword\": \"%s\"\n" +
                "}", currentPassword, newPassword);
        Response changePasswordResponse = requestSpecification
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put("/api/v1/user/password");
        return changePasswordResponse.getStatusCode();
    }
}
