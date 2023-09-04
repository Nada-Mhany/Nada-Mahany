package TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CheckGetCategoryByName {
    private String categoriesResponse;
    @Test
    public void getCategoryName(){

        // Set the base URI for the API
        RestAssured.baseURI = "http://localhost:3030/categories";

        Response response = given()
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept","*/*")
                .header("Connection","keep-alive")
                .param("name[$like]","*Gift*").get();

        response.then()
                .statusCode(200); // Validate the expected response status code
        categoriesResponse = response.getBody().asString();
        Reporter.log(categoriesResponse,true);
        //Save the response json in string
        JsonPath jsonpath = response.jsonPath();
        //Get the first name in the data
        String firstCategoryFromTheResponse = jsonpath.get("data[0].subCategories[0].name");
        Reporter.log("The first sub category that contains gift is "+firstCategoryFromTheResponse,true);
        //Validate the name contains gifts
        Assert.assertEquals(firstCategoryFromTheResponse.contains("Gifts"),true);

    }
}
