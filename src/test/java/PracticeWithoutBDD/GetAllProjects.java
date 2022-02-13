package PracticeWithoutBDD;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
@Test
	public  void getallproject() {
	
	
		// step 1
	int expstu = 200;
	Response resp = RestAssured.get("http://localhost:8084/projects");
	
	//srep 2
	System.out.println(resp.prettyPrint());
int actstu = resp.getStatusCode();	
Assert.assertEquals(expstu,actstu );
	}

}
