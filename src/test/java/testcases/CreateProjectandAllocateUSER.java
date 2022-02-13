package testcases;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectandAllocateUSER {
	
	@Test
	public void createprojandallocateuser() {
		Random ran = new Random();
	     int randomNumber = ran.nextInt(200);
	    
	     JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "adam");
			jobj.put("projectName","testyantra2"+ randomNumber);
			jobj.put("status","on going");
			jobj.put("teamSize",400);
			
			given()
					.body(jobj)
					.contentType(ContentType.JSON)
					
			.when()
			 		.post("http://localhost:8084/addProject")
			.then()
					.assertThat().statusCode(201)
					.contentType(ContentType.JSON)
					.log().all();
			
			String expectedprojectId = "TY_PROJ_1202";
			Response response = when()
			   .get("http://localhost:8084/projects");
			List<String> projectId = response.jsonPath().get("projectId");
			boolean flag = false;
			for(String pname:projectId) {
				try {
					if (pname.equals(expectedprojectId)) {
						flag=true;
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			response.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();
			Assert.assertEquals(flag, true);
		
		
		
		
		
		
	}

}
