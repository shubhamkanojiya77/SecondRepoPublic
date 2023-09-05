package goRestAPI;

import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import goRestAPIPojoClasses.CreateUser;
import goRestAPIPojoClasses.CreateUserRes;
import goRestAPIPojoClasses.GetUserRes;
import io.restassured.RestAssured;

public class CreateGetUpdateDeleteUser {

	public static void main(String[] args) {
//		https://gorest.co.in/public/v2/users
		RestAssured.baseURI = "https://gorest.co.in";

//		********************Create User API********************
//		create the object of the pojo class for create user
		CreateUser createUser = new CreateUser();
		createUser.setName("Smith Lee");
		createUser.setEmail("smith.lee1@15ce.com");
		createUser.setGender("male");
		createUser.setStatus("active");

		CreateUserRes createUserRes = given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 4bd56fdc8137b99b957938010a2b0a0cfcbdd5099e32f9aa8adf5b3c6ea4d8f8")
				.body(createUser).when().post("public/v2/users").then().log().all().extract().as(CreateUserRes.class);

		Integer createUserId = createUserRes.getId();
		System.out.println(createUserId);

//		********************Get User API********************
//		https://gorest.co.in/public/v2/users/userId

		GetUserRes getUserRes = given().log().all().pathParam("userId", createUserId)
				.header("Authorization", "Bearer 4bd56fdc8137b99b957938010a2b0a0cfcbdd5099e32f9aa8adf5b3c6ea4d8f8")
				.when().get("public/v2/users/{userId}").then().log().all().extract().as(GetUserRes.class);

//		to use testNg soft asserts, first create the object of SoftAssert class
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(getUserRes.getName(), "Smith Lee");
		softAssert.assertEquals(getUserRes.getEmail(), "smith.lee1@15ce.com", "Email verification failed");
		
		softAssert.assertAll(); // call this method to see the output of all the softassert statements

//		Assert.assertEquals(getUserRes.getName(), "Smith Lee");
//		Assert.assertEquals(getUserRes.getEmail(), "smith.lee@15ce.com");
	}

}
