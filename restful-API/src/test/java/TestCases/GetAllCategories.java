package TestCases;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GetAllCategories {

    private String categoriesResponse;
    @Test
    public void getAllCategories() {

        // Set the base URI for the API
        RestAssured.baseURI = "http://localhost:3030/categories";
        Response response = given()
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept","*/*")
                .header("Connection","keep-alive")
                .get();
        // Validate that status code 200
        response.then()
                .assertThat()
                .statusCode(200);
        //Get the repsonse and validate one record by name
        categoriesResponse = response.getBody().asString();

    }

    @Test(dependsOnMethods = "getAllCategories")
    public void savingTheResponse() {

        Reporter.log("Saved Categories Response:\n " + categoriesResponse,true);

    }


}
