package pageObjects;

public class DefectOverviewPageObject {
	private static String createReportButton = "//*[@dt-at='createReportButton']";
	private static String selectAssetGroupField = "//*[@dt-at='selectAssetGroupField']";
	private static String assetGroupDropdown = "//div[@id='asset_type-modal']/div/div/select[@class='select-item-name']";
	private static String listOfAssetGroups = "//*[@dt-at='listOfAssetGroups']";
	private static String listOfSubCat1 = "//*[@id='asset_type1-modal']/div/div/div/ul/li[2]/ul";
	private static String listOfProblems = "//*[@dt-at='listOfProblems']";
	private static String firstSubcategoryDropdown = "//div[@id='asset_type1-modal']/div/div/select";
	private static String problemDropdown = "//div[@id='problem_type1-modal']/div/div/select";
	private static String saveCreateReportButton = "submit_button-modal";
	private static String selectFirstSubcategoryField = "//*[@id='asset_type1-modal']/div/div/div/input[1]";/*!!!*/
	private static String assetBox2 = "//div[@id='asset_type2-modal']//input";
	private static String assetBox3 = "//div[@id='asset_type3-modal']//input";
	private static String selectProblemField = "//*[@dt-at='selectProblemField']";
	private static String checkboxOption1 = "//*[@id='preview_report-modal_content']/div[1]/div[1]/div[1]/span";
	private static String reportDetailsTitle = "//div[@class='d-flex page-title']";
	private static String defectReportReference = "//div/span[@class='reference-report_details']";
	private static String continueReportButton = "//*[@dt-at='continueReportButton']";
	private static String defectReportIdentifier = "//div[@class='container-fluid']/div[2]/div[1]/span";
	private static String defectReportAssetGroup = "report_type_name";
	private static String defectReportAsset = "//div[@id='asset_details_report_info']//p";
	private static String defectReportProblem = "//div[@id='problem_info_report_details']//p";
	private static String viewMoreButton = "view-more_less_button";
	private static String viewMoreLessLabel = "//a[@id='view-more_less_button']/div";
	private static String defectReportsActionsButton = "report_actions";
	private static String editReportButton = "edit-report-action";
	private static String addPhotoButton = "//input[@id='#supporting-images-input']";
	private static String uploadedFileName = "//span[@class='attach-text']";
	private static String uploadButton = "update_button-modal";
	private static String defectReportImageRightButton = "//button[@class='view-btn icon-image']";
	private static String enlargeButton = "//a[@class='enlarge-photo icon-enlrage']";
	private static String closeImageButton = "//div[@id='display-supp-images-col']//button[@type='button']//span";
	private static String imageRight = "//img[@class='itm-found_img']";
	private static String actionsChangeContractor = "//div[@id='report_actions_list']//div[contains(., 'Change Contractor')]";
	private static String searchContractor = "contractor-search";
	private static String selectContractor = "//div[@class='main-data'][contains(.,'%s')]";
	private static String updateContractorButton = "//button[contains(text(),'Update')]";
	private static String contractorRightButton = "//button[@class='view-btn icon-audit']";
	private static String contractorNameRight = "contractor_name-report_details";
	private static String closeContractorRightButton = "//div[@id='display-contractor-col']//button/span";
	private static String descriptionContractor = "description-change_contractor";
	private static String updateStatusButton = "//div[@id='report_actions_list']/div[contains(.,'Update Status')]";
	private static String updateStatusField = "type-update_report";
	private static String updateStatusDropdownReport = "//*[@dt-at='updateStatusDropdownReport']";
	private static String updateStatusDescription = "description-update_report";
	private static String saveStatusButton = "//button[contains(text(),'Save')]";
	private static String statusInReport = "//p[@id='status-report_details']/b";
	private static String assetGroupName = "//ul[@class='select-dropdown--options op-scrollbar']//li//span";
	private static String defectsSearchBar = "input-search-form";
	private static String firstDefectReport = "//tbody/tr[1]/td[1]";
	private static String inputMandatoryField = "input_649";
	private static String editMandatoryField = "//*[@id='preview_report-modal_content']/div/div/input";
	private static String updateEditedReportButton = "update_button-modal";
	private static String confirmDefectReportUpdatedAlert = "above--alert";
	private static String elementEditButton = "//*[@class='icon-edit']";
	private static String activateButton = "//*[@id='details-itm']/div[1]/div[3]/div[1]";
	private static String updateElementButton = "update_report";
	private static String templates = "//tbody/tr/td[1]";
	private static String activeElements = "//table[@id='table-active-reports']/tbody/tr[1]";
	private static String inactiveElements = "//table[@id='table-disable-reports']/tbody/tr[1]";
	private static String activeElementsTabTemplateReports = "//*[@href='#active-reports']";/*!!!*/
	private static String inactiveElementsTabTemplateReports = "//*[@href='#disable-reports']";/*!!!*/
	private static String mainTable = "main-table";
	private static String assetGroupActiveTable = "table-active-reports";
	private static String assetGroupInactiveTable = "table-disable-reports";
	private static String activeTableContent = "//*[@id='table-active-reports']/tbody/tr/td";
	private static String inactiveTableContent = "//*[@id='table-disable-reports']/tbody/tr/td";
	private static String templateSearchBar = "input-search-form";
	private static String editTemplateButton = "//table[@id='main-table']/tbody/tr[1]/td[5]/button";
	private static String addNewElement = "new-entry-btn";
	private static String previewForm = "preview-report-btn";
	private static String selectCheckbox = "create-checkbox";
	private static String sectionNameFieldAddNewReport = "//*[@dt-at='sectionNameFieldAddNewReport']";
	private static String addNewOptionButton = "btn-add-new-option";
	private static String checkboxOptionFields = "//*[@id='col-options']/div/input";
	private static String saveElement = "btn-save-created_report";
	private static String elementCloseButton = "close-btn";
	private static String closePreviewButtonReport = "//*[@dt-at='closePreviewButtonReport']";

	public static String getCreateReportButton() {
		return createReportButton;
	}

	public static String getSelectAssetGroupField() {
		return selectAssetGroupField;
	}

	public static String getAssetGroupDropdown() {
		return assetGroupDropdown;
	}

	public static String getFirstSubcategoryDropdown() {
		return firstSubcategoryDropdown;
	}

	public static String getProblemDropdown() {
		return problemDropdown;
	}

	public static String getSaveCreateReportButton() {
		return saveCreateReportButton;
	}

	public static String getSelectFirstSubcategoryField() {
		return selectFirstSubcategoryField;
	}

	public static String getSelectProblemField() {
		return selectProblemField;
	}

	public static String getReportDetailsTitle() {
		return reportDetailsTitle;
	}

	public static String getDefectReportAssetGroup() {
		return defectReportAssetGroup;
	}

	public static String getDefectReprtAsset() {
		return defectReportAsset;
	}

	public static String getDefectReportProblem() {
		return defectReportProblem;
	}

	public static String getViewMoreButton() {
		return viewMoreButton;
	}

	public static String getDefectReportsActionsButton() {
		return defectReportsActionsButton;
	}

	public static String getEditReportButton() {
		return editReportButton;
	}

	public static String getAddPhotoButton() {
		return addPhotoButton;
	}

	public static String getUploadedFileName() {
		return uploadedFileName;
	}

	public static String getUploadButton() {
		return uploadButton;
	}

	public static String getDefectReportImageRightButton() {
		return defectReportImageRightButton;
	}

	public static String getEnlargeButton() {
		return enlargeButton;
	}

	public static String getCloseImageButton() {
		return closeImageButton;
	}

	public static String getImageRight() {
		return imageRight;
	}

	public static String getActionsChangeContractor() {
		return actionsChangeContractor;
	}

	public static String getSearchContractor() {
		return searchContractor;
	}

	public static String getSelectContractor() {
		return selectContractor;
	}

	public static String getUpdateContractorButton() {
		return updateContractorButton;
	}

	public static String getContractorRightButton() {
		return contractorRightButton;
	}

	public static String getContractorNameRight() {
		return contractorNameRight;
	}

	public static String getCloseContractorRightButton() {
		return closeContractorRightButton;
	}

	public static String getDescriptionContractor() {
		return descriptionContractor;
	}

	public static String getUpdateStatusButton() {
		return updateStatusButton;
	}

	public static String getUpdateStatusField() {
		return updateStatusField;
	}

	public static String getUpdateStatusDropdownReport() {
		return updateStatusDropdownReport;
	}

	public static String getUpdateStatusDescription() {
		return updateStatusDescription;
	}

	public static String getSaveStatusButton() {
		return saveStatusButton;
	}

	public static String getViewMoreLessLabel() {
		return viewMoreLessLabel;
	}

	public static String getStatusInReport() {
		return statusInReport;
	}

	public static String getAssetGroupName() {
		return assetGroupName ;
	}

	public static String getContinueReportButton() {
		return continueReportButton;
	}

	public static String getAssetBox2() {
		return assetBox2;
	}

	public static String getAssetBox3() {
		return assetBox3;
	}

	public static String getDefectsSearchBar() {
		return defectsSearchBar;
	}

	public static String getFirstDefectReport() {
		return firstDefectReport;
	}

	public static String getDefectReportReference() {
		return defectReportReference;
	}

	public static String getInputMandatoryField() {
		return inputMandatoryField;
	}

	public static String getEditMandatoryField() {
		return editMandatoryField;
	}

	public static String getUpdateEditedReportButton() {
		return updateEditedReportButton;
	}

	public static String getConfirmDefectReportUpdatedAlert() {
		return confirmDefectReportUpdatedAlert;
	}

	public static String getElementEditButton() {
		return elementEditButton;
	}

	public static String getActivateButton() {
		return activateButton;
	}

	public static String getUpdateElementButton() {
		return updateElementButton;
	}

	public static String getInactiveElementsTabTemplateReports() {
		return inactiveElementsTabTemplateReports;
	}

	public static String getActiveElements() {
		return activeElements;
	}

	public static String getTemplates() {
		return templates;
	}

	public static String getMainTable() {
		return mainTable;
	}

	public static String getAssetGroupActiveTable() {
		return assetGroupActiveTable;
	}

	public static String getActiveTableContent() {
		return activeTableContent;
	}

	public static String getInactiveTableContent() {
		return inactiveTableContent;
	}

	public static String getActiveElementsTabTemplateReports() {
		return activeElementsTabTemplateReports;
	}

	public static String getAssetGroupInactiveTable() {
		return assetGroupInactiveTable;
	}

	public static String getInactiveElements() {
		return inactiveElements;
	}

	public static String getTemplateSearchBar() {
		return templateSearchBar;
	}

	public static String getEditTemplateButton() {
		return editTemplateButton;
	}

	public static String getAddNewElement() {
		return addNewElement;
	}

	public static String getPreviewForm() {
		return previewForm;
	}

	public static String getSelectCheckbox() {
		return selectCheckbox;
	}

	public static String getSectionNameFieldAddNewReport() {
		return sectionNameFieldAddNewReport;
	}

	public static String getAddNewOptionButton() {
		return addNewOptionButton;
	}

	public static String getCheckboxOptionFields() {
		return checkboxOptionFields;
	}

	public static String getClosePreviewButtonReport() {
		return closePreviewButtonReport;
	}

	public static String getSaveElement() {
		return saveElement;
	}

	public static String getElementCloseButton() {
		return elementCloseButton;
	}

	public static String getListOfAssetGroups() {
		return listOfAssetGroups;
	}

	public static String getListOfSubCat1() {
		return listOfSubCat1;
	}

	public static String getListOfProblems() {
		return listOfProblems;
	}

	public static String getCheckboxOption1() {
		return checkboxOption1;
	}

	public static String getDefectReportIdentifier() {
		return defectReportIdentifier;
	}
}
