package pageObjects;

public class FormsHealthAndSafetyPageObject {

	private static String addNewFormButton = "new-entry-btn";
	private static String formName = "inspection_name-create";
	private static String formPublicUrl = "public-url--input--create";
	private static String formPublicUrlDropdown = "create_inspection_public-url";
	private static String formGuidance = "input_create_inspection--guidance";
	private static String formGuidanceDropdown = "create_inspection--guidance";
	private static String saveButton = "//button[contains(text(),'SAVE')]";
	private static String aboveAlert = "above--alert";
	private static String formHealthTitle = "//div[@class='page-title']";
	private static String stagingGuidanceDropdown = "//span[contains(text(),'%s')]";
	private static String searchBar = "input-search-form";
	private static String formInTable = "//table[@id='inspections_table_active']/tbody/tr/td[contains(., '%s')]";
	private static String categoryTypeRightPage= "input_inspection_category-create";
	private static String redirectFormPageTitle = "//div[@class='page-title']";
	private static String formNameMandatoryError = "//input[@id='inspection_name-create']/following-sibling::div";
	private static String publicUrlMandatoryField = "//input[@id='input_create_inspection_public-url']/following-sibling::div";
	private static String publicUrlDropdown = "//*[@id='createInspectionMenu']/div/div[4]/div/div/ul/li[2]/ul";
	private static String editFormButton = "//tbody/tr[1]/td[6]/button";
	
	public static String getAddNewFormButton() {
		return addNewFormButton;
	}
	public static String getFormName() {
		return formName;
	}
	public static String getFormPublicUrl() {
		return formPublicUrl;
	}
	public static String getFormPublicUrlDropdown() {
		return formPublicUrlDropdown;
	}
	public static String getFormGuidance() {
		return formGuidance;
	}
	public static String getFormGuidanceDropdown() {
		return formGuidanceDropdown;
	}
	public static String getSaveButton() {
		return saveButton;
	}
	public static String getAboveAlert() {
		return aboveAlert;
	}
	public static String getFormHealthTitle() {
		return formHealthTitle;
	}
	public static String getStagingGuidanceDropdown() {
		return stagingGuidanceDropdown;
	}
	public static String getSearchBar() {
		return searchBar ;
	}
	public static String getFormInTable() {
		return formInTable ;
	}
	public static String getRedirectFormPageTitle() {
		return redirectFormPageTitle;
	}
	public static String getCategoryTypeRightPage() {
		return categoryTypeRightPage;
	}
	public static String getFormNameMandatoryError() {
		return formNameMandatoryError ;
	}
	public static String getPublicUrlMandatoryField() {
		return publicUrlMandatoryField ;
	}


	public static String getPublicUrlDropdown() {
		return publicUrlDropdown;
	}

	public static String getEditFormButton() {
		return editFormButton;
	}
}
