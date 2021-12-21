package pageObjects;

public class GuidancePageObject {
	private static String addNewGuidanceButton = "new-entry-btn";
	private static String guidanceTitle = "resol-name";
	private static String saveButton = "btn-save-resolution";
	private static String guidanceSavedMessage = "above--alert";
	private static String guidanceSearchBar = "input-search-form";
	private static String guidanceInTable = "//table[@id='main-table']/tbody/tr/td[contains(text(),'%s')]";
	private static String guidanceMandatoryField = "//input[@id='resol-name']/following-sibling::div";
	private static String cancelButton = "//button[@class='button-custom btn-default1 cancel-btn'][contains(text(),'CANCEL')]";
	private static String attachmentsButton = "btn-attachments-create";
	private static String urlButton = "//div[@id='attach-create']/div[contains(., 'URL')]";
	private static String urlLinkBox = "url-link-input";
	private static String urlSaveButton = "save-url";
	private static String urlAttachementsSection = "//div[@id='url-info']/div/span[2]";
	private static String pdfFileButton = "file-pdf";
	private static String pdfAttachmentsSection = "//div[@id='pdf-info']//div[@class='att-name']/span[2]";
	
	public static String getAddNewGuidanceButton() {
		return addNewGuidanceButton;
	}

	public static String getGuidanceTitle() {
		return guidanceTitle;
	}

	public static String getSaveButton() {
		return saveButton;
	}

	public static String getGuidanceSavedMessage() {
		return guidanceSavedMessage;
	}

	public static String getGuidanceSearchBar() {
		return guidanceSearchBar;
	}

	public static String getGuidanceInTable() {
		return guidanceInTable ;
	}

	public static String getGuidanceMandatoryField() {
		return guidanceMandatoryField;
	}

	public static String getCancelButton() {
		return cancelButton;
	}

	public static String getAttachmentsButton() {
		return attachmentsButton;
	}

	public static String getUrlButton() {
		return urlButton;
	}

	public static String getUrlLinkBox() {
		return urlLinkBox;
	}

	public static String getUrlSaveButton() {
		return urlSaveButton;
	}

	public static String getUrlAttachementsSection() {
		return urlAttachementsSection;
	}

	public static String getPdfFileButton() {
		return pdfFileButton;
	}

	public static String getPdfAttachmentsSection() {
		return pdfAttachmentsSection;
	}

}
