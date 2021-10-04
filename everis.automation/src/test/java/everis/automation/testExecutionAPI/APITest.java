package everis.automation.testExecutionAPI;

import static io.restassured.RestAssured.*;

import static  org.hamcrest.Matchers.*;
import org.junit.Test;


public class APITest {
	
	@Test
	public void validarURLAPI() {
		given()
		.when()
			.get("https://httpbin.org/get")
		.then()
			.statusCode(200)
			.body("url", is("https://httpbin.org/get"));
	}
	
}
