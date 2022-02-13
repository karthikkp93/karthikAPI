package ResponseVerification;

import static  io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class VerifyResponseTimeUsingHamcrestTest {

	@Test
	public void verify() {
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
			.log().all();
					
					
					
					
					
					
		
	}
}
