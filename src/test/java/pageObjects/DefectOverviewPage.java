package pageObjects;

public class DefectOverviewPage {
	private static String myProfilePageSectionTitle = "//*[@dt-at='myProfilePageSectionTitle']";
	private static String defectOverviewSubtitle = "//div[contains(@class,'container-fluid')]/div/div[3]/ul/li[2]";
	
	public static String getMyProfilePageSectionTitle() {
		return myProfilePageSectionTitle;
	}
	public static String getDefectOverviewSubtitle() {
		return defectOverviewSubtitle;
	}

}
