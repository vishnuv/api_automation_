package org.api.automation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestDemo {
	
	@Test
	public void getDetails() {
		
		baseURI = "https://api.publicapis.org";
		
		given()
		.when()
			.get("/entries")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("count", equalTo(1427))
			.header("Content-Type", "application/json");
	}

}
