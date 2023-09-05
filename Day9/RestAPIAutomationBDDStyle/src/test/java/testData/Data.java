package testData;

import pojoClasses.CreateUser;

public class Data {

	public CreateUser createUserData(String userName, String gender, String email, String status) {
		CreateUser createUser = new CreateUser();
		createUser.setName(userName);
		createUser.setGender(gender);
		createUser.setEmail(email);
		createUser.setStatus(status);

		return createUser;
	}

}
