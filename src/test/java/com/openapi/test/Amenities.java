package com.openapi.test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class Amenities {
	
//	Authorization author = new Authorization();
	
	@Test
	public void getAmenites() {
		Authorization.getAccessToken();
		System.out.print(Authorization.accessToken);	
				
		given().
			baseUri("https://openapi.dataismist.com").
			header("Authorization", "Bearer " + Authorization.accessToken).
			
		when().
			get("/v1/listings/amenities").
		then().
			statusCode(200).
			log().all();	
		
	}

}
