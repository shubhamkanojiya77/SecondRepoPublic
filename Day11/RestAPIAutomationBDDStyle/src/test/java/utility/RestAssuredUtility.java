package utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtility {

	static RequestSpecification reqSpec;

	public String getJsonStringData(Response responseBody, String key) {
		JsonPath jp = new JsonPath(responseBody.asString());
		return jp.getString(key);
	}

	public int getJsonIntData(Response responseBody, String key) {
		JsonPath jp = new JsonPath(responseBody.asString());
		return jp.getInt(key);
	}

	public RequestSpecification requestSpecification() throws FileNotFoundException {
		if (reqSpec == null) {
			PrintStream log = new PrintStream(new FileOutputStream("TestLogs.txt"));
			reqSpec = new RequestSpecBuilder()
					.addHeader("Authorization",
							"Bearer 4bd56fdc8137b99b957938010a2b0a0cfcbdd5099e32f9aa8adf5b3c6ea4d8f8")
					.setBaseUri("https://gorest.co.in").addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return reqSpec;
		}
		return reqSpec;
	}
}
