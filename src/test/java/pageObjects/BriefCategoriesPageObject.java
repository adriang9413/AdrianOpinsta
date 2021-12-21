package pageObjects;

public class BriefCategoriesPageObject {

    private static String addCategoryButton = "//*[@dt-at='addCategoryButton']";
    private static String inputCategoryName = "//*[@dt-at='inputCategoryName']";
    private static String deadlineField = "//*[@dt-at='deadlineField']";
    private static String inputCritical = "//*[@dt-at='inputCritical']";
    private static String criticalDropdown = "//*[@dt-at='criticalDropdown']";
    private static String createCategoryButton = "create_category-btn";
    private static String searchBar = "input-search-form";
    private static String categoryName = "//tr[1]/td[1]";

    public static String getAddCategoryButton(){
        return addCategoryButton;
    }

    public static String getInputCategoryName() {
        return inputCategoryName;
    }

    public static String getDeadlineField(){
        return deadlineField;
    }

    public static String getInputCritical(){
        return inputCritical;
    }

    public static String getCriticalDropdown(){
        return criticalDropdown;
    }

    public static String getCreateCategoryButton(){
        return createCategoryButton;
    }

    public static String getSearchBar(){
        return searchBar;
    }

    public static String getCategoryName(){
        return categoryName;
    }

}
