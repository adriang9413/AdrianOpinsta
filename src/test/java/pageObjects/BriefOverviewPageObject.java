package pageObjects;

public class BriefOverviewPageObject {

    private static String addBriefButton = "//*[@dt-at='addBriefButton']";
    private static String briefTitleSearchBar = "input-search_submissions_overview_table";
    private static String briefFromTable = "//*[@dt-at='briefFromTable']";

    public static String getAddBriefButton(){
        return addBriefButton;
    }

    public static String getBriefTitleSearchBar() {
        return briefTitleSearchBar;
    }

    public static String getBriefFromTable() {
        return briefFromTable;
    }
}
