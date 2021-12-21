package pageObjects;

public class AssetPageObject {
	private static String addNewAssetButton = "new-entry-btn";
	private static String assetGroupBtn = "asset_type_name";
	private static String assetGroupNameDropdown = "//*[@dt-at='assetGroupNameDropdown']";
	private static String assetFirstSubcategory = "//*[@dt-at='assetFirstSubcategory']";
	private static String assetSaveButton = "//*[@dt-at='assetSaveButton']";
	private static String assetSavedMessage = "above--alert";
	private static String assetSearch = "input-search-form";
	private static String assetInTable = "//td[contains(text(),'%s')]";
	private static String assetGroupNameMandatoryError = "//input[@id='asset_type_name']/following-sibling::div";
	private static String assetFirstSubCategoryMandatoryError = "//div[@class='form-input']//input[@type='text']/following-sibling::div";
	private static String cancelButton = "//button[@class='button-custom btn-positive']/following-sibling::div/button";

	public static String getAddNewAssetButton() {
		return addNewAssetButton;
	}

	public static String getAssetGroupBtn() {
		return assetGroupBtn;
	}

	public static String getAssetGroupNameDropdown() {
		return assetGroupNameDropdown;
	}

	public static String getAssetFirstSubcategory() {
		return assetFirstSubcategory;
	}

	public static String getAssetSaveButton() {
		return assetSaveButton;
	}

	public static String getAssetSavedMessage() {
		return assetSavedMessage;
	}

	public static String getAssetSearch() {
		return assetSearch;
	}

	public static String getAssetInTable() {
		return assetInTable;
	}

	public static String getAssetGroupNameMandatoryError() {
		return assetGroupNameMandatoryError;
	}

	public static String getAssetFirstSubCategoryMandatoryError() {
		return assetFirstSubCategoryMandatoryError;
	}

	public static String getCancelButton() {
		return cancelButton;
	}

}
