package practaceWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateResourse {
	
	@Test
	public void createresourse() {
		Random ran = new Random();
		int randomnumb=ran.nextInt(100);
		
		JSONObject jobj = new JSONObject();
		 jobj.put("createdby", "prakash");
		 jobj.put("projectname", "tyss"+randomnumb);
		 jobj.put("status", "completed");
		 jobj.put("teamsize", 123);
		 
		 
		 given()
		 	.body(jobj)
		 	.contentType(ContentType.JSON)
		 	
		 	.when()
		 	.post("http:/localhost:8084/addproject")
		 	
		 	.then()
		 	.assertThat().statusCode(200)
		 	.contentType(ContentType.JSON)
		 	.log().all();
		 	
		 	
		 	
		 
		 
		 
		 
		 
	}

}
