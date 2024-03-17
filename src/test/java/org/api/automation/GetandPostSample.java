package org.api.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetandPostSample {
	
	@Test
	public void getTest() {
		
		baseURI= "https://reqres.in/api";
		
		given().
		when().
			get("/users?page=2").
		then().
			statusCode(200)
			.body("data[4].id", equalTo(11))
		;
		
	}
	
	@Test
	public void postTest() {
		
		baseURI = "https://reqres.in/api/users";
		
		JSONObject postRequest = new JSONObject();
		postRequest.put("name", "morpheus");
		postRequest.put( "job", "leader");
		
		given().
			body(postRequest.toJSONString()).
		when().
			post().
		then().
			statusCode(201).
			log().all();
	}

}
