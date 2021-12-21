package pageObjects;

public class FormsOverviewPageObject {
	private static String createNewFormButton = "form_create_new";
	private static String categoryBox = "categories-input--modal";
	private static String categoryDropdown = "inspection_categories";
	private static String formBox = "inspections-input--modal";
	private static String formDropdown = "inspections";
	private static String formDropdownList = "//*[@dt-at='formDropdownList']";
	private static String mandatoryTextField = "//input[@class='normal-input form-control']";
	private static String submitButton = "submit_button-modal";
	private static String nextButton = "next_button-modal";
	private static String nextButtonUpdate = "next-button--modal";
	private static String aboveAlert = "above--alert";
	private static String mandatoryFieldAlert = "//div[@id='inspection_items-modal_content']//div[@class='invalid-feedback']";
	private static String formDetailsPageTitle = "//*[@dt-at='formDetailsPageTitle']";
	private static String guidanceContinueButton = "//*[@dt-at='guidanceContinueButton']";
	private static String viewPdfLink = "//*[@dt-at='viewPdfLink']";
	private static String viewURLLink = "//*[@dt-at='viewURLLink']";
	private static String categoryGroupName = "//ul[@class='select-dropdown w-100 shadow fadeInDown active']//li//ul[@class='select-dropdown--options op-scrollbar']//li//span[contains(text(),'%s')]";
	private static String pageTitleFormsOverview = "//*[@dt-at='pageTitleFormsOverview']";
	private static String formsOverviewInTable = "//table[@id='completed_inspections_table_active']/tbody/tr/td[contains(.,'%s')]";
	private static String formActionsButton = "form_actions";
	private static String formUpdateStatus = "update-status--action";
	private static String changeStatusInput = "change-status--input";
	private static String changeStatusValue = "//*[@dt-at='changeStatusValue']";
	private static String viewLessOrMoreButton = "view-more_less_button";
	private static String vieLessOrMoreButtonText = "//a[@id='view-more_less_button']/div";
	private static String statusInFormDetail = "//*[@dt-at='statusInFormDetail']";
	private static String submitStatusButton = "submit-button-status--modal";
	private static String editFormButton = "edit-form--action";
	private static String formDetails = "//div[@id='items-inspection_details']/div";
	private static String updateFormTextField = "//input[@class='normal-input form-control']";
	private static String editFormSubmitButton = "submit-button--modal";
	private static String formAssignButton = "assign--action";
	private static String assignUserTextField = "assign-new--input";
	private static String assignUser = "//select[@id='assign-new']";
	private static String assignUserDropDown = "//*[@dt-at='assignUserDropDown']";
	private static String assignSubmitButton = "submit-button-assign--modal";
	private static String formDetailsUser = "assignee_details";
	private static String mandatoryField1 = "//div[@id='form-modal--content']/div[1]/div/div/div/input";
	private static String mandatoryField2 = "//div[@id='form-modal--content']/div[2]/div/div/div/input";

	private static String mandatoryField1Sch = "//html/body/div[3]/div/div[5]/div[2]/div/div[1]/div[5]/div[1]/div/div/div/input";
	private static String mandatoryField2Sch = "//html/body/div[3]/div/div[5]/div[2]/div/div[1]/div[5]/div[2]/div/div/div/textarea";
	private static String mandatoryField3Sch = "//html/body/div[3]/div/div[5]/div[2]/div/div[1]/div[5]/div[7]/div/div/div/textarea";
	private static String mandatoryField4Sch = "//html/body/div[3]/div/div[5]/div[2]/div/div[1]/div[5]/div[8]/div/div/div/input";
	private static String mandatoryField5Sch = "//html/body/div[3]/div/div[5]/div[2]/div/div[1]/div[5]/div[10]/div/div/div/input";


	public static String getCreateNewFormButton() {
		return createNewFormButton;
	}

	public static String getCategoryBox() {
		return categoryBox;
	}

	public static String getCategoryDropdown() {
		return categoryDropdown;
	}

	public static String getFormBox() {
		return formBox;
	}

	public static String getFormDropdown() {
		return formDropdown;
	}

	public static String getMandatoryTextField() {
		return mandatoryTextField;
	}

	public static String getSubmitButton() {
		return submitButton;
	}

	public static String getAboveAlert() {
		return aboveAlert;
	}

	public static String getFormDetailsPageTitle() {
		return formDetailsPageTitle;
	}

	public static String getMandatoryFieldAlert() {
		return mandatoryFieldAlert;
	}

	public static String getGuidanceContinueButton() {
		return guidanceContinueButton;
	}

	public static String getViewPdfLink() {
		return viewPdfLink;
	}

	public static String getViewURLLink() {
		return viewURLLink;
	}

	public static String getCategoryGroupName() {
		return categoryGroupName;
	}

	public static String getPageTitleFormsOverview() {
		return pageTitleFormsOverview;
	}

	public static String getFormsOverviewInTable() {
		return formsOverviewInTable;
	}

	public static String getFormActionsButton() {
		return formActionsButton;
	}

	public static String getFormUpdateStatus() {
		return formUpdateStatus;
	}

	public static String getChangeStatusInput() {
		return changeStatusInput;
	}

	public static String getChangeStatusValue() {
		return changeStatusValue;
	}

	public static String getViewLessOrMoreButton() {
		return viewLessOrMoreButton;
	}

	public static String getViewLessOrMoreButtonText() {
		return vieLessOrMoreButtonText;
	}

	public static String getStatusInFormDetail() {
		return statusInFormDetail;
	}

	public static String getSubmitStatusButton() {
		return submitStatusButton;
	}

	public static String getEditFormButton() {
		return editFormButton;
	}

	public static String getFormDetails() {
		return formDetails;
	}

	public static String getUpdateFormTextField() {
		return updateFormTextField;
	}

	public static String getEditFormSubmitButton() {
		return editFormSubmitButton;
	}

	public static String getFormAssignButton() {
		return formAssignButton;
	}

	public static String getAssignUserTextField() {
		return assignUserTextField;
	}

	public static String getAssignUser() {
		return assignUser;
	}

	public static String getAssignUserDropDown() {
		return assignUserDropDown;
	}

	public static String getAssignSubmitButton() {
		return assignSubmitButton;
	}

	public static String getFormDetailsUser() {
		// TODO Auto-generated method stub
		return formDetailsUser;
	}

	public static String getFormDropdownList() {
		return formDropdownList;
	}

	public static String getMandatoryField1() {
		return mandatoryField1;
	}

	public static String getMandatoryField2() {
		return mandatoryField2;
	}
	public static String getNextButton() {
		return nextButton;
	}
	public static String getNextButtonUpdate() {
		return nextButtonUpdate;
	}


	public static String getMandatoryField1Sch() {
		return mandatoryField1Sch;
	}

	public static String getMandatoryField2Sch() {
		return mandatoryField2Sch;
	}
	public static String getMandatoryField3Sch() {
		return mandatoryField3Sch;
	}

	public static String getMandatoryField4Sch() {
		return mandatoryField4Sch;
	}
	public static String getMandatoryField5Sch() {
		return mandatoryField5Sch;
	}
}
