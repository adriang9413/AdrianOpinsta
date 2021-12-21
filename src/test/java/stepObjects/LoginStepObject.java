package stepObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.LeftSideMenuPageObject;
import pageObjects.LoginPageObject;
import utils.BaseClass;

public class LoginStepObject extends BaseClass {

	public LoginStepObject(WebDriver driver) {
		super(driver);
	}

	public static String userID;
	public String[] list;

	public void logInApp(String username, String password) {
		$(LoginPageObject.getLoginEmail()).sendKeys(username);
		$(LoginPageObject.getLoginPassword()).sendKeys(password);
		$(LoginPageObject.getSubmitButton()).click();
		list = driver.getCurrentUrl().split("user/");
		userID = list[1];
	}

	public void logOutApp(){
		scrollToXpathElement(LeftSideMenuPageObject.getLogOutButton());
		$(LeftSideMenuPageObject.getLogOutButton()).click();
		wait_for_id_elem_to_be_visible(LoginPageObject.getLoginEmail(), 10);
	}
}
