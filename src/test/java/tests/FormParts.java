package tests;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class FormParts extends Setup {

    public static String form;

    {
        try {
            form = Configuration.getInspectionName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String formCateg = "Inspections";
    private String text = "New Test";
    private String date = "31/12/2021";
    private String url = "Rock FM - It Rocks!";
    private String publicURL1 = "No";
    private String inputSectionName = "SectName";
    private String inputPlaceholder = "Placeholder";
    private String textareaSectionName = "TextareaSection";
    private String textareaPlaceholder = "TextareaPlaceholder";
    private String dateSectionName = "DateSection";
    private String datePlaceholder = "DatePlaceholder";
    private String radioSectionName = "RadioSection";
    private String radioOption1 = "RadioOption1";
    private String radioOption2 = "RadioOption2";
    public static String formID;
    private String newTextField = "updated";
    private String status = "Closed";

    @Test (priority = 1, groups = "smoke")
    public void SAM266() throws Exception {
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        formsInspectionsStepObject.getToInspectionsSection();
        formsInspectionsStepObject.createInspectionWithGuidance(form, publicURL1, GuidanceTests.guidanceTitle);
        Thread.sleep(2000);
     formsInspectionsStepObject.clickformPartsAddNewButton();
     formsInspectionsStepObject.clickformPartsNameField();
     formsInspectionsStepObject.clickFormPartsSaveButton();
     formsInspectionsStepObject.clickAddNewItemButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickInputFormButton();
        formsInspectionsStepObject.sendinputnamename();
        formsInspectionsStepObject.sendinputplaceholder();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickTextareaFormButton();
        formsInspectionsStepObject.sendtextareaname();
        formsInspectionsStepObject.sendtextareaplaceholder();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickRadioFormButton();
        formsInspectionsStepObject.sendRadioButtonName();
        formsInspectionsStepObject.sendRadioOption1();
        formsInspectionsStepObject.sendRadioOption2();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(1500);
driver.navigate().back();
        formsInspectionsStepObject.clickformPartsAddNewButton();
        formsInspectionsStepObject.clickformPartsNameField2();
        formsInspectionsStepObject.clickFormPartsSaveButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickDateFormButton();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div/div[1]/div[2]/div[2]/label")).click();
        formsInspectionsStepObject.sendDateName();
        formsInspectionsStepObject.sendDatePlaceholder();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickCheckboxButton();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div/div[1]/div[2]/div[2]/label")).click();
        formsInspectionsStepObject.sendCheckboxName();
        formsInspectionsStepObject.sendCheckboxOption1();
        formsInspectionsStepObject.sendCheckboxOption2();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickDropdownButton();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div/div[1]/div[2]/div[2]/label")).click();
        formsInspectionsStepObject.sendDropdownName();
        formsInspectionsStepObject.sendDropdownPlaceholder();
        formsInspectionsStepObject.sendDropdownOption1();
        formsInspectionsStepObject.sendDropdownOption2();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(1500);
        driver.navigate().back();
        formsInspectionsStepObject.clickformPartsAddNewButton();
        formsInspectionsStepObject.clickformPartsNameField3();
        formsInspectionsStepObject.clickFormPartsSaveButton();
        Thread.sleep(2500);
        formsInspectionsStepObject.clickAddNewItemButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickTextareaFormButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.sendtextareaname();
        Thread.sleep(1500);
        formsInspectionsStepObject.sendtextareaplaceholder();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickAddNewItemButton();
        Thread.sleep(1500);
        formsInspectionsStepObject.clickEmailButton();
        formsInspectionsStepObject.sendEmailName();
        formsInspectionsStepObject.sendEmailPlaceholder();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(3000);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickSectionButton();
        formsInspectionsStepObject.sendSectionName();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(3000);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickReferenceButton();
        formsInspectionsStepObject.sendReferenceName();
        formsInspectionsStepObject.sendReferencePlaceholder();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(3000);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickImageButton();
        formsInspectionsStepObject.sendImageName();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div/div[1]/div[2]/div[2]/label")).click();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(3000);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickSignatureButton();
        formsInspectionsStepObject.sendSignatureName();
        formsInspectionsStepObject.sendSignaturePlaceholder();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(3000);
        formsInspectionsStepObject.clickAddNewItemButton();
        formsInspectionsStepObject.clickLocationButton();
        formsInspectionsStepObject.sendLocationName();
        formsInspectionsStepObject.sendLocationPlaceholder();
        formsInspectionsStepObject.clickSaveFormInputButton();
        Thread.sleep(3000);
        formsOverviewStepObject.selectCreatedInspection(formCateg, FormParts.form);
        formsOverviewStepObject.fillMandatoryFieldsSch();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[2]/div/div[1]/div[5]/div[3]/div/div/div/div[1]/span")).click();
formsOverviewStepObject.clickNextButton();
        Thread.sleep(1500);
driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[2]/div/div[1]/div[5]/div[5]/div/div/div/div[1]/span")).click();
        formsOverviewStepObject.clickNextButton();
        Thread.sleep(1500);
        formsOverviewStepObject.fillMandatoryFieldsSch2();
        Thread.sleep(1500);
        formsOverviewStepObject.clickSubmitButton();
        Thread.sleep(4500);

    }

    @Test(priority = 2, groups = "smoke")
    public void SAM392_editFormFields() throws Exception {
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        formsOverviewStepObject.navigateToOverviewSection();
        formsOverviewStepObject.selectFormOverviewFromTable(FormParts.form);
        formsOverviewStepObject.getFormDetails();
        formsOverviewStepObject.clickActionsButton();
        formsOverviewStepObject.clickEditForm();
        formsOverviewStepObject.editTextField(newTextField);
        formsOverviewStepObject.clickNextButtonUpdate();
        formsOverviewStepObject.clickNextButtonUpdate();
        formsOverviewStepObject.clickSubmitEditFormButton();
        Thread.sleep(2000);
        //formsOverviewStepObject.verifyFormDetailsWereUpdated(newTextField);
    }

    @Test(priority = 3, groups = "smoke")
    public void SAM408_editAssignUser() throws Exception {
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        formsOverviewStepObject.navigateToOverviewSection();
        formsOverviewStepObject.selectFormOverviewFromTable(FormParts.form);
        formsOverviewStepObject.clickActionsButton();
        formsOverviewStepObject.clickAssignForm();
        formsOverviewStepObject.assignUser(Configuration.getBriefNewUser());
        formsOverviewStepObject.clickSubmitAssignFormButton();
        Thread.sleep(3000);
        formsOverviewStepObject.verifyNewUserWasAssigned(Configuration.getBriefNewUser());
    }

    @Test(priority = 4, groups="smoke")
    public void SAM390_updateFormStatus() throws Exception {
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        formsOverviewStepObject.navigateToOverviewSection();
        formsOverviewStepObject.selectFormOverviewFromTable(FormParts.form);
        formsOverviewStepObject.getFormStatus();
        formsOverviewStepObject.clickActionsButton();
        formsOverviewStepObject.clickUpdateStatus();
        formsOverviewStepObject.selectStatus(status);
        formsOverviewStepObject.clickSubmitStatusButton();
        Thread.sleep(2000);
        formsOverviewStepObject.verifyStatusWasUpdated();
    }
}