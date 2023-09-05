package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredUtility {
	public String getJsonStringData(Response responseBody, String key) {
		JsonPath jp = new JsonPath(responseBody.asString());
		return jp.getString(key);
	}

	public int getJsonIntData(Response responseBody, String key) {
		JsonPath jp = new JsonPath(responseBody.asString());
		return jp.getInt(key);
	}
}
