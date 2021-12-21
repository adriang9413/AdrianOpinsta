package tests;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

import java.io.IOException;

public class AssetGroupTests extends Setup {

    public static String assetGroupName;

    {
        try {
            assetGroupName = Configuration.getAssetGroupName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test (priority = 1, groups = "dependencies") //positive test to create an Asset Group
    public void SAM9_addAssetGroup() throws Exception {
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        assetGroupStepObject.navigateToTemplatePage();
        manageStepObject.addNewAssetGroup(assetGroupName);
        assertionOnSamStepObject.assertAssetGroupCreated(assetGroupName);
    }

//    @Test (priority = 2) //edit the asset created in the first test
//    public void PositiveSAM6() throws Exception {
//        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//        //Assert that I am logged in to SAM
//        assertionOnSamStepObject.assertLogin();
//        manageStepObject.editAssetGruop();
//        //Assert that the AG has been updated
//        assertTrue(driver.findElement(By.xpath("//*[text()[contains(.,'3AutomationEdited')]]")).isEnabled());
//    }
//
//    @Test (priority = 3) //negative test to create an Asset Group
//    public void NegativeSAM9() throws Exception {
//        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//        //Assert that I am logged in to SAM
//        //assertTrue(driver.findElement(By.xpath("//*[@class='d-flex page-title']/span")).getText().equals("Overview"));
//        assertionOnSamStepObject.assertLogin();
//        manageStepObject.addNewAssetGroup("");
//        //Assert that the error message has appeared
//        assertTrue(driver.findElement(By.xpath(ManagePageObject.getErrorMessage())).getText().contains("Error!"));
//    }
}
