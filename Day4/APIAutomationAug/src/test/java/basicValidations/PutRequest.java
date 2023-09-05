package basicValidations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//	how to validate the response body or data present in the response body
public class PutRequest {

	public static void main(String[] args) {
//		https://reqres.in/api/users/2

		RestAssured.baseURI = "https://reqres.in";

		Response response = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}").when()
				.put("api/users/2").then().log().all().assertThat().statusCode(200).extract().response();

//		how to print the response body
		System.out.println(response.toString());
		System.out.println(response.asString());
		System.out.println(response.asPrettyString());

//		to validate the response body, we have to parse the json response using JsonPath class
		JsonPath jp = new JsonPath(response.asString());

		String userName = jp.getString("name");
		System.out.println("User name is : " + userName);
		Assert.assertEquals(userName, "morpheus");

		String userJob = jp.getString("job");
		System.out.println("User job is :" + userJob);
		Assert.assertEquals(userJob, "zion resident");
	}

}
