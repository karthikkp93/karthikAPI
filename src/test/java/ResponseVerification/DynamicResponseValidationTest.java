package ResponseVerification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DynamicResponseValidationTest {
	@Test
	public void dynvalidation() {
		String ExepprojectName="developer";
		Response response = when()
			.get("http://localhost:8084/projects");
		List<String> pronames = response.jsonPath().get("projectName");
		boolean flag=false;
          for(String pname:pronames)		
		
		response.then()
			.assertThat()
            .contentType(ContentType.JSON).and().statusCode(200)
            .log().all();
          Assert.assertEquals(flag, false);
		
		
		
		
		
		
		
		
		
	}

}
