package com.requsetchaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChainingTest {
	
	
	@Test
	public void request() {
		Response response = when()
			.get("http://localhost:8084/projects");
		
		String proID= response.jsonPath().getString("[0].projectId");
		
		
		
		given()
			.pathParam("projectId", proID)
		.when()
			.delete("http://localhost:8084/dashboard/projects/{projectId}")
		.then()
			.log().all();
		
		
	}
	
	

}
