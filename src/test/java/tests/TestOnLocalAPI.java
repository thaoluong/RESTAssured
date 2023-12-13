package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {
	
	
	
	@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		given().get("/user").then().statusCode(200).log().all();
		
	}
	
//	@Test
	public void post() {

		JSONObject request = new JSONObject();
		request.put("first_name", "Jenny");
		request.put("last_name", "Luong");
		request.put("subjectId", 1);

		baseURI = "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/user").
			
		then().
			statusCode(201);	
		
	}
	
//	@Test
	public void put() {

		JSONObject request = new JSONObject();
		request.put("first_name", "Jenny update");
		request.put("last_name", "Luong update");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/user/4").
			
		then().
			statusCode(200);	
		
	}
	
//	@Test
	public void patch() {

		JSONObject request = new JSONObject();
		request.put("last_name", "Luong Hong");


		baseURI = "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/user/4").
			
		then().
			statusCode(200);	
		
	}
	
	@Test
	public void delete() {
		baseURI = "http://localhost:3000";
		when().
			delete("/user/4").
		then().
			statusCode(200);
	}

}
