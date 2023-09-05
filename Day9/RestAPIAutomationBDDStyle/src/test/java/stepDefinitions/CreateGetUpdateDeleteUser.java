package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.Data;
import utility.RestAssuredUtility;

public class CreateGetUpdateDeleteUser extends RestAssuredUtility {
//	https://gorest.co.in/public/v2/users

	Data data = new Data();
	RequestSpecification createUserReq;
	Response createUserRes;

	@Given("Create user payload details {string} {string} {string} {string}")
	public void create_user_payload_details(String userName, String gender, String email, String status) {
		RestAssured.baseURI = "https://gorest.co.in";
		createUserReq = given().log().all()
				.header("Authorization", "Bearer 4bd56fdc8137b99b957938010a2b0a0cfcbdd5099e32f9aa8adf5b3c6ea4d8f8")
				.header("Content-Type", "application/json").body(data.createUserData(userName, gender, email, status));

	}

	@When("User calls CreateUser API using POST method")
	public void user_calls_create_user_api_using_post_method() {
		createUserRes = createUserReq.when().post("public/v2/users").then().log().all().extract().response();
	}

	@Then("The POST API call got success with status code {int}")
	public void the_post_api_call_got_success_with_status_code(int expectedStatusCode) {
		assertEquals(createUserRes.getStatusCode(), expectedStatusCode);
	}

	@Then("email in the Post response is {string}")
	public void email_in_the_post_response_is(String expectedEmailId) {
		assertEquals(getJsonStringData(createUserRes, "email"), expectedEmailId);
	}
}
