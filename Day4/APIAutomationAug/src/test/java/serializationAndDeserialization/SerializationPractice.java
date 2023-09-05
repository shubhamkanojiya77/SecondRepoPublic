package serializationAndDeserialization;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import pojoClasses.BookingDates;
import pojoClasses.CreateBooking;

public class SerializationPractice {

	public static void main(String[] args) {
//		https://restful-booker.herokuapp.com/booking
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

//		for serialization first create the object of required pojo class
		CreateBooking createBooking = new CreateBooking();

//		use the setter methods to initialize the variables declared inside the pojo class
		createBooking.setFirstname("Jim");
		createBooking.setLastname("Brown");
		createBooking.setAdditionalneeds("Breakfast");
		createBooking.setTotalprice(111);
		createBooking.setDepositpaid(true);

		BookingDates bookingDate = new BookingDates();
		bookingDate.setCheckin("2018-01-01");
		bookingDate.setCheckout("2019-01-01");

		createBooking.setBookingdates(bookingDate);

//		now pass the pojo class object inside the body method

		given().log().all().header("Content-Type", "application/json").body(createBooking).when().post("booking").then()
				.log().all();
	}

}
