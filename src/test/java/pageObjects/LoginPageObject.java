package pageObjects;

public class LoginPageObject {

	private static String loginEmail = "email";
	private static String loginPassword = "password";
	private static String submitButton = "//*[@dt-at='logInButton']";
	private static String samButton = "//*[@src='https://portal.opinsta.com/images/SAM.png']";

	public static String getLoginEmail() {
		return loginEmail;
	}

	public static String getLoginPassword() {
		return loginPassword;
	}

	public static String getSubmitButton() {
		return submitButton;
	}

	public static String getSamButton() {
		return samButton;
	}

}
