package org.api.automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestDemo {
	
	public static HashMap map = new HashMap();

	/*@BeforeClass
	public void postData() {
		
		map.put("Name", RestUtils.getName());
		map.put("Salary", RestUtils.getSalary());
		map.put("Age", RestUtils.getAge());
		
		RestAssured.baseURI= "https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath= "/create";
	}*/
	
	@Test
	public void testPost() {

		map.put("Name", RestUtils.getName());
		map.put("Salary", RestUtils.getSalary());
		map.put("Age", RestUtils.getAge());

		RestAssured.baseURI= "https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath= "/create";
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(200)
			.body("status", equalTo("success"))
			.body("message",equalTo("Successfully! Record has been added."));
		;
		
	}
}
