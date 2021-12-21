package pageObjects;

public class ProblemPageObject {
	private static String addNewProblemButton = "new-entry-btn";
	private static String problemAddAssetGroupBtn = "asset_type_name";
	private static String inputAssetGroupText = "//*[@id='create-form']/div[2]/div[1]/ul/span/input";
	private static String assetGroupNameDropdown = "//*[@dt-at='assetGroupNameDropdown']";
	private static String nonSpecificAssetGroup = "//*[@id='create-form']/div[2]/div[1]/ul/li[2]/ul/li";
	private static String specificAssetGroup = "//*[@id='create-form']/div[2]/div[1]/ul/li[2]/ul/li[3]/span";
	// "//div[@class='form-input select-item-name']//select[@class='select-type']";
	private static String firstLevelField = "//*[@dt-at='firstLevelField']";
	private static String saveButton = "//*[@dt-at='saveButton']";
	private static String problemSavedMessage = "above--alert";
	private static String problemSearchBar = "input-search-form";
	private static String problemInTable = "//td[contains(text(),'%s')]";
	private static String assetGroupMandatoryError = "//input[@id='asset_type_name']/following-sibling::div";
	private static String firstLevelMandatoryError = "//div[@class='form-input ']/input[@dt-name='type1']/following-sibling::div";
	private static String cancelButton = "//button[@class='button-custom btn-default1 cancel-btn'][contains(text(),'CANCEL')]";
	private static String defineProblem = "//span[contains(text(),'Define Problem')]";
	private static String contractorField = "//input[@dt-name='contractor_id']";
	// "//input[@class='normal-input form-control select-input contractor_name
	// get-value select-search-trigger is-invalid']";
	private static String contractorDropDown = "//ul[@class='select-dropdown w-100 shadow fadeInDown active']//li//ul[@class='select-dropdown--options op-scrollbar']/li/span[contains(., '%s')]";
	private static String guidanceField = "//input[@dt-name='resolution_id']";
	private static String guidanceDropDown = "//ul[@class='select-dropdown w-100 shadow fadeInDown active']//li//ul[@class='select-dropdown--options op-scrollbar']//li//span[contains(.,'%s')]";
	private static String contractorMandatoryError = "//input[@dt-name='contractor_id']/following-sibling::div";
	private static String guidanceMandatoryError = "//input[@dt-name='resolution_id']/following-sibling::div";

	public static String getAddNewProblemButton() {
		return addNewProblemButton;
	}

	public static String getProblemAddAssetGroupBtn() {
		return problemAddAssetGroupBtn;
	}

	public static String getSelectAssetGroup() {
		return assetGroupNameDropdown;
	}

	public static String getFirstLevelField() {
		return firstLevelField;
	}

	public static String getSaveButton() {
		return saveButton;
	}

	public static String getProblemSavedMessage() {
		return problemSavedMessage;
	}

	public static String getProblemSearchBar() {
		return problemSearchBar;
	}

	public static String getProblemInTable() {
		return problemInTable;
	}

	public static String getAssetGroupMandatoryError() {
		return assetGroupMandatoryError;
	}

	public static String getFirstLevelMandatoryError() {
		return firstLevelMandatoryError;
	}

	public static String getCancelButton() {
		return cancelButton;
	}

	public static String getDefineProblem() {

		return defineProblem;
	}

	public static String getContractorField() {
		return contractorField;
	}

	public static String getContractorDropDown() {
		return contractorDropDown;
	}

	public static String getGuidanceField() {
		return guidanceField;
	}

	public static String getGuidanceDropDown() {
		return guidanceDropDown;
	}

	public static String getContractorMandatoryError() {
		return contractorMandatoryError;
	}

	public static String getGuidanceMandatoryError() {
		return guidanceMandatoryError;
	}

	public static String getSpecificAssetGroup() {
		return specificAssetGroup;
	}

	public static String getNonSpecificAssetGroup() {
		return nonSpecificAssetGroup;
	}

	public static String getInputAssetGroupText() {
		return inputAssetGroupText;
	}
}
