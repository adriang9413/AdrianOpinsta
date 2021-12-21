package pageObjects;

public class BriefGroupPageObject {

    private static String addGroupButton = "//*[@dt-at='addGroupButton']";
    private static String inputGroupName = "//*[@dt-at='inputGroupName']";
    private static String inputUser = "//*[@id='modal_manage--group_form']/div[2]/div[2]/div/div/input[1]";/*!!!*/
    private static String userDropdown = "//*[@dt-at='userDropdown']";
    private static String createGroupButton = "create_group-btn";
    private static String searchBar = "input-search-form";
    private static String groupName = "//*[@id='groups_active_table']/tbody/tr/td";


    public static String getAddGroupButton(){
        return addGroupButton;
    }

    public static String getInputGroupName() {
        return inputGroupName;
    }

    public static String getInputUser(){
        return inputUser;
    }

    public static String getUserDropdown(){
        return userDropdown;
    }

    public static String getCreateGroupButton(){
        return createGroupButton;
    }

    public static String getSearchBar(){
        return searchBar;
    }

    public static String getGroupName(){
        return groupName;
    }

}
