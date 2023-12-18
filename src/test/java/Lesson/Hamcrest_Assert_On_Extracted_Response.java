package Lesson;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hamcrest_Assert_On_Extracted_Response {
	
	@Test
	public void ExtractReponse4() {
		String name = given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
			when().
				get("/workspaces").
			then().
				assertThat().statusCode(200).extract().response().path("workspaces[0].name");
		System.out.println("workspaces name = " + name);
		
		//Assert expectation with Hamcrest Matchers
		assertThat(name, equalTo("My Workspace"));
		
		//Assert expectation with TestNG
//		Assert.assertEquals(name, "My Workspace");
	}

}
