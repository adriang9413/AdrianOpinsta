package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class FormsOverviewAdminUserTests extends Setup {

	private String formCateg = "Inspections";
	private String text = "New Test";
	private String date = "31/12/2021";
	private String url = "Rock FM - It Rocks!";
	public static String formID;
	private String newTextField = "updated";
	private String status = "Closed";
	
	
	@Test(priority = 1, groups = "smoke")
	public void SAM662_createFormWithGuidance() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		formsOverviewStepObject.createNewFormWithGuidance(formCateg, FormCategoriesInspectionsTests.form, text, date, url);
		formsOverviewStepObject.verifyFormWasSubmitted();
		Thread.sleep(2000);
		formsOverviewStepObject.verifyFormDetails(formID);
	}
	
//	@Test(priority = 2, groups = "smoke")
//	public void SAM264_createForm() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		formsOverviewStepObject.createNewForm(formCategory, form, textField);
//		formsOverviewStepObject.verifyFormWasSubmited();
//		Thread.sleep(2000);
//		formsOverviewStepObject.verifyFormDetails();
//	}
//
//	@Test(priority = 3, groups = "smoke")
//	public void SAM264_createFormWithoutMandatoryFields() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		formsOverviewStepObject.createFormWithoutMandatoryField(formCategory, form);
//		formsOverviewStepObject.verifyMandatoryMessageAlert();
//	}

	@Test(priority = 4, groups = "smoke")
	public void SAM392_editFormFields() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		formsOverviewStepObject.navigateToOverviewSection();
		formsOverviewStepObject.selectFormOverviewFromTable(FormCategoriesInspectionsTests.form);
		formsOverviewStepObject.getFormDetails();
		formsOverviewStepObject.clickActionsButton();
		formsOverviewStepObject.clickEditForm();
		formsOverviewStepObject.editTextField(newTextField);
		formsOverviewStepObject.clickSubmitEditFormButton();
		Thread.sleep(2000);
		formsOverviewStepObject.verifyFormDetailsWereUpdated(newTextField);
	}

	@Test(priority = 5, groups = "smoke")
	public void SAM408_editAssignUser() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		formsOverviewStepObject.navigateToOverviewSection();
		formsOverviewStepObject.selectFormOverviewFromTable(FormCategoriesInspectionsTests.form);
		formsOverviewStepObject.clickActionsButton();
		formsOverviewStepObject.clickAssignForm();
		formsOverviewStepObject.assignUser(Configuration.getBriefNewUser());
		formsOverviewStepObject.clickSubmitAssignFormButton();
		Thread.sleep(3000);
		formsOverviewStepObject.verifyNewUserWasAssigned(Configuration.getBriefNewUser());
	}

	@Test(priority = 6, groups="smoke")
	public void SAM390_updateFormStatus() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		formsOverviewStepObject.navigateToOverviewSection();
		formsOverviewStepObject.selectFormOverviewFromTable(FormCategoriesInspectionsTests.form);
		formsOverviewStepObject.getFormStatus();
		formsOverviewStepObject.clickActionsButton();
		formsOverviewStepObject.clickUpdateStatus();
		formsOverviewStepObject.selectStatus(status);
		formsOverviewStepObject.clickSubmitStatusButton();
		Thread.sleep(2000);
		formsOverviewStepObject.verifyStatusWasUpdated();
	}
}
