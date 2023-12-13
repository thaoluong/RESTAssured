package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.*;


public class JSONSchemaValidator {
	
		@Test
		public void testGet() {
			
			baseURI = "https://reqres.in/api";
			
			given().
				get("/users?page=2").
			then().
				assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
				statusCode(200);
		}

}
