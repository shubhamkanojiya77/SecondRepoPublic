package serializationAndDeserialization;

import static io.restassured.RestAssured.given;

import java.util.Iterator;
import java.util.List;

import io.restassured.RestAssured;
import pojoClasses.ListOfUsers;
import pojoClasses.UserData;

public class DeserializationPractice {

	public static void main(String[] args) {
//		https://reqres.in/api/users?page=2
		RestAssured.baseURI = "https://reqres.in";

		ListOfUsers listOfUser = given().log().all().queryParam("page", "2").pathParam("path", "users").when()
				.get("api/{path}").then().log().all().extract().as(ListOfUsers.class);

		System.out.println("Page : " + listOfUser.getPage());
		System.out.println("Per_Page : " + listOfUser.getPer_page());
		System.out.println("Total : " + listOfUser.getTotal());
		System.out.println("Total_Page : " + listOfUser.getTotal_pages());

		System.out.println("Support url : " + listOfUser.getSupport().getUrl());
		System.out.println("Support url : " + listOfUser.getSupport().getText());

		List<UserData> userData = listOfUser.getData();

		System.out.println("########################");
		System.out.println(userData.get(0).getId());
		System.out.println(userData.get(0).getFirst_name());
		System.out.println(userData.get(0).getLast_name());
		System.out.println(userData.get(0).getEmail());
		System.out.println(userData.get(0).getAvatar());

		System.out.println("########################");
		System.out.println(userData.get(1).getId());
		System.out.println(userData.get(1).getFirst_name());
		System.out.println(userData.get(1).getLast_name());
		System.out.println(userData.get(1).getEmail());
		System.out.println(userData.get(1).getAvatar());

		for (int i = 0; i < userData.size(); i++) {
			System.out.println("******************************");
			System.out.println(userData.get(i).getId());
			System.out.println(userData.get(i).getFirst_name());
			System.out.println(userData.get(i).getLast_name());
			System.out.println(userData.get(i).getEmail());
			System.out.println(userData.get(i).getAvatar());
		}

		Iterator<UserData> itr = userData.iterator();

		while (itr.hasNext()) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			UserData user = itr.next();
			System.out.println(user.getId());
			System.out.println(user.getEmail());
			System.out.println(user.getFirst_name());
			System.out.println(user.getLast_name());
			System.out.println(user.getAvatar());
		}

	}

}
