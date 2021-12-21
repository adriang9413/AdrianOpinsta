package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

import java.util.Random;

public class FormCategoriesTests extends Setup{
	private String categoryName = "Health & Safety";
	private String publicURL = "No";
	
	@Test(priority = 1, groups = "smoke")
	public void SAM260() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		formsHealthAndSafetyStepObject.createHealthForm(FormCategoriesWithGuidanceTests.formName,categoryName, publicURL);
		formsHealthAndSafetyStepObject.verifyFormSavedMessage();
		formsHealthAndSafetyStepObject.verifyFormSavedInTable(FormCategoriesWithGuidanceTests.formName);
		formsHealthAndSafetyStepObject.verifyFormRedirect(FormCategoriesWithGuidanceTests.formName);
	}
	
	@Test(priority = 2, groups = "smoke")
	public void SAM260_negative() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		// Assert that I am logged in to SAM
		assertionOnSamStepObject.assertLogin();
		formsHealthAndSafetyStepObject.createHealthFormWithoutMandatoryFields();
		formsHealthAndSafetyStepObject.verifyFormNotSavedMessage();
	}
	
	

}
