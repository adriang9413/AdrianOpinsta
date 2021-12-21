package pageObjects;

public class CalendarWorkOrderFormPageObject {
	private static String addDefectReport = "defect_reports--input";
	private static String searchDefectReportBar = "input-search-form";
	private static String defectReportCheckbox = "//*[@dt-at='defectReportCheckbox']";
	private static String referenceInTableReport = "//table[@id='table-items']/tbody/tr/td[contains(., '%s')]/../td[2]";
	private static String referenceInPopUp = "//div[@id='defect_reports_list']/div/div";
	private static String allTypeDefectReports = "//table[@id='table-items']/tbody/tr/td[3]";
	private static String addWorkOrderButton ="add_work_oder_reports-btn";
	private static String removeDefectReportWO="//*[@dt-at='removeDefectReportWO']";
	private static String allCheckboxesDefectReports ="//div[@class='btn-checkbox wo_reports_check--input']/span[1]";
	private static String allReferencesDefectReports = "//div[@class='btn-checkbox wo_reports_check--input']/span[1]/../../following-sibling::td[1]";
	private static String nextPageDefectReport = "//li[@id='table-items_next']/a";
	private static String previousPageDefectReport = "//li[@id='table-items_previous']/a";
	private static String allReportsTitle = "//*[@dt-at='allReportsTitle']";
	
	public static String getAddDefectReport() {
		return addDefectReport;
	}

	public static String getSearchDefectReportBar() {
		return searchDefectReportBar;
	}

	public static String getDefectReportCheckbox() {
		return defectReportCheckbox;
	}

	public static String getAllTypeDefectReports() {
		return allTypeDefectReports;
	}

	public static String getAddWorkOrderButton() {
		return addWorkOrderButton;
	}

	public static String getReferenceInTableReport() {
		return referenceInTableReport;
	}

	public static String getReferenceInPopUp() {
		return referenceInPopUp;
	}

	public static String getRemoveDefectReportWO() {
		return removeDefectReportWO;
	}

	public static String getAllCheckboxesDefectReports() {
		return allCheckboxesDefectReports;
	}

	public static String getNextPageDefectReport() {
		return nextPageDefectReport;
	}

	public static String getPreviousPageDefectReport() {
		return previousPageDefectReport;
	}

	public static String getAllReportsTitle() {
		return allReportsTitle;
	}

	public static String getAllReferencesDefectReports() {
		return allReferencesDefectReports;
	}

}
