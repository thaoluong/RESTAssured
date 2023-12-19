package Lesson_19_12;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.Map;


import org.testng.annotations.Test;

public class Hamcrest_Part1 {
	
	
	@Test
	public void Hamcrest_Assert() {
		String name = given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
			when().
				get("/workspaces").
			then().
				assertThat().statusCode(200).extract().response().path("workspaces[0].name");
		System.out.println("workspaces name = " + name);
		
//		Assert expectation with Hamcrest Matchers
		assertThat(name, equalTo("My Workspace"));
		
//		Assert expectation with TestNG
//		Assert.assertEquals(name, "My Workspace");
	}
	
	
	//hamcrest.Matcher.contains method: Check all values of element in correct order
	@Test
	public void Hamcrest_Contains_Method() {
			given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
			when().
				get("/workspaces").
			then().
				assertThat().
				statusCode(200).
				body("workspaces.name", contains("My Workspace", "Automate API", "Dtravel"));
			
	}
	
	//hamcrest.Matcher.containsInAnyOrder method: Check all values of element in any order
	@Test
	public void Hamcrest_ContainInAnyOrder() {
			given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
			when().
				get("/workspaces").
			then().
				assertThat().
				statusCode(200).
				body("workspaces.name", containsInAnyOrder("Automate API", "My Workspace", "Dtravel"));
			
	}
	
//		hamcrest.Matcher.empty method: Check value of element is empty
//		@Test
		public void Hamcrest_Empty() {
				given().baseUri("https://api.postman.com").
					header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
				when().
					get("/workspaces").
				then().
					assertThat().
					statusCode(200).
					body("workspaces.name", empty()); /* Way2: is(empty()) */
		}
			
		//hamcrest.Matcher.empty method: Check value of element is empty
		@Test
		public void Hamcrest_IsNotEmpty() {
				given().baseUri("https://api.postman.com").
					header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
				when().
					get("/workspaces").
				then().
					assertThat().
					statusCode(200).
//					body("workspaces.name", not(empty())); /* Way1 */
					body("workspaces.name", is(not(empty())));  /* Way2 */

		}
		
		//hamcrest.Matcher.hasSize() method: Check size of element
		@Test
		public void Hamcrest_HasSize() {
			given().baseUri("https://api.postman.com").
				header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").
			when().
				get("/workspaces").
			then().
				assertThat().
				statusCode(200).
				body("workspaces.name", hasSize(3));

		}
		
		// hamcrest.Matcher.everyItem(startWith()) method: Check if every item in a collection starts with specified string
//		@Test
		public void Hamcrest_EveryItemStart() {
			given().baseUri("https://api.postman.com")
					.header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").when()
					.get("/workspaces").then().assertThat().statusCode(200)
					.body("workspaces.name", hasSize(3), "workspaces.name", everyItem(startsWith("Auto")));

		}
		
		// hasKey, hasValue, equalTo(Collections.EMPTY_MAP) and hasEntry method
		@Test
		public void Hamcrest_matching() {
			given().baseUri("https://api.postman.com")
					.header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").when()
					.get("/workspaces").then().assertThat().statusCode(200).body("workspaces.name", hasSize(3),
							"workspaces[0]", hasKey("id"), "workspaces[0]",
							hasValue("979fe81a-f780-419d-8076-1186851b894b"), "workspaces[0]",
							hasEntry("id", "979fe81a-f780-419d-8076-1186851b894b"), "workspaces[0]",
							not(equalTo(Collections.EMPTY_MAP)));

		}

		// AllOf and AnyOf method
		@Test
		public void Hamcrest_AllOf_AnyOf() {
			given().baseUri("https://api.postman.com")
					.header("x-api-key", "PMAK-657c0f29b2c96200315e434d-8563db903a188bc049fd9f236a34d329a4").when()
					.get("/workspaces").then().assertThat().statusCode(200)
					.body("workspaces.name", hasSize(3),
							"workspaces[0]", hasKey("id"),
							"workspaces[0]", hasValue("979fe81a-f780-419d-8076-1186851b894b"),
							"workspaces[0]", hasEntry("id", "979fe81a-f780-419d-8076-1186851b894b"),
							"workspaces[0]", not(equalTo(Collections.EMPTY_MAP)),
							"workspaces[0].name", allOf(startsWith("My"), containsString("Workspace")),
							"workspaces[0].name", anyOf(startsWith("My1"), containsString("Workspace"))
							);

		}	
		
				
	
}
