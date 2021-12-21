package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class AssetTests extends Setup {
	public static String firstSubcategory = "1stSubAsset";

	@Test(priority = 1, groups = "dependencies")
	public void SAM12_createNewAsset() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		assetStepObject.clickSetupMenu();
		assetStepObject.navigateToAssetPage();
		assetStepObject.addNewAsset(AssetGroupTests.assetGroupName, firstSubcategory);
		assetStepObject.verifyAssetSuccessfullySavedMessage();
		assetStepObject.verifyAssetSaved(firstSubcategory);
	}

//	@Test(priority = 2)
//	public void createAssetWithoutMandatoryFields() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		assetStepObject.addAssetWithoutMandatoryFields();
//		assetStepObject.verifyAssetMandatoryFilds();
//	}
//
//	@Test(priority = 3)
//	public void cancelCreateAsset() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		assetStepObject.cancelCreatingAsset(assetGroupName, cancelFirstSubcat);
//		assetStepObject.verifyAssetNotSaved(cancelFirstSubcat);
//
//	}
//
//	public void editAsset() throws Exception {
//	}

}
