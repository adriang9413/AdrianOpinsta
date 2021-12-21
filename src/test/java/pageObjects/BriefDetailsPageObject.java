package pageObjects;

public class BriefDetailsPageObject {

    private static String briefTitle = "brief_details--name";
    private static String briefVersion = "brief_details--issue_number";
    private static String threeDots = "comm_details-popover";
    private static String updateButton = "update_brief-btn";
    private static String manageDistribution = "manage_distribution-btn";
    private static String newUser = "//tbody/tr[2]/td[1]";
    private static String audienceUser = "//*[@id='brief_details_table--default']/tbody/tr[1]/td[1]";
    private static String viewButtonBrief = "//*[@dt-at='viewButtonBrief']";
    private static String closeButtonBrief = "//*[@dt-at='closeButtonBrief']";
    private static String confirmReadButtonBrief = "//*[@dt-at='confirmReadButtonBrief']";
    private static String oneStarRating = "//*[@dt-star='1']";
    private static String confirmRatingButton = "modal-confirm_read--btn";
    private static String completionPercentage = "brief_details--completed_percentage-header";
    private static String audience = "//*[@class='container-box']/div[2]/div[2]/div";

    public static String getBriefTitle() {
        return briefTitle;
    }

    public static String getThreeDots() {
        return threeDots;
    }

    public static String getUpdateButton() {
        return updateButton;
    }

    public static String getBriefVersion() {
        return briefVersion;
    }

    public static String getManageDistribution() {
        return manageDistribution;
    }

    public static String getNewUser() {
        return newUser;
    }

    public static String getAudienceUser() {
        return audienceUser;
    }

    public static String getViewButtonBrief() {
        return viewButtonBrief;
    }

    public static String getCloseButtonBrief() {
        return closeButtonBrief;
    }

    public static String getConfirmReadButtonBrief() {
        return confirmReadButtonBrief;
    }

    public static String getOneStarRating() {
        return oneStarRating;
    }

    public static String getConfirmRatingButton() {
        return confirmRatingButton;
    }

    public static String getCompletionPercentage() {
        return completionPercentage;
    }

    public static String getAudience() {
        return audience;
    }
}
