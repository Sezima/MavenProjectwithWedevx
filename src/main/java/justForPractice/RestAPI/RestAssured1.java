package justForPractice.RestAPI;

import io.restassured.RestAssured;

public class RestAssured1 {
    public static void main(String[] args) {
        // all methods in RestAssured are static method


        //given - is used for pre condition
        //auth / headers like content type / accept / query param / request param / uri


        /** when - crud method / then for validating**/

        /**all method are chained in restAssured
         * baseUri -> is a method that is used for specifying the base URI
         * //sezim.mywedevx.co/bank/api/v1**/

        RestAssured
                .given()
                .baseUri("https://dummy.restapiexample.com")
                .when()
                .get("/employee")
                .then().statusCode(200);
        //when we use 201 it should be a get error

        System.out.println("successfully sent a request");

    }
}
