package TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CheckGetCategoryById {
    private String categoriesResponse;
    @Test
    public void getCategoryID() {

        // Set the base URI for the API
        RestAssured.baseURI = "http://localhost:3030/categories";
        Response response = given()
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept","*/*")
                .header("Connection","keep-alive")
                .param("id","abcat0010000")
                .get();
        // Validate that status code 200
        response.then()
                .assertThat()
                .statusCode(200);
        //Get the repsonse and validate one record by name
        categoriesResponse = response.getBody().asString();
        JsonPath jsonpath = response.jsonPath();
        System.out.println(categoriesResponse);
        String firstObject = jsonpath.get("data.find{ it.id == 'abcat0010000' }.name");
        Assert.assertEquals(firstObject,"Gift Ideas","The first item is not as found in the response body");
        Reporter.log("The first category name is "+firstObject,true);

    }
}
