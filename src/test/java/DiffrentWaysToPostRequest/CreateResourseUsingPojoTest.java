
package DiffrentWaysToPostRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

public class CreateResourseUsingPojoTest {
	@Test
	public void create() {
	Object pojo =new PojoClass("karthik","tyss banglore","completed",200);
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addproject")
	.then()
		.assertThat().statusCode(404)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
