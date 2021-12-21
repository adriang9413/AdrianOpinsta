package tests;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class ProblemTests extends Setup {
	public static String firstLevel = "Problem Selenium1";
	private String cancelFirstLevel = "Cancel Problem";
	
	@Test(priority = 1, groups = "dependencies")
	public void SAM18_createNewProblem() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		problemStepObject.addNewProblem(AssetGroupTests.assetGroupName, firstLevel);
		problemStepObject.verifyProblemSaved(firstLevel);
	}
	
//	@Test(priority = 2)
//	public void createProblemWithoutMandatoryFields() throws Exception{
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		problemStepObject.addProblemWithoutMandatoryFields();
//		problemStepObject.verifyProblemMandatoryFields();
//	}
//
//	@Test(priority = 3)
//	public void cancelCreatingProblem() throws Exception{
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		problemStepObject.cancelCreatingProblem(assetGroup,cancelFirstLevel, contractorName, guidance);
//		problemStepObject.verifyProblemNotSaved(cancelFirstLevel);
//	}

}
