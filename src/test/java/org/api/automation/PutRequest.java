package org.api.automation;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutRequest {

    @Test
    public void putTest(){

        baseURI = "https://reqres.in/api";

        JSONObject req = new JSONObject();
        req.put("name", "Vishnu");
        req.put("job", "Test Engineer");

        given().
              header("Content-type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(req.toJSONString()).
        when().
            put("/users/2").
        then().
        statusCode(200).
        body("name", equalTo("Vishnu")).
        log().all();
    }
}
