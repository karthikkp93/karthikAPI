package com.authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2Test {
	@Test
	public void auth() {
		Response response = given()
		.formParams("client_id", "SDET_27 karthik")
		.formParams("client_secret", "c02558db1451ecc47eab79e53f277cd4")
		.formParams("grant_type", "client_credentials")
		.formParams("redirect_uri", "https://example.com")
		
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
	String token = response.jsonPath().get("access_token");
	
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID", 2781)
.when()
	.get("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")

.then()
.log().all();

		
			
		
	}

}
