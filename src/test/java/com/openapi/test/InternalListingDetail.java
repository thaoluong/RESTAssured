package com.openapi.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.HashMap;
import java.util.Map;

public class InternalListingDetail {
	
	@Test
	public void validate_get_status_code() {
		
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
