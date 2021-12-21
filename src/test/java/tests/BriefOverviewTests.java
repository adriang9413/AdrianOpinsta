package tests;

import org.testng.annotations.Test;
import utils.Configuration;
import utils.Setup;

import java.io.IOException;

public class BriefOverviewTests extends Setup {

    private String title;

    {
        try {
            title = Configuration.getBriefTitle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1) //Assert error messages?
    public void SAM608_createStandardBrief() throws Exception {
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        briefOverviewStepObject.accessBriefOverviewPage();
        briefOverviewStepObject.createNewBrief();
        briefOverviewStepObject.launchBrief();
        briefOverviewStepObject.completeMandatoryFields(title, BriefCategoryTests.categoryName1, BriefGroupTests.groupName, Configuration.getBriefDetails1(), Configuration.getBriefDate1());
        briefOverviewStepObject.launchBrief();
        assertionOnSamStepObject.assertBriefCreated(title);
    }

    @Test(priority = 2)
    public void SAM611_editStandardBrief() throws Exception {
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        briefOverviewStepObject.accessBriefOverviewPage();
        Thread.sleep(1000);
        briefOverviewStepObject.selectBrief(title);
        briefOverviewStepObject.editBrief();
        briefOverviewStepObject.editBriefCategoryAndDate(Configuration.getBriefCategory2Name(), Configuration.getBriefDate2());
        briefOverviewStepObject.updateBrief();
        briefOverviewStepObject.editBrief();
        briefOverviewStepObject.editBriefDescription(Configuration.getBriefDetails2());
        briefOverviewStepObject.previewBrief();
        briefOverviewStepObject.closePreview();
        briefOverviewStepObject.updateBrief();
       // assertionOnSamStepObject.assertBriefUpdate(Configuration.getBriefVersion());
    }


    @Test (priority = 3)
    public void SAM900_assignToBrief() throws Exception{
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        briefOverviewStepObject.accessBriefOverviewPage();
        Thread.sleep(1000);
        briefOverviewStepObject.selectBrief(title);
        briefOverviewStepObject.addUserToBriefAudience(Configuration.getBriefNewUser());
        assertionOnSamStepObject.assertUserAddedToBrief(Configuration.getBriefNewUser());
    }

    @Test (priority = 4)
    public void SAM1115_removeFromBrief() throws Exception{
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        briefOverviewStepObject.accessBriefOverviewPage();
        Thread.sleep(1000);
        briefOverviewStepObject.selectBrief(title);
        briefOverviewStepObject.removeUserFromBriefAudience();
        assertionOnSamStepObject.assertUserRemovedBrief(Configuration.getBriefNewUser());
    }

    @Test (priority = 5)
    public void SAM1034_rateBrief() throws Exception{
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        briefOverviewStepObject.accessBriefOverviewPage();
        Thread.sleep(1000);
        briefOverviewStepObject.selectBrief(title);
        Thread.sleep(2000);
        briefOverviewStepObject.viewAndRateBrief();
        Thread.sleep(2000);
        assertionOnSamStepObject.assertBriefReadAndRated(Configuration.getPercentage());
    }
}
