package PracticeWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateproject() 
	{
			
			//step 1 create test data
			 JSONObject jobj = new JSONObject();
			 jobj.put("createdby", "karthik");
			 jobj.put("projectname", "tyss");
			 jobj.put("status", "on going");
			 jobj.put("teamsize", 12);
			 
			 //
			RequestSpecification req = RestAssured.given();
			req.contentType(ContentType.JSON);
			req.body(jobj);
			
			
			//
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_003");
		//
		
		ValidatableResponse vresp = resp.then();
		vresp.assertThat().statusCode(200);
		vresp.log().all();
		
		
		
		
		
			
			
			
			 
	}

}
