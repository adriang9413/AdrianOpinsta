package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.FormsInspectionsPageObject;
import pageObjects.LeftSideMenuPageObject;
import utils.BaseClass;

import java.util.List;

public class FormsInspectionsStepObject extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, 15);

	public FormsInspectionsStepObject(WebDriver driver) {
		super(driver);
	}

	public void createInspectionWithGuidance(String formName, String publicURL, String guidance) throws InterruptedException {
		this.clickAddNewFormButton();
		this.fillFormName(formName);
		//this.selectPublicURL(publicURL);
		//this.selectGuidance(guidance);
		this.clickSaveButton();
	}



	public void createInspection(String formName, String publicUrl) throws InterruptedException {
		this.clickAddNewFormButton();
		this.fillFormName(formName);
		this.selectPublicURL(publicUrl);
		this.clickSaveButton();
		this.writeFormToPropFile(formName);
	}

	public void createFormParts(String formPartName) throws InterruptedException {
		this.clickAddNewFormPartsButton();
		this.clickformpartsnamefield();
	}

	public void writeFormToPropFile(String formName) {
		writePropertiesFile("forms", formName);
	}

	public void clickFormCategoriesLeftMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getFormCategoriesLeftMenu())));
		$(LeftSideMenuPageObject.getFormCategoriesLeftMenu()).click();
	}

	public void clickInspectionsLeftMenu() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getInspectionsLeftMenu())));
		$(LeftSideMenuPageObject.getInspectionsLeftMenu()).click();
		Thread.sleep(500);
	}

	public void clickAddNewFormButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(FormsInspectionsPageObject.getAddNewFormButton())));
		clickAddNewItemButton();
	}

	public void clickformPartsAddNewButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[1]/div/button")));
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getFormPartsAddNewButton()).click();
		Thread.sleep(1000);
	}
	public void clickformPartsNameField() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[6]/div[2]/input")));
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getFormPartsNameField()).click() ;
		Thread.sleep(1500);
		$(FormsInspectionsPageObject.getFormPartsNameField()).sendKeys("Partea 1"); ;
		Thread.sleep(1000);
	}
	public void clickformPartsNameField2() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[6]/div[2]/input")));
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getFormPartsNameField()).click() ;
		Thread.sleep(1500);
		$(FormsInspectionsPageObject.getFormPartsNameField()).sendKeys("Partea a2-a"); ;
		Thread.sleep(1000);
	}
	public void clickformPartsNameField3() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[6]/div[2]/input")));
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getFormPartsNameField()).click() ;
		Thread.sleep(1500);
		$(FormsInspectionsPageObject.getFormPartsNameField()).sendKeys("A 3-a Parte"); ;
		Thread.sleep(1000);
	}

	public void fillFormName(String formName) {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getFormName(), 10);
		$(FormsInspectionsPageObject.getFormName()).clear();
		$(FormsInspectionsPageObject.getFormName()).sendKeys(formName);
	}

	public void selectPublicURL(String publicURL) {
		$(FormsInspectionsPageObject.getFormPublicUrl()).click();
		WebElement publicURLUL = driver.findElement(By.xpath(FormsInspectionsPageObject.getPublicUrlDropdown()));
		List<WebElement> publicURLIL = publicURLUL.findElements(By.tagName("li"));
		for (WebElement li : publicURLIL) {
			if (li.getText().equals(publicURL)) {
				li.click();
			}
		}
	}

	public void selectGuidance(String guidance) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsInspectionsPageObject.getFormGuidance())));
		$(FormsInspectionsPageObject.getFormGuidance()).click();
		WebElement guidanceUL = driver.findElement(By.xpath(FormsInspectionsPageObject.getStagingGuidanceDropdown()));
		List<WebElement> guidanceIL = guidanceUL.findElements(By.tagName("li"));
		for (WebElement li : guidanceIL) {
			if (li.getText().equals(guidance)) {
				li.click();
				break;
			}
		}
	}

	public void clickSaveButton() {
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getSaveButton(), 10);
		$(FormsInspectionsPageObject.getSaveButton()).click();
	}
	public void clickFormPartsSaveButton() {
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getFormPartsSaveButton(), 10);
		$(FormsInspectionsPageObject.getFormPartsSaveButton()).click();
	}

	public void verifyFormSavedMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
		String actualAlert = "Form stored successfully";
		String alert = $(FormsInspectionsPageObject.getAboveAlert()).getText();
		assertEquals(actualAlert, alert);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
	}

	public void verifyFormSaved(String formName) {
		$(FormsInspectionsPageObject.getSearchBar()).sendKeys(formName);
		String selector = String.format(FormsInspectionsPageObject.getInspectionInTable(), formName);
		assertTrue($(selector).isDisplayed());
	}

	public void verifyFormRedirected(String form) throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(FormsInspectionsPageObject.getInspectionNameRedirect())));
		String formPageName = $(FormsInspectionsPageObject.getInspectionNameRedirect()).getText();
		assertEquals(form, formPageName);
	}

	public void searchFormInspection(String formName) {
		$(FormsInspectionsPageObject.getSearchBar()).sendKeys(formName);
		String selector = String.format(FormsInspectionsPageObject.getInspectionInTable(), formName);
		assertTrue($(selector).isDisplayed());
	}

	public void clickEditFormButton() {
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getEditFormButton(), 10);
		$(FormsInspectionsPageObject.getEditFormButton()).click();
	}

	public void getToInspectionsSection() throws InterruptedException {
		this.clickFormCategoriesLeftMenu();
		this.clickInspectionsLeftMenu();
	}

	public void verifyFormItemIsDisplayed(String formName) throws InterruptedException {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(FormsInspectionsPageObject.getInspectionNameRedirect())));
		Thread.sleep(1500);
		String formPageName = $(FormsInspectionsPageObject.getInspectionNameRedirect()).getText();
		assertEquals(formName, formPageName);
	}

	public void addInputMandatoryAndActive(String sectionName, String placeholder) throws InterruptedException {
		clickAddNewItemButton();
		clickInputFormButton();
		fillFormSectionName(sectionName);
		fillFormPlaceHolder(placeholder);
		clickSaveFormInputButton();
	}

	public void clickInputFormButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getInputButton(), 10);
		$(FormsInspectionsPageObject.getInputButton()).click();
	}
	public void clickDropdownButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDropdownButton(), 10);
		$(FormsInspectionsPageObject.getDropdownButton()).click();
	}
	public void clickEmailButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getEmailButton(), 10);
		$(FormsInspectionsPageObject.getEmailButton()).click();
	}
	public void clickImageButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getImageButton(), 10);
		$(FormsInspectionsPageObject.getImageButton()).click();
	}
	public void clickSignatureButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getSignatureButton(), 10);
		$(FormsInspectionsPageObject.getSignatureButton()).click();
	}
	public void clickReferenceButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getReferenceButton(), 10);
		$(FormsInspectionsPageObject.getReferenceButton()).click();
	}
	public void clickSectionButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getSectionButton(), 10);
		$(FormsInspectionsPageObject.getSectionButton()).click();
	}
	public void clickLocationButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getLocationButton(), 10);
		$(FormsInspectionsPageObject.getLocationButton()).click();
	}
	public void clickCheckboxButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getCheckboxButton(), 10);
		$(FormsInspectionsPageObject.getCheckboxButton()).click();
	}

	public void sendEmailName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getEmailName(), 10);
		$(FormsInspectionsPageObject.getEmailName()).click();
		$(FormsInspectionsPageObject.getEmailName()).sendKeys("E-Mail");
	}
	public void sendEmailPlaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getEmailPlaceholder(), 10);
		$(FormsInspectionsPageObject.getEmailPlaceholder()).click();
		$(FormsInspectionsPageObject.getEmailPlaceholder()).sendKeys("Insert Your Email");
	}
	public void sendDropdownName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDropdownName(), 10);
		$(FormsInspectionsPageObject.getDropdownName()).click();
		$(FormsInspectionsPageObject.getDropdownName()).sendKeys("Dropdown");
	}
	public void sendDropdownOption1() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDropdownOption1(), 10);
		$(FormsInspectionsPageObject.getDropdownOption1()).click();
		$(FormsInspectionsPageObject.getDropdownOption1()).sendKeys("Drop1");
	}
	public void sendDropdownOption2() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDropdownOption2(), 10);
		$(FormsInspectionsPageObject.getDropdownOption2()).click();
		$(FormsInspectionsPageObject.getDropdownOption2()).sendKeys("Drop2");
	}
	public void sendDropdownPlaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDropdownPlaceholder(), 10);
		$(FormsInspectionsPageObject.getDropdownPlaceholder()).click();
		$(FormsInspectionsPageObject.getDropdownPlaceholder()).sendKeys("Select An Option");
	}


	public void sendCheckboxName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getCheckboxName(), 10);
		$(FormsInspectionsPageObject.getCheckboxName()).click();
		$(FormsInspectionsPageObject.getCheckboxName()).sendKeys("Checkbox");
	}
	public void sendCheckboxOption1() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getCheckboxOption1(), 10);
		$(FormsInspectionsPageObject.getCheckboxOption1()).click();
		$(FormsInspectionsPageObject.getCheckboxOption1()).sendKeys("Chk1");
	}
	public void sendCheckboxOption2() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getCheckboxOption2(), 10);
		$(FormsInspectionsPageObject.getCheckboxOption2()).click();
		$(FormsInspectionsPageObject.getCheckboxOption2()).sendKeys("Chk2222");
	}
	public void sendDateName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDateName(), 10);
		$(FormsInspectionsPageObject.getDateName()).click();
		$(FormsInspectionsPageObject.getDateName()).sendKeys("Date");
	}
	public void sendDatePlaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDatePlaceholder(), 10);
		$(FormsInspectionsPageObject.getDatePlaceholder()).click();
		$(FormsInspectionsPageObject.getDatePlaceholder()).sendKeys("Select Date");
	}
	public void sendinputnamename() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getSectionName(), 10);
		$(FormsInspectionsPageObject.getSectionName()).click();
		$(FormsInspectionsPageObject.getSectionName()).sendKeys("InputSCH");
	}
	public void sendinputplaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getFormInputPlaceholder(), 10);
		$(FormsInspectionsPageObject.getFormInputPlaceholder()).click();
		$(FormsInspectionsPageObject.getFormInputPlaceholder()).sendKeys("PlaceholderSCH");
	}
	public void sendRadioButtonName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getRadioButtonName(), 10);
		$(FormsInspectionsPageObject.getRadioButtonName()).click();
		$(FormsInspectionsPageObject.getRadioButtonName()).sendKeys("SCHRadioButton");
	}
	public void sendtextareaname() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getTextareaName(), 10);
		$(FormsInspectionsPageObject.getTextareaName()).click();
		$(FormsInspectionsPageObject.getTextareaName()).sendKeys("TextAreaSCH");
	}
	public void sendRadioOption1() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getRadioOption1(), 10);
		$(FormsInspectionsPageObject.getRadioOption1()).click();
		$(FormsInspectionsPageObject.getRadioOption1()).sendKeys("Opt1");
	}
	public void sendRadioOption2() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getRadioOption2(), 10);
		$(FormsInspectionsPageObject.getRadioOption2()).click();
		$(FormsInspectionsPageObject.getRadioOption2()).sendKeys("Optiunea 2");
	}
	public void sendtextareaplaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getTextareaPlaceholder(), 10);
		$(FormsInspectionsPageObject.getTextareaPlaceholder()).click();
		$(FormsInspectionsPageObject.getTextareaPlaceholder()).sendKeys("PlaceholderSCHTxt");
	}

	public void clickSaveFormInputButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getFormInputSaveButton(), 10);
		$(FormsInspectionsPageObject.getFormInputSaveButton()).click();
	}

	public void fillFormPlaceHolder(String placeholder) {
		$(FormsInspectionsPageObject.getFormInputPlaceholder()).clear();
		$(FormsInspectionsPageObject.getFormInputPlaceholder()).sendKeys(placeholder);
	}

	public void fillFormSectionName(String sectionName) {
		$(FormsInspectionsPageObject.getSectionName()).clear();
		$(FormsInspectionsPageObject.getSectionName()).sendKeys(sectionName);
	}

	public void clickAddNewItemButton() throws InterruptedException {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getAddNewFormButton(), 10);
		//bullscheiBe!!!!!!!!!!
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getAddNewFormButton()).click();
	}

	public void clickAddNewFormPartsButton() throws InterruptedException {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getFormPartsAddNewButton(), 100);
		//bullscheiBe!!!!!!!!!!
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getFormPartsAddNewButton()).click();
	}
	public void clickformpartsnamefield() throws InterruptedException {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getFormPartsNameField(), 10);
		//bullscheiBe!!!!!!!!!!
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getFormPartsNameField()).click();
	}

	public void verifyFormInputSaved(String formName) throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FormsInspectionsPageObject.getFormNameInputInActiveTable())));
		Thread.sleep(500);
		assertEquals($(FormsInspectionsPageObject.getFormNameInputInActiveTable()).getText(), formName);
		assertEquals($(FormsInspectionsPageObject.getFormInputMandatoryInActiveTable()).getText(), "Yes");
	}

	public void addTextareaMandatoryAndInactive(String textareaSectionName, String textareaPlaceholder) throws InterruptedException {
		clickAddNewItemButton();
		clickTextareaFormButton();
		selectInactiveToggleSwitch();
		fillFormSectionName(textareaSectionName);
		fillFormPlaceHolder(textareaPlaceholder);
		clickSaveFormInputButton();
	}

	public void selectInactiveToggleSwitch() {
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getActiveFormSwitch(), 10);
		$(FormsInspectionsPageObject.getActiveFormSwitch()).click();
	}

	public void clickTextareaFormButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getTextareaButton(), 10);
		$(FormsInspectionsPageObject.getTextareaButton()).click();

	}

	public void verifyFormTextareaInactiveSaved(String textareaSectionName) {
		String alertSavedForm = "Form item saved successfully";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
		assertEquals($(FormsInspectionsPageObject.getAboveAlert()).getText(), alertSavedForm);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
		$(FormsInspectionsPageObject.getInactiveFormTab()).click();
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getFormNameInputInactiveTable(), 10);
		assertEquals($(FormsInspectionsPageObject.getFormNameInputInactiveTable()).getText(), textareaSectionName);
		assertEquals($(FormsInspectionsPageObject.getFormInputMandatoryInInactiveTable()).getText(), "Yes");
	}

	public void addDateOptionalAndActive(String dateSectionName, String datePlaceholder) throws InterruptedException {
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getActiveFormTab(), 10);
		$(FormsInspectionsPageObject.getActiveFormTab()).click();
		clickAddNewItemButton();
		clickDateFormButton();
		selectOptionalToggleSwitch();
		selectInactiveToggleSwitch();
		fillFormSectionName(dateSectionName);
		fillFormPlaceHolder(datePlaceholder);
		clickSaveFormInputButton();
	}

	public void clickDateFormButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDateButton(), 10);
		$(FormsInspectionsPageObject.getDateButton()).click();
	}

	public void selectOptionalToggleSwitch() {
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getOptionalMandatorySwitch(), 10);
		$(FormsInspectionsPageObject.getOptionalMandatorySwitch()).click();
	}

	public void addRadioOptionalAndInactive(String radioSectionName, String radioOption1, String radioOption2) throws InterruptedException {
		clickAddNewItemButton();
		clickRadioFormButton();
		selectInactiveToggleSwitch();
		fillFormSectionName(radioSectionName);
		fillFormOption1(radioOption1);
		fillFormOption2(radioOption2);
		clickSaveFormInputButton();

	}

	public void fillFormOption1(String radioOption1) {
		$(FormsInspectionsPageObject.getRadioOption1()).sendKeys(radioOption1);
	}

	public void fillFormOption2(String radioOption2) {
		$(FormsInspectionsPageObject.getRadioOption2()).sendKeys(radioOption2);
	}

	public void clickRadioFormButton() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getRadioButton(), 10);
		$(FormsInspectionsPageObject.getRadioButton()).click();
	}
//	public void clickDateFormButton() {
//		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getDateButton(), 10);
//		$(FormsInspectionsPageObject.getDateButton()).click();
//	}
	public void verifyFormDateActiveSaved(String dateSectionName) {
		String alertSavedForm = "Form item saved successfully";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
		wait_for_id_elem_to_be_visible(FormsInspectionsPageObject.getAboveAlert(), 10);
		assertEquals($(FormsInspectionsPageObject.getAboveAlert()).getText(), alertSavedForm);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getSearchBar(), 10);
		$(FormsInspectionsPageObject.getSearchBar()).sendKeys(dateSectionName);
		wait_for_xpath_elem_to_be_clickable(FormsInspectionsPageObject.getFormNameInputInActiveTable(), 10);
		assertEquals($(FormsInspectionsPageObject.getFormNameInputInActiveTable()).getText(), dateSectionName);
		assertEquals($(FormsInspectionsPageObject.getFormInputMandatoryInActiveTable()).getText(), "No");
	}

	public void verifyFormRadioInactiveSaved(String radioSectionName) throws InterruptedException {
		String alertSavedForm = "Form item saved successfully";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
		assertEquals($(FormsInspectionsPageObject.getAboveAlert()).getText(), alertSavedForm);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(FormsInspectionsPageObject.getAboveAlert())));
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getInactiveFormTab()).click();
		Thread.sleep(1000);
		$(FormsInspectionsPageObject.getSearchBar()).sendKeys(radioSectionName);
		assertEquals($(FormsInspectionsPageObject.getFormNameInputInactiveTable()).getText(), radioSectionName);
		assertEquals($(FormsInspectionsPageObject.getFormInputMandatoryInInactiveTable()).getText(), "No");
	}
	public void sendSignatureName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getSignatureName(), 10);
		$(FormsInspectionsPageObject.getSignatureName()).click();
		$(FormsInspectionsPageObject.getSignatureName()).sendKeys("Insert Your Signature");
	}
	public void sendSignaturePlaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getSignaturePlaceholder(), 10);
		$(FormsInspectionsPageObject.getSignaturePlaceholder()).click();
		$(FormsInspectionsPageObject.getSignaturePlaceholder()).sendKeys("Optional");
	}
	public void sendImageName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getImageName(), 10);
		$(FormsInspectionsPageObject.getImageName()).click();
		$(FormsInspectionsPageObject.getImageName()).sendKeys("Image");
	}
	public void sendSectionName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getSectionName(), 10);
		$(FormsInspectionsPageObject.getSectionName()).click();
		$(FormsInspectionsPageObject.getSectionName()).sendKeys("Another Section");
	}
	public void sendReferenceName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getReferenceName(), 10);
		$(FormsInspectionsPageObject.getReferenceName()).click();
		$(FormsInspectionsPageObject.getReferenceName()).sendKeys("Insert Reference Number");
	}
	public void sendReferencePlaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getReferencePlaceholder(), 10);
		$(FormsInspectionsPageObject.getReferencePlaceholder()).click();
		$(FormsInspectionsPageObject.getReferencePlaceholder()).sendKeys("REF");
	}
	public void sendLocationName() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getLocationName(), 10);
		$(FormsInspectionsPageObject.getLocationName()).click();
		$(FormsInspectionsPageObject.getLocationName()).sendKeys(" Location");
	}
	public void sendLocationPlaceholder() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getLocationPlaceholder(), 10);
		$(FormsInspectionsPageObject.getLocationPlaceholder()).click();
		$(FormsInspectionsPageObject.getLocationPlaceholder()).sendKeys("Select Location");
	}
	public void clickActiveInactiveToggle() {
		wait_for_id_elem_to_be_clickable(FormsInspectionsPageObject.getActiveInactiveToggle(), 10);
		$(FormsInspectionsPageObject.getActiveInactiveToggle()).click();
	}
}
