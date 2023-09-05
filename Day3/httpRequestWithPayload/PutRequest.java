package httpRequestWithPayload;

import io.restassured.RestAssured;
import utility.Payload;

import static io.restassured.RestAssured.*;

public class PutRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users/2

		RestAssured.baseURI = "https://reqres.in";

		given().log().all().header("Content-Type", "application/json").body(Payload.putRequestPayload()).when()
				.put("api/users/2").then().log().all().assertThat().statusCode(200);
	}

}
