package pageObjects;

public class BriefCreatePageObject {

    private static String previewButtonBrief = "//div[3]/div/div[5]/div[1]/div[3]/div/button[1]"/*!!!*/;
    private static String launchBriefButton = "create_comm-btn";
    private static String updateBriefButton = "update_comm-btn";
    private static String insertTitleBrief = "//*[@dt-at='insertTitleBrief']";
    private static String inputCategoryBrief = "//*[@dt-at='inputCategoryBrief']";
    private static String categoryDropdownBrief = "//*[@dt-at='categoryDropdownBrief']";
    private static String inputGroupBrief = "//*[@dt-at='inputGroupBrief']";
    private static String groupDropdownBrief = "//*[@dt-at='groupDropdownBrief']";
    private static String inputUserBrief = "//*[@dt-at='inputUserBrief']";
    private static String userDropdownBrief = "//*[@dt-at='userDropdownBrief']";
    private static String insertBriefDetails = "//*[@id='brief_type--1']/textarea"/*!!!*/;
    private static String inputDate = "datetimepicker";
    private static String briefTitleSearchBar = "input-search_submissions_overview_table";
    private static String briefFromTable = "//*[@id='submissions_overview_table']/tbody/tr[1]";
    private static String closePreviewButtonBrief = "//*[@class='container']/div[2]/div/button"/*!!!*/;

    public static String getLaunchBriefButton() {
        return launchBriefButton;
    }

    public static String getInsertTitleBrief(){
        return insertTitleBrief;
    }

    public static String getInputCategoryBrief() {
        return inputCategoryBrief;
    }

    public static String getCategoryDropdownBrief() {
        return categoryDropdownBrief;
    }

    public static String getInputGroupBrief() {
        return inputGroupBrief;
    }

    public static String getGroupDropdownBrief() {
        return groupDropdownBrief;
    }

    public static String getInputUserBrief() {
        return inputUserBrief;
    }

    public static String getUserDropdownBrief() {
        return userDropdownBrief;
    }

    public static String getInsertBriefDetails() {
        return insertBriefDetails;
    }

    public static String getInputDate() {
        return inputDate;
    }

    public static String getBriefTitleSearchBar() {
        return briefTitleSearchBar;
    }

    public static String getBriefFromTable() {
        return briefFromTable;
    }

    public static String getUpdateBriefButton() {
        return updateBriefButton;
    }

    public static String getPreviewButtonBrief() {
        return previewButtonBrief;
    }

    public static String getClosePreviewButtonBrief() {
        return closePreviewButtonBrief;
    }
}
