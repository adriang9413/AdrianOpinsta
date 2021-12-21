package pageObjects;

public class FormsInspectionsPageObject {
	private static String addNewFormButton = "new-entry-btn";
	private static String formName = "inspection_name-create";
	private static String formPublicUrl = "public-url--input--create";
	private static String formPublicUrlDropdown = "//*[@id='createInspectionMenu']/div/div[4]/div/div/ul/li[2]/ul";
	private static String formGuidance = "input_create_inspection--guidance";
	private static String formGuidanceDropdown = "create_inspection--guidance";
	private static String saveButton = "//html/body/div[3]/div/div[8]/div/div[7]/div[2]/button";
	private static String aboveAlert = "above--alert";
	private static String formInspectionTitle = "//div[@class='page-title']";
	private static String searchBar = "input-search-form";
	private static String inspectionInTable = "//table[@id='inspections_table_active']/tbody/tr/td[contains(., '%s')]";
	private static String inspectionNameRedirect = "//div[@class='page-title']";
	private static String stagingGuidanceDropdown = "//*[@id='createInspectionMenu']/div/div[7]/div/div/ul/li[2]/ul" ;
	private static String editFormButton = "//*[@id='active-reports']//tbody/tr[1]/td[3]/button";
	private static String inputButton = "create-text";
	private static String formInputPlaceholder = "placeholder-create";
	private static String formInputSaveButton = "btn_save_inspection_item-create";
	private static String formNameInputInActiveTable = "//table[@id='inspection_items_table_active']/tbody/tr[1]/td[3]";
	private static String formInputMandatoryInActiveTable = "//table[@id='inspection_items_table_active']/tbody/tr[1]/td[9]";
	private static String textareaButton = "create-textarea";
	private static String textareaName = "section-create";
	private static String textareaPlaceholder = "placeholder-create";
	private static String activeFormSwitch = "//label[@for='switch_active-create']";
	private static String activeFormTab = "//*[@href='#active-reports']";
	private static String inactiveFormTab = "//*[@href='#disable-reports']";
	private static String formNameInputInactiveTable = "//table[@id='inspection_items_table_inactive']/tbody/tr[1]/td[1]";
	private static String formInputMandatoryInInactiveTable = "//table[@id='inspection_items_table_inactive']/tbody/tr[1]/td[7]";
	private static String optionalMandatorySwitch = "//label[@for='switch_mandatory-create']";
	private static String radioButton = "create-radio";
	private static String checkboxButton = "create-checkbox";
	private static String dropdownButton = "create-dropdown";
	private static String dateButton = "create-date";
	private static String radioOption1 = "option_1-create";
	private static String radioOption2 = "option_2-create";
	private static String publicUrlDropdown = "//*[@id='createInspectionMenu']/div/div[4]/div/div/ul/li[2]/ul";
	private static String addNewElement = "new-entry-btn";
	private static String emailButton = "create-email";
	private static String emailName = "section-create";
	private static String emailPlaceholder = "placeholder-create";
	private static String formPartsAddNewButton = "//html/body/div[3]/div/div[1]/div/button" ;
	private static String ActiveInactiveToggle = "//html/body/div[3]/div/div[6]/div/div[1]/div[2]/div[2]/label" ;

	private static String formPartsSaveButton = "//*[@id=\"form_part-create\"]/div[3]/button" ;
	private static String formPartsNameField = "//*[@id=\"form_part-name\"]" ;
	private static String radioButtonName = "section-create";
	private static String dateName = "section-create";
	private static String datePlaceholder = "placeholder-create";

	private static String checkboxOption1 = "option_1-create";
	private static String checkboxOption2 = "option_2-create";
	private static String checkboxName = "section-create";

	private static String dropdownPlaceholder = "placeholder-create";

	private static String dropdownOption1 = "option_1-create";
	private static String dropdownOption2 = "option_2-create";
	private static String dropdownName = "section-create";

	private static String imageButton = "create-image";
	private static String imageName = "section-create";
	private static String signatureButton = "create-signature";
	private static String signatureName = "section-create";
	private static String signaturePlaceholder = "placeholder-create";
	private static String sectionButton = "create-section";
	private static String sectionName = "section-create";
	private static String referenceButton = "create-reference";
	private static String referencePlaceholder = "placeholder-create";
	private static String referenceName = "section-create";
	private static String locationButton = "create-location";
	private static String locationPlaceholder = "placeholder-create";
	private static String locationName = "section-create";






	public static String getAddNewFormButton() {
		return addNewFormButton;
	}
	public static String getFormName() {
		return formName;
	}
	public static String getTextareaName() { return textareaName;}
	public static String getTextareaPlaceholder() { return textareaPlaceholder;}
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
	public static String getSaveButton() { return saveButton; }
	public static String getAboveAlert() {
		return aboveAlert;
	}
	public static String getFormInspectionTitle() {
		return formInspectionTitle;
	}
	public static String getSearchBar() {
		return searchBar ;
	}
	public static String getInspectionInTable() {
		return inspectionInTable ;
	}
	public static String getInspectionNameRedirect() {
		return inspectionNameRedirect ;
	}
	public static String getStagingGuidanceDropdown() {
		return stagingGuidanceDropdown ;
	}
	public static String getEditFormButton() {
		return editFormButton;
	}
	public static String getInputButton() {
		return inputButton;
	}
	public static String getFormInputPlaceholder() {
		return formInputPlaceholder;
	}
	public static String getFormInputSaveButton() {
		return formInputSaveButton;
	}
	public static String getFormNameInputInActiveTable() {
		return formNameInputInActiveTable;
	}
	public static String getFormInputMandatoryInActiveTable() {
		return formInputMandatoryInActiveTable;
	}
	public static String getTextareaButton() {
		return textareaButton;
	}
	public static String getInactiveFormTab() {
		return inactiveFormTab;
	}
	public static String getActiveFormSwitch() {
		return activeFormSwitch;
	}
	public static String getFormNameInputInactiveTable() {
		return formNameInputInactiveTable;
	}
	public static String getFormInputMandatoryInInactiveTable() {
		return formInputMandatoryInInactiveTable;
	}
	public static String getOptionalMandatorySwitch() {
		return optionalMandatorySwitch;
	}
	public static String getRadioButton() {
		return radioButton;
	}
	public static String getDateButton() {
		return dateButton;
	}
	public static String getRadioOption1() {
		return radioOption1;
	}
	public static String getRadioOption2() {
		return radioOption2;
	}
	public static String getPublicUrlDropdown() {
		return publicUrlDropdown;
	}
	public static String getActiveFormTab() {
		return activeFormTab;
	}
	public static String getCheckboxButton() {
		return checkboxButton;
	}
	public static String getDropdownButton() {
		return dropdownButton;
	}

	public static String getFormPartsSaveButton() { return formPartsSaveButton; }
	public static String getFormPartsNameField() { return formPartsNameField; }
	public static String getFormPartsAddNewButton() { return formPartsAddNewButton; }
	public static String getRadioButtonName() { return radioButtonName; }
	public static String getDateName() { return dateName;}
	public static String getDatePlaceholder() {return datePlaceholder;}
	public static String getCheckboxName() { return checkboxName; }
	public static String getCheckboxOption1() { return checkboxOption1;}
	public static String getCheckboxOption2() {return checkboxOption2;}

	public static String getDropdownPlaceholder() {return dropdownPlaceholder;}
	public static String getDropdownName() { return dropdownName; }
	public static String getDropdownOption1() { return dropdownOption1;}
	public static String getDropdownOption2() {return dropdownOption2;}
	public static String getEmailName() {return emailName;}
	public static String getEmailPlaceholder() { return emailPlaceholder;}
	public static String getImageButton() { return imageButton;}
	public static String getEmailButton() { return emailButton;}
	public static String getSignatureButton() { return signatureButton;}
	public static String getReferenceButton() { return referenceButton;}
	public static String getSectionButton() { return sectionButton;}
	public static String getLocationButton() { return locationButton;}
	public static String getLocationName() { return locationName;}
	public static String getLocationPlaceholder() {return locationPlaceholder;}
	public static String getReferenceName() { return referenceName;}
	public static String getReferencePlaceholder() {return referencePlaceholder;}
	public static String getImageName() {return imageName;}
	public static String getSectionName() {return sectionName;}
	public static String getSignatureName() { return signatureName;}
	public static String getSignaturePlaceholder() {return signaturePlaceholder;}
	public static String getActiveInactiveToggle() {return ActiveInactiveToggle;}

}
