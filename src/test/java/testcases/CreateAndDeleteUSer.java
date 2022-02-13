package testcases;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateAndDeleteUSer {
	@Test
	public void createanddeluser() {
		Random ran = new Random();
	    int randomNumber = ran.nextInt(500);

	  JSONObject jobj = new JSONObject();
	  jobj.put("createdBy", "alexa");
	  jobj.put("projectName","tata"+randomNumber);
	  jobj.put("status","created");
	  jobj.put("teamSize",100);
	  
	  given()
	  			.body(jobj)
	  			.contentType(ContentType.JSON)
	  .when()
	  			.post("http://localhost:8084/addProject")
	  .then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	  
	  String proId = "TY_PROJ_1204";
	 	given()
	 			.pathParam("projectId", proId)
	 	.when()
	 			.delete("http://localhost:8084/projects/{projectId}")
	 	.then()
	 			.contentType(ContentType.JSON)
	 			.statusCode(204)
	 			.log().all(); 
		
	}

}
