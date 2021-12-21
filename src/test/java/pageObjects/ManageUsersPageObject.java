package pageObjects;

public class ManageUsersPageObject {
	private static String addNewUserButton = "//button[contains(text(),'ADD NEW')]";
	private static String userName = "user_name-create";
	private static String userEmail = "user_email-create";
	private static String userJobTitle = "user_job-create";
	private static String userLocationsButton = "//div[@dt-fordd='locations']/input[1][@dt-fordd='locations']";
	private static String userLocationDropdown ="//span[contains(text(),'%s')]";
	private static String userPortalAccess = "//a[@id='dropdownSystem_1-create']";
	private static String userPortalAdminDropdown = "//div[@id='dropdownList_1-create']/a[2]";
	private static String userCommunicateAccess = "//a[@id='dropdownSystem_2-create']";
	private static String userCommunicateAdminDropdown = "//div[@id='dropdownList_2-create']/a[3]";
	private static String userSamAccess = "//a[@id='dropdownSystem_3-create']";
	private static String userSamStandardDropdown = "//div[@id='dropdownList_3-create']/a[2]";
	private static String userLostAndFoundAccess = "//a[@id='dropdownSystem_4-create']";
	private static String userLostAndFoundDropdown = "//div[@id='dropdownList_4-create']/a[2]";
	private static String saveUserButton = "//div[@id='createUserMenu']//div//div//button[@class='button-custom btn-positive'][contains(text(),'Save')]";
	private static String aboveAlert = "above--alert";
	private static String userSearch = "input-search-form";
	private static String userInTable = "//td[contains(text(),'%s')]";
	private static String updateUserButton = "//button[contains(text(),'Update')]";
	private static String removeUserButton = "//button[contains(text(),'Remove')]";
	private static String confirmDeleteUserButton = "//button[contains(text(),'Yes, Proceed')]";
	
	
	public static String getUserName() {
		return userName;
	}

	public static String getUserEmail() {
		return userEmail;
	}

	public static String getUserJobTitle() {
		return userJobTitle;
	}

	public static String getUserLocationsButton() {
		return userLocationsButton;
	}

	public static String getUserLocationDropdown() {
		return userLocationDropdown;
	}

	public static String getAddNewUserButton() {
		return addNewUserButton;
	}

	public static String getUserPortalAccess() {
		return userPortalAccess;
	}

	public static String getUserPortalAdminDropdown() {
		return userPortalAdminDropdown;
	}

	public static String getUserCommunicateAccess() {
		return userCommunicateAccess;
	}

	public static String getUserCommunicateAdminDropdown() {
		return userCommunicateAdminDropdown;
	}

	public static String getUserSamAccess() {
		return userSamAccess;
	}

	public static String getUserSamStandardDropdown() {
		return userSamStandardDropdown;
	}

	public static String getUserLostAndFoundAccess() {
		return userLostAndFoundAccess;
	}

	public static String getUserLostAndFoundDropdown() {
		return userLostAndFoundDropdown;
	}

	public static String getSaveUserButton() {
		return saveUserButton;
	}

	public static String getAboveAlert() {
		return aboveAlert;
	}

	public static String getUserSearch() {
		return userSearch;
	}

	public static String getUserInTable() {
		return userInTable ;
	}

	public static String getUpdateUserButton() {
		return updateUserButton;
	}

	public static String getRemoveUserButton() {
		return removeUserButton;
	}

	public static String getConfirmDeleteUserButton() {
		return confirmDeleteUserButton;
	}

}
