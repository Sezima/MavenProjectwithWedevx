package justForPractice.RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GORESTPOST_24_2_2 {

    public static void main(String[] args) {
        String BEARER_TOKEN = "90059568c399e86cb2112ab1c53253cd4f49ee00d83cd876b5d6a8ac7c86b8a0";

        // JSON body with name, email, gender, and status Data don't be repeated 
       String jsonRequestBody = "{"
                + "\"name\": \"Test User3\","
                + "\"email\": \"testuser3@gmail.examplecom\","
                + "\"gender\": \"male\","
                + "\"status\": \"active\""
                + "}";

        // Making a POST request with JSON body
        Response response = RestAssured
                .given()
                .baseUri("https://gorest.co.in/public/v2/")
                .header("Authorization", "Bearer " + BEARER_TOKEN)
                .contentType(ContentType.JSON) // Specify content type as JSON
                .body(jsonRequestBody) // Attach the JSON body
                .post("/users");

        // Now you can perform assertions on the response.
        response.then().statusCode(201);
        // Print the response body, as it contains the id of the newly registered user

//        System.out.println(response.getBody().asString());
        System.out.println("Response Body: " + response.getBody().asString());



    }
}
