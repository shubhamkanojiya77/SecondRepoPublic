package httpRequestWithPayload;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utility.Payload;

public class PostRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users

//		Specify the base URI to RestAssured class
		RestAssured.baseURI = "https://reqres.in";

		String userName = "Kieren Polad";
		String userJob = "Cricketer";

		JsonPath jp = given().log().all().header("Content-Type", "application/json")
				.body(Payload.postRequestPayload(userName, userJob)).when().post("api/users").then().log().all()
				.assertThat().statusCode(201).extract().response().jsonPath();

		Assert.assertEquals(jp.getString("name"), userName);
		Assert.assertTrue(userJob.equals(jp.getString("job")));
	}

}

//	BDD Approach
//	given -> pre-requisites/ pre-condition {request params, request header, request body, authorization}
//	when  -> user action {specify http method, POST/GET/PUT/DELETE}
//	then  -> validation {status code, response body, response header, ....}

//	log  -> log().all() {request or response}
