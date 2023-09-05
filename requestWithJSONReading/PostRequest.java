package requestWithJSONReading;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PostRequest {

	public static void main(String[] args) throws IOException {
//		https://restful-booker.herokuapp.com/booking
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

//		given().log().all().header("Content-Type", "application/json")
//				.body(Files.readAllBytes(Paths.get("./src/test/resources/RequestPayload.json"))).when().post("booking")
//				.then().log().all();
		
		given().log().all().header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("./src/test/resources/RequestPayload.json")))).when().post("booking")
		.then().log().all();
	}

}
