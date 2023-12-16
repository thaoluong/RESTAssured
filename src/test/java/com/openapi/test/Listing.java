package com.openapi.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Listing {
	
	
	@Test
	public void getAllListing() {
		
		Authorization.getAccessToken();
		System.out.print(Authorization.accessToken);	
				
		given().
			baseUri("https://openapi.dataismist.com").
			header("Authorization", "Bearer " + Authorization.accessToken).
			
		when().
			get("/v1/listings").
		then().
			statusCode(200).
			log().all();	
		
	}

}
