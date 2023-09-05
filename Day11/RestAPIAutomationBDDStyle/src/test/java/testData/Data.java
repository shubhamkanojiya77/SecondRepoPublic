package testData;

import pojoClasses.CreateUser;
import pojoClasses.UpdateUser;

public class Data {

	public CreateUser createUserData(String userName, String gender, String email, String status) {
		CreateUser createUser = new CreateUser();
		createUser.setName(userName);
		createUser.setGender(gender);
		createUser.setEmail(email);
		createUser.setStatus(status);

		return createUser;
	}

	public UpdateUser updateUserData(String userName, String email, String status) {
		UpdateUser updateUser = new UpdateUser();
		updateUser.setName(userName);
		updateUser.setEmail(email);
		updateUser.setStatus(status);
		return updateUser;
	}

}
