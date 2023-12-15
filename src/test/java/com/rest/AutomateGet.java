package com.rest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.HashMap;
import java.util.Map;

public class AutomateGet {
	
	@Test
	public void validate_get_status_code() {
		
//		given().
//			baseUri("https://api.postman.com").
//			head("X-Api-Key", "PMAK-657c0f29b2c96200315e434d-8e168246cb439ef4d385f709e8438459fa").
//		when().
//			get("/workspaces").
//		then().
//			log().all().
//			assertThat().statusCode(200);
		
		given().
			baseUri("https://api.dataismist.com").
			header("x-api-key", "12345678").
		when().
			get("/listing-service/v1/property/internal/3738").
		then().
			log().all().
			assertThat().statusCode(200);
	}

}
