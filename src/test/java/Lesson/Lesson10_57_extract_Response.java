package Lesson;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Lesson10_57_extract_Response {

	@Test
	public void ExtractReposnse() {
		Response response = given()
			.baseUri("https://api.postman.com")
			.header("x-api-key", "PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
		when()
			.get("/workspaces").
		then()	
			.assertThat().
				statusCode(200).extract().response();
		
		System.out.println("Response = " + response.asString());
	}

}
