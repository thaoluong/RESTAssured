package Lesson;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;





public class Lesson10_55_56_Assert_StatusCode_ResponseBody {
	
	@Test
	public void Validate_Status_Code() {
		given().
			baseUri("https://api.postman.com").
			header("x-api-key","PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
		when().
			get("/workspaces").
		then().	
			assertThat().statusCode(200).log().all();		
	}
	
	@Test
	public void Validate_Response_Body() {
		
		given().
		baseUri("https://api.postman.com").
		header("x-api-key","PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
	when().
		get("/workspaces").
	then().	
		assertThat().statusCode(200).
		body("workspaces.name", hasItems("My Workspace","Automate API","Dtravel"),
				"workspaces.type", hasItems("personal","team","team"),
				"workspaces[0].name", equalTo("My Workspace"),
				"workspaces[0].name", is(equalTo("My Workspace")),
				"workspaces.size()", equalTo(3),
				"workspaces.name", hasItem("Automate API"));
	
		
	}

}
