package ResponseVerification;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticResponseValidationTest {
	@Test
	public void validation() {
		String ExepprojectName="key986";
		Response response = when()
			.get("http://localhost:8084/projects");
			String ActualProjectName=response.jsonPath().get("[0].projectName");
		
		response.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();

		Assert.assertEquals(ExepprojectName, ActualProjectName);
	}
	
	
	
	

}
