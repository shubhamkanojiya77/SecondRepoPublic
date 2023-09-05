package complexJsonValidation;

import io.restassured.path.json.JsonPath;
import utility.Payload;

public class ComplexJsonValidation {

	public static void main(String[] args) {
//		First parse that complex json using JsonPath class
		JsonPath jp = new JsonPath(Payload.complexJson());

//		print the website name
		String websiteName = jp.getString("dashboard.website");
		System.out.println("Website name : " + websiteName);

//		print the purchase amount
		int purchaseAmount = jp.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount : " + purchaseAmount);

//		print the number of courses
		int numberOfCourses = jp.getInt("courses.size()");
		System.out.println("Number of courses : " + numberOfCourses);

//		print the title of first course
		String firstCourseTitle = jp.getString("courses[0].title");
		System.out.println("First course title : " + firstCourseTitle);

//		print title of all the courses
		for (int i = 0; i < jp.getInt("courses.size()"); i++) {
			System.out.println(i + 1 + " " + jp.getString("courses[" + i + "].title")); // courses[0].title
		}

//		consider courses are appearing at random index after every call, validate the price of Playwrit course
		for (int i = 0; i < numberOfCourses; i++) {
			if (jp.getString("courses[" + i + "].title").equalsIgnoreCase("Playwrit")) {
				System.out.println("Playwrit course price : " + jp.getInt("courses[" + i + "].price"));
			}
		}
	}

}
