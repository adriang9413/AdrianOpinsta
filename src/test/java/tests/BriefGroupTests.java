package tests;

import utils.Setup;
import org.testng.annotations.Test;
import utils.Configuration;

import java.io.IOException;

public class BriefGroupTests extends Setup {

    public static String groupName;

    {
        try {
            groupName = Configuration.getBriefGroupName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 1)
    public void SAM591_addGroup() throws Exception{
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        briefGroupObject.accessGroupPage();
        briefGroupObject.addNewGroup(groupName, Configuration.getBriefGroupUser());
        assertionOnSamStepObject.assertBriefGroupCreated(groupName);
    }

}
