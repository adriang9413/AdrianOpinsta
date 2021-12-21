package tests;

import org.testng.annotations.Test;
import utils.Configuration;
import utils.Setup;
import java.io.IOException;


public class GuidanceTests extends Setup{
	public static String guidanceTitle;

	{
		try {
			guidanceTitle = Configuration.getGuidanceName();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String URL = "https://www.rockfm.ro/";
	public String pdf = "Migration1page.pdf";


	@Test(priority = 1) 
	public void SAM446_createNewGuidance() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		guidanceStepObject.addNewGuidanceWithAttachments(guidanceTitle, URL, pdf);
		guidanceStepObject.verifyGuidanceSaved(guidanceTitle);
	}
	
//	@Test(priority = 2)
//	public void createGuidanceWithoutMandatoryFields() throws Exception{
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		guidanceStepObject.addGuidanceWithoutMandatoryFields();
//		guidanceStepObject.verifyGuidanceMandatoryField();
//	}
	
//	@Test(priority = 3)
//	public void cancelCreatingGuidance() throws Exception{
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		guidanceStepObject.cancelCreatingGuidance(cancelGuidance);
//		guidanceStepObject.verifyGuidanceNotSaved(cancelGuidance);
//	}
	
//	@Test(priority = 4)
//	public void createGuidanceWithAttachments() throws Exception{
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		guidanceStepObject.addNewGuidanceWithAttachments(guidTitle, URL, pdfFile);
//		guidanceStepObject.verifyGuidanceSuccessfullySavedMessage();
//		guidanceStepObject.verifyGuidanceSaved(guidTitle);
//	}
}
