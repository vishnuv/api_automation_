package org.api.automation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidator {

    @Test
    public void getTest() {

        baseURI= "https://reqres.in/api";

        given().
                when().
                get("/users?page=2").
                then().
                statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
        ;

    }
}
