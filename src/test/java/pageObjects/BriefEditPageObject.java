package pageObjects;

public class BriefEditPageObject {

    private static String previewButton = "//div[3]/div/div[5]/div[1]/div[3]/div/button[1]";
    private static String launchBriefButton = "create_comm-btn";
    private static String updateBriefButton = "update_comm-btn";
    private static String insertTitle = "//*[@class='container-box']/div[1]/div[1]/div[1]/input";
    private static String editInputCategory = "//*[@class='row']/div/div[@class='container-box']/div[@class='row']/div/div/span/input";
    private static String selectCategory = "//*[@class='row']/div/div[@class='container-box']/div[@class='row']/div/div/span/select";
    private static String insertBriefDetails = "//*[@id='brief_type--1']/textarea";
    private static String inputDate = "datetimepicker";
    private static String briefTitleSearchBar = "input-search_submissions_overview_table";
    private static String briefFromTable = "//*[@id='submissions_overview_table']/tbody/tr[1]";
    private static String closePreviewButton = "//*[@class='container']/div[2]/div/button";

    public static String getLaunchBriefButton() {
        return launchBriefButton;
    }

    public static String getInsertTitle(){
        return insertTitle;
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

    public static String getPreviewButton() {
        return previewButton;
    }

    public static String getClosePreviewButton() {
        return closePreviewButton;
    }

    public static String getEditInputCategory() {
        return editInputCategory;
    }

    public static String getSelectCategory() {
        return selectCategory;
    }
}
