package PracticeWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createproj() {
		
		//step 1 create test data
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdby", "karthik");
		 jobj.put("projectname", "tyss");
		 jobj.put("status", "completed");
		 jobj.put("teamsize", 12);
		 
		 //provide reqquest specification
		 RequestSpecification req = RestAssured.given();
		 req.contentType(ContentType.JSON);
		 req.body(jobj);
		 
		 //perform the action
		Response resp = req.post("http://localhost:8084/addproject");
		 
		 //print console and verify
		 
		 System.out.println(resp.asString());
		 System.out.println(resp.prettyPrint());
		 System.out.println(resp.getStatusCode());
		 System.out.println(resp.prettyPeek());
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
