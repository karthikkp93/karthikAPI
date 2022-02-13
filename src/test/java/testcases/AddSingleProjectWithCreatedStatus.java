package testcases;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class AddSingleProjectWithCreatedStatus {

	
	@Test
	public void createproject() {
		//Step 1:  create data
		JSONObject jobj =new JSONObject();//json simple dependency
		jobj.put("createdBy","kannaha");
		jobj.put("createdOn", "11/02/2022");
		
		
		//jobj.put("projectId", "string");
		jobj.put("projectName", "testyantra");
		jobj.put("status", "Created");
		jobj.put("teamSize", 100);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(409).time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON)
		.log().all();
		
	}
}