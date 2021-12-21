package tests;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class ManageCreateUsersTests extends Setup{
	public static String userName = "UserSelenium"+ new Random().nextInt(10000);
	private String userEmail = "opinsta.standard"+ new Random().nextInt(10000)+"@test.ro";
	private String userJobTitle = "QA";
	private String location = "Bucharest";
	private String userAccessLevel = "Admin";
	
	@Test(priority = 2, groups="dependencies")
	public void SAM985_createNewUserAndDelete() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		manageUsersStepObject.createUser(userName, userEmail, userJobTitle, location);
		manageUsersStepObject.verifyUserSuccesfullyCreatedMesssge();
		manageUsersStepObject.verifyUserSaved(userEmail);
	}
	

}
