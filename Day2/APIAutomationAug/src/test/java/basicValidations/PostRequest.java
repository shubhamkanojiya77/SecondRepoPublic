package basicValidations;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

//	Validation that we will consider here will be as below:
//	1. Status code
//	2. Response time
//	3. Response header
public class PostRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users

//		Specify the base URI to RestAssured class
		RestAssured.baseURI = "https://reqres.in";

//		extract the response
		Response response = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"Raj\",\r\n" + "    \"job\": \"QA\"\r\n" + "}").when().post("api/users")
				.then().log().all().assertThat().statusCode(201).extract().response();

//		response() return ==> The entire response object including headers, cookies and body etc.

		int responseCode = response.getStatusCode();
		System.out.println("Response code : " + responseCode);
		Assert.assertEquals(responseCode, 201);

		long responseTime = response.getTime();
		System.out.println("Response time : " + responseTime);
		Assert.assertTrue(responseTime < 2000);
//		The response time in milliseconds 

		String serverHeader = response.getHeader("Server");
		System.out.println("Server header : " + serverHeader);
		Assert.assertEquals(response.getHeader("Server"), "cloudflare");
	}

}
