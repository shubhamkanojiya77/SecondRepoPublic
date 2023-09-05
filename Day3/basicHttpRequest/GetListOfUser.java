package basicHttpRequest;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetListOfUser {

	public static void main(String[] args) {
//		https://reqres.in/api/users?page=2
		RestAssured.baseURI = "https://reqres.in";

//		Response response = given().log().all().queryParam("page", "2").pathParam("path", "users").when()
//				.get("api/{path}").then().log().all().assertThat().statusCode(200).extract().response();
//
//		System.out.println(response.asPrettyString());

//		String response = given().log().all().queryParam("page", "2").pathParam("path", "users").when()
//				.get("api/{path}").then().log().all().assertThat().statusCode(200).extract().response()
//				.asPrettyString();
//
//		System.out.println("*************************");
//		System.out.println(response);

		JsonPath jp = given().log().all().queryParam("page", "2").pathParam("path", "users").when().get("api/{path}")
				.then().log().all().assertThat().statusCode(200).extract().response().jsonPath();

		System.out.println("*************************");
		System.out.println(jp.getString("data[0].first_name"));
	}

}
