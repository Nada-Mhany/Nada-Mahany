package TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class CheckTheTotalCategories {

    private String categories;
    @Test
    public void getCategoryTotal(){

        // Set the base URI for the API
        RestAssured.baseURI = "http://localhost:3030/categories";

        // Send a GET request with Rest-Assured
        Response response = given()
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept","*/*")
                .header("Connection","keep-alive").get();
        // Validate the response
        response.then()
                .statusCode(200);
        categories = response.getBody().asString();
        Reporter.log("The categories saved are "+categories,true);
        JsonPath jsonpath = response.jsonPath();
        Reporter.log("The total of categories are "+String.valueOf(jsonpath.getInt("total")),true);
        Assert.assertEquals(String.valueOf(jsonpath.getInt("total")),"4307");

    }
}
