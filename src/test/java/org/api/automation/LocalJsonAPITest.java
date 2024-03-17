package org.api.automation;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LocalJsonAPITest {

    @Test
    public void localApiTest(){

        baseURI = "http://localhost:3000";

        given().
                header("Content-type","application/json").
                contentType(ContentType.JSON).
        when().
                get("/users").
        then()
                .statusCode(200).log().all();


    }
}
