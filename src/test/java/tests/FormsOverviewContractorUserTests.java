package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class FormsOverviewContractorUserTests extends Setup {
	private String formCategory = "Inspections";
	private String form = "SeleInspection";
	private String text = "Selenium Test";
	private String date = "31/12/2021";
	
//	@Test(priority = 1, groups = "smoke")
//	public void SAM668_createForm() throws Exception {
//		loginStepObject.logInApp(Configuration.getContractorUser(), Configuration.getContractorUserPassword());
//		//assertionOnSamStepObject.assertSAMStaging();
//		formsOverviewStepObject.createNewForm(formCategory,form, text, date);
//		formsOverviewStepObject.verifyFormWasSubmitted();
//		Thread.sleep(2500);
//		formsOverviewStepObject.verifyFormDetails();
//
//	}
//
//	@Test(priority = 2)
//	public void SAM668_createFormWithoutMandatoryField() throws Exception {
//		loginStepObject.logInApp(Configuration.getContractorUser(), Configuration.getContractorUserPassword());
////		assertionOnSamStepObject.assertSAMStaging();
//		formsOverviewStepObject.createFormWithoutMandatoryField(formCategory, form);
//		formsOverviewStepObject.verifyMandatoryMessageAlert();
//	}
	

}
