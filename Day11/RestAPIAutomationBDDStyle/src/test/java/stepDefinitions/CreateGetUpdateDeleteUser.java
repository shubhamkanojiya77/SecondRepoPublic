package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.Data;
import utility.RestAssuredUtility;

public class CreateGetUpdateDeleteUser extends RestAssuredUtility {
//	https://gorest.co.in/public/v2/users

	Data data = new Data();
	RequestSpecification createUserReq;
	RequestSpecification updateUserReq;
	static Response createUserRes;
	Response getUserRes;
	Response updateUserRes;
	Response deleteUserRes;
	static int userId;

	@Given("{string} user payload details {string} {string} {string} {string}")
	public void create_user_payload_details(String reqType, String userName, String gender, String email, String status)
			throws FileNotFoundException {
		if (reqType.equalsIgnoreCase("Create"))
			createUserReq = given().spec(requestSpecification()).header("Content-Type", "application/json")
					.body(data.createUserData(userName, gender, email, status));
		if (reqType.equalsIgnoreCase("Update"))
			updateUserReq = given().pathParam("userID", userId).spec(requestSpecification())
					.header("Content-Type", "application/json").body(data.updateUserData(userName, email, status));
	}

	@When("User calls {string} API using {string} method")
	public void user_calls_api_using_method(String typeOfAPI, String httpMethod) throws FileNotFoundException {
		if (httpMethod.equalsIgnoreCase("POST"))
			createUserRes = createUserReq.when().post("public/v2/users");
		if (httpMethod.equalsIgnoreCase("GET"))
			getUserRes = given().pathParam("userID", userId).spec(requestSpecification()).when()
					.get("public/v2/users/{userID}");
		if (httpMethod.equalsIgnoreCase("PUT"))
			updateUserRes = updateUserReq.when().put("public/v2/users/{userID}");
		if (httpMethod.equalsIgnoreCase("DELETE"))
			deleteUserRes = given().pathParam("userID", userId).spec(requestSpecification()).when()
					.delete("public/v2/users/{userID}");
	}

	@Then("The {string} API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(String httpMethod, int expectedStatusCode) {
		if (httpMethod.equalsIgnoreCase("POST"))
			assertEquals(createUserRes.getStatusCode(), expectedStatusCode);
		if (httpMethod.equalsIgnoreCase("GET"))
			assertEquals(getUserRes.getStatusCode(), expectedStatusCode);
		if (httpMethod.equalsIgnoreCase("PUT"))
			assertEquals(updateUserRes.getStatusCode(), expectedStatusCode);
		if (httpMethod.equalsIgnoreCase("DELETE"))
			assertEquals(deleteUserRes.getStatusCode(), expectedStatusCode);
	}

	@Then("{string} in the {string} response is {string}")
	public void in_the_response_is(String key, String httpMethod, String expectedValue) {
		if (httpMethod.equalsIgnoreCase("POST"))
			assertEquals(getJsonStringData(createUserRes, key), expectedValue);
		if (httpMethod.equalsIgnoreCase("GET"))
			assertEquals(getJsonStringData(getUserRes, key), expectedValue);
		if (httpMethod.equalsIgnoreCase("PUT"))
			assertEquals(getJsonStringData(updateUserRes, key), expectedValue);
	}

	@Given("User has userID of already created user")
	public void user_has_user_id_of_already_created_user() {
		userId = getJsonIntData(createUserRes, "id");
	}
}
