package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

import java.util.Random;

public class FormCategoriesWithGuidanceTests extends Setup{
	public static String formName = "HealthForm"+ new Random().nextInt(1000);
	private String publicURL = "No";
	private String guidance = "SeleGuidance";
	
	private String form = "SeleInspection1";
	private String guidanceName = "GuidanceWithAttachements1";
	
	@Test(priority = 1, groups = "dependencies")
	public void SAM6X6X1X() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		/*
		formsHealthAndSafetyStepObject.clickSaveButton();
		TODO add assertion for error messages
		*/
		formsHealthAndSafetyStepObject.createHealthFormWithGuidance(formName, publicURL, guidance);
		formsHealthAndSafetyStepObject.verifyFormSavedMessage();
		
	}
	
//	@Test(priority = 2)
//	public void createInspectionsWithGuidance() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		formsInspectionsStepObject.createInspectionWithGuidance(form, publicURL, guidanceName);
//		formsInspectionsStepObject.verifyFormSavedMessage();
//		formsInspectionsStepObject.verifyFormRedirected(form);
//		//TODO add item
//
//	}

}
