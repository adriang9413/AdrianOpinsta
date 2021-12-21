package pageObjects;

public class ManageContractorsPageObject {
    private static String setupButton = "//*[text()[contains(.,'Setup')]]";
    private static String contractorsButton = "//span[contains(text(),'Contractors')]";
    		//"//*[@href=\"https://sam.opinsta.com/dashboard/manage/contractors\"]";
    private static String addNewContractor = "new-entry-btn";
    private static String contractorName = "//*[@class='form-input ']//*[@dt-name='name']";
    private static String contractorEmail = "//*[@class='form-input ']//*[@dt-name='email']";
    private static String contractorPhone = "//*[@class='form-input ']//*[@dt-name='phone']";
    private static String contractorSpeciality = "speciality-input";
    		//"//*[@id='spec-app']//*[@id='speciality-input']";
    private static String saveButton = "//*[@class='button-custom btn-positive']";
    private static String tooltip = "above--alert";
	private static String contractorSearchBar = "input-search-form";
	private static String contractorInTable = "//td[contains(text(),'%s')]";

    public static String getSetupButton() {
        return setupButton;
    }
    public static String getContractorsButton() {
        return contractorsButton;
    }
    public static String getAddNewContractor() {
        return addNewContractor;
    }
    public static String getContractorName() {
        return contractorName;
    }
    public static String getContractorEmail() {
        return contractorEmail;
    }
    public static String getContractorPhone() {
        return contractorPhone;
    }
    public static String getContractorSpeciality() {
        return contractorSpeciality;
    }
    public static String getSaveButton() {
        return saveButton;
    }
    public static String getAlertAbove() {
        return tooltip;
    }
	public static String getContractorSearchBar() {
		return contractorSearchBar ;
	}
	public static String getContractorInTable() {
		return contractorInTable ;
	}
}
