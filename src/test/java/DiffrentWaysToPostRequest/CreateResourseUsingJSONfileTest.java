package DiffrentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateResourseUsingJSONfileTest {
@Test
	public void create() {
	File file = new File("./testData.json");
	
	given()
		.body(file)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addproject")
	.then()
		.assertThat().statusCode(404)
		.contentType(ContentType.JSON)
		.log().all();
	
		
		
		
	}
}
