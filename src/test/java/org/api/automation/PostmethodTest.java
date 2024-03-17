package org.api.automation;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmethodTest {

	public static HashMap map = new HashMap();
	public static JSONObject request = new JSONObject();

	@BeforeClass
	public void postData() {
		
		map.put("name", "morpheus");
		map.put("job", "leader");
		
		RestAssured.baseURI= "https://reqres.in";
		RestAssured.basePath= "/api/users";
	}
	
	@Test
	public void testPost() {
		
		
		request.put("name", "morpheus");
		request.put("job", "leader");
		
		given()
			.contentType("application/json")
			.body(request.toJSONString())
		.when()
			.post()
		.then()
			.statusCode(201)
			.body("name", equalTo("morpheus"))
			.and()
			.body("job",equalTo("leader"));
		
	}
	
}
