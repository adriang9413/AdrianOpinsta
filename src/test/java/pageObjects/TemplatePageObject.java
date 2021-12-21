package pageObjects;

public class TemplatePageObject {

    private static String addNewAssetGroupButton = "new-entry-btn";
    private static String nameAssetGroupField = "//*[@id='create-form']/div[2]/input";
    private static String assetGroupSaveButton = "//*[@id='create-form']/div[3]/button";
    private static String searchAssetGroup = "input-search-form";
    private static String firstAssetGroupName = "//*[@id='main-table']/tbody[1]/tr[1]/td[1]";


    public static String getAddNewAssetGroupButton() {
        return addNewAssetGroupButton;
    }

    public static String getNameAssetGroupField() {
        return nameAssetGroupField;
    }

    public static String getAssetGroupSaveButton() {
        return assetGroupSaveButton;
    }

    public static String getSearchAssetGroup() {
        return searchAssetGroup;
    }

    public static String getFirstAssetGroupName() {
        return firstAssetGroupName;
    }
}
