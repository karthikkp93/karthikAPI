package practaceWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteResouece {
	@Test
	public void delete() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_402")
		
			.then()
			.assertThat().statusCode(204)
			.log().all();
		

			
	}

}
