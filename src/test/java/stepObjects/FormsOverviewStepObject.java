package stepObjects;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.FormsOverviewPageObject;
import pageObjects.LeftSideMenuPageObject;
import tests.FormsOverviewAdminUserTests;
import utils.BaseClass;

public class FormsOverviewStepObject extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, 15);
	public String   statusBeforeUpdate = null;
	public String formText = null;

	public FormsOverviewStepObject(WebDriver driver) {
		super(driver);
	}

	public void createNewForm(String formCategory, String form, String text, String date) throws Exception {
		this.navigateToOverviewSection();
		this.clickCreateNewFormButton();
		this.selectFormCategory(formCategory);
		this.selectForm(form);
		this.fillMandatoryFields(text, date);
		this.clickSubmitButton();
	}

	public void createFormWithoutMandatoryField(String formCategory, String form) throws Exception {
		this.navigateToOverviewSection();
		this.clickCreateNewFormButton();
		this.selectFormCategory(formCategory);
		this.selectForm(form);
		this.fillMandatoryFields(" ", " ");
		this.clickSubmitButton();

	}

	public void createNewFormWithGuidance(String formCateg, String formName, String text, String date, String url) throws Exception {
		this.navigateToOverviewSection();
		this.clickCreateNewFormButton();
		this.selectFormCategory(formCateg);
		this.selectForm(formName);
		this.clickViewPdf();
		this.switchToWindow();
		this.clickViewUrl(url);
		this.switchToWindow();
		this.clickGuidanceContinueButton();
		this.fillMandatoryFields(text, date);
		this.clickSubmitButton();

	}

	public void navigateToOverviewSection() {
//		wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPage.getFormsDashboardLeftMenu())));
//		$(LeftSideMenuPage.getFormsDashboardLeftMenu()).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getFormsOverviewLeftMenu())));
		$(LeftSideMenuPageObject.getFormsOverviewLeftMenu()).click();
	}

	public void clickCreateNewFormButton() throws Exception {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getCreateNewFormButton())));
		$(FormsOverviewPageObject.getCreateNewFormButton()).click();
		Thread.sleep(1500);
	}

	public void selectFormCategory(String formCategory) throws Exception {
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getCategoryBox())));
		$(FormsOverviewPageObject.getCategoryBox()).click();
		String selector = String.format(FormsOverviewPageObject.getCategoryGroupName(), formCategory);
		$(selector).click();
	}

	public void selectForm(String form) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getFormBox())));
		$(FormsOverviewPageObject.getFormBox()).click();

		WebElement formUL = driver.findElement(By.xpath(FormsOverviewPageObject.getFormDropdownList()));
		List<WebElement> assetGroupIL = formUL.findElements(By.tagName("li"));
		for (WebElement li : assetGroupIL) {
			if (li.getText().equals(form)) {
				li.click();
			}
		}
	}

	public void fillMandatoryFields(String text, String date) {
		$(FormsOverviewPageObject.getMandatoryField1()).sendKeys(text);
		$(FormsOverviewPageObject.getMandatoryField2()).sendKeys(date);
	}

	public void clickSubmitButton() {
		$(FormsOverviewPageObject.getSubmitButton()).click();
	}
	public void clickNextButton() {
		$(FormsOverviewPageObject.getNextButton()).click();
	}
	public void clickNextButtonUpdate() {
		$(FormsOverviewPageObject.getNextButtonUpdate()).click();
	}


	public void verifyFormWasSubmitted() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getAboveAlert())));
		String alert = $(FormsOverviewPageObject.getAboveAlert()).getText();
		FormsOverviewAdminUserTests.formID = $(FormsOverviewPageObject.getFormDetailsPageTitle()).getText();
		assertEquals(alert, "Successfully submitted form!");

	}

	public void verifyFormDetails(String formID) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FormsOverviewPageObject.getFormDetailsPageTitle())));
		String formDetailsTitle = $(FormsOverviewPageObject.getFormDetailsPageTitle()).getText();
		assertEquals(formDetailsTitle, formID);
	}

	public void verifyMandatoryMessageAlert() {
		String alert = "  Error! This field is mandatory, please complete";
		String messageAlert = $(FormsOverviewPageObject.getMandatoryFieldAlert()).getText();
		assertEquals(alert, messageAlert);

	}

	public void clickViewPdf() throws InterruptedException {
		Thread.sleep(1000);
		$(FormsOverviewPageObject.getViewPdfLink()).click();
	}

	public void clickGuidanceContinueButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(FormsOverviewPageObject.getGuidanceContinueButton())));
		$(FormsOverviewPageObject.getGuidanceContinueButton()).click();

	}

	public void clickViewUrl(String url) {
		$(FormsOverviewPageObject.getViewURLLink()).click();
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
				assertEquals(driver.switchTo().window(ChildWindow).getTitle(), url);
				try {
					Thread.sleep(500);
					driver.close();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
		driver.switchTo().window(mainWindowHandle);

	}

//		

	public void switchToWindow() {
		String mainWindowHandle = driver.getWindowHandle();
		// System.out.println("main win:" + mainWindowHandle);
		Set<String> allWindowHandles = driver.getWindowHandles();
		// System.out.println("all win: " + allWindowHandles);

		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
				try {
					Thread.sleep(500);
					driver.close();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
		driver.switchTo().window(mainWindowHandle);

	}

	public void selectFormOverviewFromTable(String form) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FormsOverviewPageObject.getPageTitleFormsOverview())));
		String selector = String.format(FormsOverviewPageObject.getFormsOverviewInTable(), form);
		$(selector).click();
	}

	public void clickActionsButton() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getFormActionsButton())));
		$(FormsOverviewPageObject.getFormActionsButton()).click();

	}

	public void clickUpdateStatus() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getFormUpdateStatus())));
		$(FormsOverviewPageObject.getFormUpdateStatus()).click();
	}

	public void selectStatus(String status) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getChangeStatusInput())));
		$(FormsOverviewPageObject.getChangeStatusInput()).click();
		WebElement statusUL = driver.findElement(By.xpath(FormsOverviewPageObject.getChangeStatusValue()));
		List<WebElement> statusIL = statusUL.findElements(By.tagName("li"));
		for (WebElement li : statusIL) {
			if (li.getText().equals(status)) {
				li.click();
			}
		}
	}

	public String getFormStatus() {
		// click view less button and get the state of form
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getViewLessOrMoreButton())));
		if ($(FormsOverviewPageObject.getViewLessOrMoreButtonText()).getText().equals("view more")) {
			$(FormsOverviewPageObject.getViewLessOrMoreButton()).click();
		}
		String status = $(FormsOverviewPageObject.getStatusInFormDetail()).getText();
		statusBeforeUpdate = status;
		return status;
	}

	public String getNewFormStatus() {
		// click view less button and get the state of form
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getViewLessOrMoreButton())));
		if ($(FormsOverviewPageObject.getViewLessOrMoreButtonText()).getText().equals("view more")) {
			$(FormsOverviewPageObject.getViewLessOrMoreButton()).click();
		}
		String status = $(FormsOverviewPageObject.getStatusInFormDetail()).getText();

		return status;
	}

	public void clickSubmitStatusButton() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getSubmitStatusButton())));
		$(FormsOverviewPageObject.getSubmitStatusButton()).click();

	}

	public void verifyStatusWasUpdated() {

		Assert.assertNotEquals(statusBeforeUpdate, getNewFormStatus());
	}

	public void clickEditForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getEditFormButton())));
		$(FormsOverviewPageObject.getEditFormButton()).click();

	}

	public String getFormDetails() {
		// click view less button and get the state of form
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getViewLessOrMoreButton())));
		if ($(FormsOverviewPageObject.getViewLessOrMoreButtonText()).getText().equals("view more")) {
			$(FormsOverviewPageObject.getViewLessOrMoreButton()).click();
		}
		// String status = $(FormsOverviewPageObject.getStatusInFormDetail()).getText();
		return formText = $(FormsOverviewPageObject.getFormDetails()).getText();

	}
	
	public String getFormUserAssigned() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getViewLessOrMoreButton())));
		if ($(FormsOverviewPageObject.getViewLessOrMoreButtonText()).getText().equals("view more")) {
			$(FormsOverviewPageObject.getViewLessOrMoreButton()).click();
		}
		return $(FormsOverviewPageObject.getFormDetailsUser()).getText();
	}

	public void editTextField(String updateTextField) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(FormsOverviewPageObject.getUpdateFormTextField())));
		$(FormsOverviewPageObject.getUpdateFormTextField()).clear();
		$(FormsOverviewPageObject.getUpdateFormTextField()).sendKeys(updateTextField);

	}

	public void clickSubmitEditFormButton() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getEditFormSubmitButton())));
		$(FormsOverviewPageObject.getEditFormSubmitButton()).click();

	}

	public void verifyFormDetailsWereUpdated(String newTextField) {
		String formDetail = getFormDetails().split("\\r?\\n")[1];
//		System.out.println(">>>formDetail" + formDetail);
		assertEquals(newTextField, formDetail);
	}

	public void clickAssignForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getFormAssignButton())));
		$(FormsOverviewPageObject.getFormAssignButton()).click();
		
		
		
	}

	public void assignUser(String user) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getAssignUserTextField())));
		$(FormsOverviewPageObject.getAssignUserTextField()).click();
		WebElement userUL = driver.findElement(By.xpath(FormsOverviewPageObject.getAssignUserDropDown()));
		List<WebElement> userIL = userUL.findElements(By.tagName("li"));
		for (WebElement li : userIL) {
			if (li.getText().equals(user)) {
				li.click();
			}
		}
	}

	public void clickSubmitAssignFormButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FormsOverviewPageObject.getAssignSubmitButton())));
		$(FormsOverviewPageObject.getAssignSubmitButton()).click();
		
	}

	public void verifyNewUserWasAssigned(String newTextField) {
		assertEquals(newTextField, getFormUserAssigned());
	}

	public void selectCreatedInspection (String formCateg, String formName) throws Exception {
		this.navigateToOverviewSection();
		this.clickCreateNewFormButton();
		this.selectFormCategory(formCateg);
		this.selectForm(formName);


	}
	public void fillMandatoryFieldsSch() {
		$(FormsOverviewPageObject.getMandatoryField1Sch()).sendKeys("input1test");
		$(FormsOverviewPageObject.getMandatoryField2Sch()).sendKeys("textarea");
	}
	public void fillMandatoryFieldsSch2() {
		$(FormsOverviewPageObject.getMandatoryField3Sch()).sendKeys("Another Text Area");
		$(FormsOverviewPageObject.getMandatoryField4Sch()).sendKeys("adrian.gheorghe@opinsta.com");
		$(FormsOverviewPageObject.getMandatoryField5Sch()).sendKeys("OpinstaRef");
	}

}
