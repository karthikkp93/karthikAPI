package practaceWithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProject {
	@Test
	public void update() {
		Random ran = new Random();
		int randomnumb=ran.nextInt(100);
		
		JSONObject jobj = new JSONObject();
		 jobj.put("createdby", "karthik");
		 jobj.put("projectname", "SDET 27"+randomnumb);
		 jobj.put("status", "On Going");
		 jobj.put("teamsize", 0);
		 
		 
		 given()
		 	.body(jobj)
		 	.contentType(ContentType.JSON)
		 .when()
		 	.get("http://localhost:8084/projects/TY_PROJ_001")
		 	
		 .then()
		 	.assertThat().contentType(ContentType.JSON)
		 	.statusCode(200)
		 	.log().all();
		 
	}

}
