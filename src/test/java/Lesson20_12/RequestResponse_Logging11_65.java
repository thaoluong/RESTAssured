package Lesson20_12;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;
import org.testng.internal.ConfigurationGroupMethods;

import io.restassured.config.LogConfig;
import io.restassured.config.HeaderConfig;

import static io.restassured.RestAssured.config;

public class RequestResponse_Logging11_65 {
	
//	@Test
	public void Logging_Request_Response() {
		given().baseUri("https://api.postman.com").
			header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
//			log().all().
			log().uri().
		when().
			get("/workspaces").
		then().
			assertThat().statusCode(200).
//			log().all().
			log().body();
		
	}

	
//	@Test
	public void Logging_If_Error() {
		given().baseUri("https://api.postman.com").
			header("x-api-key", "1PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
		when().
			get("/workspaces").
		then().
			log().ifError().
			assertThat().statusCode(200);
	}

	
//	@Test
	public void Logging_only_if_validation_fail() {
		given().baseUri("https://api.postman.com").
			header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
			config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
//			log().ifValidationFails().
		when().
			get("/workspaces").
		then().
//			log().ifValidationFails().
			assertThat().statusCode(201);
	}



	@Test
	public void Logging_BackList_Header() {
		Set<String> headers = new HashSet<String>();
		headers.add("x-api-key");
		headers.add("accept");
		System.out.println("Header is: " +headers);
		
		given().
			baseUri("https://api.postman.com").
			header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
//			config(config.logConfig(LogConfig.logConfig().blacklistHeader("x-api-key"))).
			config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers))).

			log().all().
		when().
			get("/workspaces").
		then().
			assertThat().statusCode(200);
	}

}