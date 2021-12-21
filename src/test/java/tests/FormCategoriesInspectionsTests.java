package tests;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class FormCategoriesInspectionsTests extends Setup {

	public static String form;

	{
		try {
			form = Configuration.getInspectionName();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String publicURL = "No";
	private String inputSectionName = "SectName";
	private String inputPlaceholder = "Placeholder";
	private String textareaSectionName = "TextareaSection";
	private String textareaPlaceholder = "TextareaPlaceholder";
	private String dateSectionName = "DateSection";
	private String datePlaceholder = "DatePlaceholder";
	private String radioSectionName = "RadioSection";
	private String radioOption1 = "RadioOption1";
	private String radioOption2 = "RadioOption2";

	@Test(priority = 1, groups = "dependencies")
	public void SAM661_createFormWithGuidance() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		formsInspectionsStepObject.getToInspectionsSection();
		formsInspectionsStepObject.createInspectionWithGuidance(form, publicURL, GuidanceTests.guidanceTitle);
		formsInspectionsStepObject.verifyFormSavedMessage();
	}
	
//	@Test(priority = 2, groups = "dependencies")
//	public void SAM297_editForm() throws Exception{
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		formsInspectionsStepObject.getToInspectionsSection();
//		formsInspectionsStepObject.searchFormInspection(form);
//		formsInspectionsStepObject.clickEditFormButton();
//		formsInspectionsStepObject.addInputMandatoryAndActive(inputSectionName, inputPlaceholder);
//		formsInspectionsStepObject.verifyFormInputSaved(inputSectionName);
//		formsInspectionsStepObject.addTextareaMandatoryAndInactive(textareaSectionName, textareaPlaceholder);
//		formsInspectionsStepObject.verifyFormTextareaInactiveSaved(textareaSectionName);
//		formsInspectionsStepObject.addDateOptionalAndActive(dateSectionName, datePlaceholder);
//		formsInspectionsStepObject.verifyFormDateActiveSaved(dateSectionName);
//		formsInspectionsStepObject.addRadioOptionalAndInactive(radioSectionName, radioOption1, radioOption2 );
//		formsInspectionsStepObject.verifyFormRadioInactiveSaved(radioSectionName);
//	}
}
