package Lesson_18_12;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Lesson10_58_Extract_SingleField {
	
	
//	Single field extraction way 1
	@Test
	public void ExtractReponse1() {
		Response response = given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
			when().
				get("/workspaces").
			then().
				assertThat().statusCode(200).extract().response();
		System.out.println("workspaces name = " + response.path("workspaces[0].name"));
	}
	
	
//	Single field extraction way 2
	@Test
	public void ExtractReponse2() {
		Response response = given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
			when().
				get("/workspaces").
			then().
				assertThat().statusCode(200).extract().response();
		
//		System.out.println(response.asString());

		
		JsonPath jsonPath = new JsonPath(response.asString());
		System.out.println("workspaces name = " + jsonPath.getString("workspaces[0].name"));
	}
	
	
//	Single field extraction way 3
	@Test
	public void ExtractReponse3() {
		String response = given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
			when().
				get("/workspaces").
			then().
				assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		System.out.println("workspaces name = "+ JsonPath.from(response).getString("workspaces[0].name"));
	}
	
//	Single field extraction way 4
	@Test
	public void ExtractReponse4() {
		String name = given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-d9c0f61b2e81a33c9f9ebe43d48941a382").
			when().
				get("/workspaces").
			then().
				assertThat().statusCode(200).extract().response().path("workspaces[0].name");
		System.out.println("workspaces name = " + name);
	}
}
