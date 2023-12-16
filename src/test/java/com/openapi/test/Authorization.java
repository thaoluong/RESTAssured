package com.openapi.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Authorization {

	public static String accessToken;

	@Test(priority = 1)

	public static void getAccessToken() {

		JSONObject request = new JSONObject();
		request.put("clientId", "sldzzkfZ-xIEfPbMpdmuZDg1Ze6Dg58C");
		request.put("clientSecret", "2f0FsVrNC1uKj4Mkr9V0u8_MhHPEp_l89QhIQZPUDjUZgkc6TX5IyGrvDJQN4ZSr");

		Response response =given().
								baseUri("https://openapi.dataismist.com").header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
							when().
								post("/v1/auth/token/create");

		Assert.assertEquals(response.statusCode(), 201);
		accessToken = response.body().jsonPath().getString("data.accessToken");
		System.out.println(request);
		System.out.println(accessToken);
//		response.prettyPrint();

	}
}
