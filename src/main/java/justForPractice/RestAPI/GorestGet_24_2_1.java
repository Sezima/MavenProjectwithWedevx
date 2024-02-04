package justForPractice.RestAPI;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.apache.hc.core5.http.HttpResponse;

public class GorestGet_24_2_1 {
    public static void main(String[] args) {
        String BEARER_TOKEN = "90059568c399e86cb2112ab1c53253cd4f49ee00d83cd876b5d6a8ac7c86b8a0";

        Response response = RestAssured
                .given()
                .baseUri("https://gorest.co.in/public/v2")
                .header("Authorization", "Bearer " + BEARER_TOKEN)
                .when()
                .get("/users")
                .then()
                .extract()
                .response();


        System.out.println(response.getBody().asString());


    }


}
