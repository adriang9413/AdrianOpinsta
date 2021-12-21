package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class FormsOverviewStandardUserTests extends Setup {
	private String formCategory = "Inspections";
	private String form = "InspectionSelenium";
	private String text = "Selenium Test";
	private String date = "31/12/2021";
	
//	@Test(priority = 1, groups = "smoke")
//	public void SAM667_createForm() throws Exception {
//		loginStepObject.logInApp(Configuration.getStandardUser(), Configuration.getStandardUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		formsOverviewStepObject.createNewForm(formCategory,form, text, date);
//		formsOverviewStepObject.verifyFormWasSubmitted();
//		Thread.sleep(2000);
//		formsOverviewStepObject.verifyFormDetails();
//
//	}
//
//	@Test(priority = 2)
//	public void SAM667_createFormWithoutMandatoryField() throws Exception {
//		loginStepObject.logInApp(Configuration.getStandardUser(), Configuration.getStandardUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		formsOverviewStepObject.createFormWithoutMandatoryField(formCategory, form);
//		formsOverviewStepObject.verifyMandatoryMessageAlert();
//	}
	

}
