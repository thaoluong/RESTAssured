package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.HashMap;

public class GetAndPostExample {


	
	@Test
	public void testPost() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Jenny2k1");
//		map.put("job","QC");
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Jenny");
		request.put("job", "QC");

		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();

	}
	
	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data.first_name", hasItems("Jenny")).
			body("data.job", hasItems("QC")).
			log().all();
		
	}

}
