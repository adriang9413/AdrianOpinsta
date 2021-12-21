package pageObjects;

public class LeftSideMenuPageObject {

	private static String defectOverviewButton = "//*[@dt-at='defectOverviewButton']";
	private static String defectSetupButton = "//*[@dt-at='defectSetupButton']";
	private static String defectTemplatesButton = "//*[@dt-at='defectTemplatesButton']";
	private static String defectAssetGroupButton = "//*[@dt-at='defectAssetGroupButton']";
	private static String defectAssetsButton = "//*[@dt-at='defectAssetsButton']";
	private static String defectProblemButton = "//*[@dt-at='defectProblemButton']";
	private static String formOverviewButton = "//*[@dt-at='formOverviewButton']";
	private static String formCategoriesButton = "//*[@dt-at='formCategoriesButton']";
	private static String healthAndSafetyLeftMenu = "//span[contains(text(),'Health & Safety')]";
	private static String inspectionsButton = "//*[@dt-at='inspectionsButton']";
	private static String briefOverviewButton = "//*[@dt-at='briefOverviewButton']";
	private static String briefSetupButton = "//*[@dt-at='briefSetupButton']";
	private static String briefGroupsButton = "//*[@dt-at='briefGroupsButton']";
	private static String briefCategoriesButton = "//*[@dt-at='briefCategoriesButton']";
	private static String calendarButton = "//ul[@class='side-menu--mc']/li[13]/a"/*!!!*/;
	private static String calendarSetupButton = "//ul[@class='side-menu--mc']/li[14]/a";/*!!!*/
	private static String guidanceButton = "//*[@dt-at='guidanceButton']";
	private static String usersButton = "//*[@dt-at='usersButton']";
	private static String logOutButton = "//*[@dt-at='logOutButton']";


	public static String getAssetLeftMenu() {
		return defectAssetsButton;
	}

	public static String getCalendarButton() {
		return calendarButton;
	}

	public static String getGuidanceLeftMenu() {
		return guidanceButton;
	}

	public static String getDefectProblemButton() {
		return defectProblemButton;
	}

	public static String getDefectOverviewButton() {
		return defectOverviewButton;
	}

	public static String getFormsOverviewLeftMenu() {
		return formOverviewButton;
	}

	public static String getFormCategoriesLeftMenu() {
		return formCategoriesButton;
	}

	public static String getHealthAndSafetyLeftMenu() {
		return healthAndSafetyLeftMenu;
	}

	public static String getInspectionsLeftMenu() {
		return inspectionsButton;
	}

	public static String getBriefSetupButton() {
		return briefSetupButton;
	}

	public static String getBriefGroupsButton() {
		return briefGroupsButton;
	}

	public static String getBriefCategoriesButton() {
		return briefCategoriesButton;
	}

	public static String getBriefOverviewButton(){
		return briefOverviewButton;
	}

	public static String getDefectTemplatesButton() {
		return defectTemplatesButton;
	}

	public static String getDefectSetupButton() {
		return defectSetupButton;
	}

	public static String getDefectAssetGroupButton() {
		return defectAssetGroupButton;
	}

	public static String getLogOutButton() {
		return logOutButton;
	}

	public static String getCalendarSetupButton() {
		return calendarSetupButton;
	}

	public static String getUsersButton() {
		return usersButton;
	}
}
