package basicHttpRequest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PostRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users

//		Specify the base URI to RestAssured class
		RestAssured.baseURI = "https://reqres.in";

		given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"Raj\",\r\n" + "    \"job\": \"QA\"\r\n" + "}").when().post("api/users")
				.then().log().all().assertThat().statusCode(201);
	}

}

//	BDD Approach
//	given -> pre-requisites/ pre-condition {request params, request header, request body, authorization}
//	when  -> user action {specify http method, POST/GET/PUT/DELETE}
//	then  -> validation {status code, response body, response header, ....}

//	log  -> log().all() {request or response}
