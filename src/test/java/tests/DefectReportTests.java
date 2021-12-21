package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class DefectReportTests extends Setup {
	public static String defectReportIdentifier;
	public String description = "Test";
	public String status = "Closed";

	@Test (priority = 1, groups = "smoke")
	public void SAM19_createElements() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		defectOverviewStepObject.accessDefectTemplates();
		defectOverviewStepObject.searchForTemplate(AssetGroupTests.assetGroupName);
		defectOverviewStepObject.selectFirstTemplate();
		assertionOnSamStepObject.assertNoMoreActiveElements("No data available in table");
		defectOverviewStepObject.addNewElement("checkbox");
		defectOverviewStepObject.addExtraOptions(3);
		defectOverviewStepObject.completeCheckboxOptionFields("thomyTest", new String[] {"op1","op2","op3", "op4", "op5"});
		defectOverviewStepObject.saveElement();
		defectOverviewStepObject.previewAndCloseTemplate();
	}

	@Test(priority = 2, groups = "smoke")
	public void SAM22_createReport() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		defectOverviewStepObject.createReport(AssetGroupTests.assetGroupName, AssetTests.firstSubcategory, ProblemTests.firstLevel);
		defectOverviewStepObject.verifyReportCreated();
		defectReportIdentifier = defectOverviewStepObject.getActualReportIdentifier();
		defectOverviewStepObject.verifyAllFields(AssetGroupTests.assetGroupName,AssetTests.firstSubcategory,ProblemTests.firstLevel);
	}

	@Test (priority = 3, groups = "smoke")
	public void SAM20_editReport() throws Exception{
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		defectOverviewStepObject.accessDefectTemplates();
		defectOverviewStepObject.searchForTemplate(AssetGroupTests.assetGroupName);
		defectOverviewStepObject.selectFirstTemplate();
		defectOverviewStepObject.modifyElementsActiveStatus();
		assertionOnSamStepObject.assertNoMoreActiveElements("No data available in table");
		defectOverviewStepObject.modifyElementsInactiveStatus();
		assertionOnSamStepObject.assertNoMoreInactiveElements("No data available in table");
	}

//	@Test(priority = 3, groups = "smoke")
//	public void SAM_449() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		defectOverviewStepObject.createReport(assetGroupName, assetFirstSubcat, problemFirstLevel);
//		Thread.sleep(500);
//		defectOverviewStepObject.verifyReportCreated();
//		defectOverviewStepObject.verifyReportFields(assetGroupName, assetFirstSubcat, problemFirstLevel);
//		// update image
//		defectOverviewStepObject.editReportAddSupportingImage();
//		Thread.sleep(2500);
//		defectOverviewStepObject.verifyImageAddedToReport();
//		// update contractor
//		defectOverviewStepObject.editReportAddContractor(contractorName, description);
//		Thread.sleep(2500);
//		defectOverviewStepObject.verifyContractorAddedToReport(contractorName);
//		// update status
//		defectOverviewStepObject.editReportChangeStatus(status, description);
//		Thread.sleep(1500);
//		defectOverviewStepObject.verifyStatusChanged(status);
//	}
	
	@Test(priority = 4, groups = "smoke")
	public void SAM104_updateStatus() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		defectOverviewStepObject.clickDefectOverviewMenu();
		defectOverviewStepObject.accessExistingDefectReport(defectReportIdentifier);
		defectOverviewStepObject.editReportChangeStatus(status, description);
		defectOverviewStepObject.verifyStatusChanged(status);
	}
}
