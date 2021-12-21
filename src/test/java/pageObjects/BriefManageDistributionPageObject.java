package pageObjects;

public class BriefManageDistributionPageObject {

    private static String groupInsert = "//div[3]/div/div[6]/div[2]/div/div/div[1]/div[1]/div/span/input";
    private static String groupSelect = "//div[3]/div/div[6]/div[2]/div/div/div[1]/div[1]/div/span/select";
    private static String userInsert = "//div[3]/div/div[6]/div[2]/div/div/div[1]/div[2]/div/span/input";
    private static String userSelect = "//div[3]/div/div[6]/div[2]/div/div/div[1]/div[2]/div/span/select";
    private static String confirmButton = "//div[3]/div/div[6]/div[1]/div[3]/div/button";
    private static String removeFirstUserButton = "//div[@class='container-box']/div[2]/div[2]/div[1]/div[1]/div[3]//i";


    public static String getGroupInsert() {
        return groupInsert;
    }

    public static String getGroupSelect() {
        return groupSelect;
    }

    public static String getUserInsert() {
        return userInsert;
    }

    public static String getUserSelect() {
        return userSelect;
    }

    public static String getConfirmButton() {
        return confirmButton;
    }

    public static String getRemoveFirstUserButton() {
        return removeFirstUserButton;
    }
}
