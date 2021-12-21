package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.GuidancePageObject;
import pageObjects.LeftSideMenuPageObject;
import utils.BaseClass;

public class GuidanceStepObject extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public GuidanceStepObject(WebDriver driver) {
		super(driver);
	}

	public void addNewGuidance(String guidanceTitle) {
		clickSetupMenu();
		getToGuidanceSection();
		clickAddNewGuidanceButton();
		fillGuidanceTitle(guidanceTitle);
		clickSaveButton();
		verifyGuidanceSuccessfullySavedMessage();
	}

	public void addGuidanceWithoutMandatoryFields() {
		this.clickSetupMenu();
		this.getToGuidanceSection();
		this.clickAddNewGuidanceButton();
		this.clickSaveButton();
	}

	public void cancelCreatingGuidance(String guidanceTitle) {
		this.clickSetupMenu();
		this.getToGuidanceSection();
		this.clickAddNewGuidanceButton();
		this.fillGuidanceTitle(guidanceTitle);
		this.clickCancelButton();
	}

	public void addNewGuidanceWithAttachments(String guidTitle, String URL, String pdfFile) {
		clickSetupMenu();
		getToGuidanceSection();
		clickAddNewGuidanceButton();
		fillGuidanceTitle(guidTitle);
		clickAttachmentsButton();
		clickURLButton();
		fillURLLink(URL);
		clickSaveURLButton();
		verifyUrlWasAdded(URL);
		clickAttachmentsButton();
		selectPdfAndVerify(pdfFile);
		clickSaveButton();
	}

	public void clickSetupMenu() {
		scrollToXpathElement(LeftSideMenuPageObject.getCalendarSetupButton());
		$(LeftSideMenuPageObject.getCalendarSetupButton()).click();
	}

	public void getToGuidanceSection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getGuidanceLeftMenu())));
		$(LeftSideMenuPageObject.getGuidanceLeftMenu()).click();
	}

	public void clickAddNewGuidanceButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(GuidancePageObject.getAddNewGuidanceButton())));
		$(GuidancePageObject.getAddNewGuidanceButton()).click();

	}

	public void fillGuidanceTitle(String guidanceTitle) {
		$(GuidancePageObject.getGuidanceTitle()).sendKeys(guidanceTitle);

	}

	public void clickSaveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(GuidancePageObject.getSaveButton())));
		$(GuidancePageObject.getSaveButton()).click();

	}

	public void verifyGuidanceSuccessfullySavedMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(GuidancePageObject.getGuidanceSavedMessage())));
		assertEquals($(GuidancePageObject.getGuidanceSavedMessage()).getText(), "Guidance created successfully.",
				"Guidance message is:");
	}

	public void verifyGuidanceSaved(String guidanceTitle) throws Exception {
		$(GuidancePageObject.getGuidanceSearchBar()).sendKeys(guidanceTitle);
		Thread.sleep(500);
		$(GuidancePageObject.getGuidanceSearchBar()).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		$(GuidancePageObject.getGuidanceSearchBar()).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		$(GuidancePageObject.getGuidanceSearchBar()).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		String selector = String.format(GuidancePageObject.getGuidanceInTable(), guidanceTitle);
		assertTrue($(selector).isDisplayed());
		assertEquals($(selector).getText(), guidanceTitle);
	}

	public void verifyGuidanceMandatoryField() {
		assertEquals($(GuidancePageObject.getGuidanceMandatoryField()).getText(),
				"  Error! Please insert the guidance title!");

	}

	public void verifyGuidanceNotSaved(String cancelGuidance) {
		$(GuidancePageObject.getGuidanceSearchBar()).sendKeys(cancelGuidance);
		String selector = String.format(GuidancePageObject.getGuidanceInTable(), cancelGuidance);
		List<WebElement> assets = elems(selector);
		assertTrue(assets.size() == 0);

	}

	public void clickCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GuidancePageObject.getCancelButton())));
		$(GuidancePageObject.getCancelButton()).click();

	}

	public void clickAttachmentsButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(GuidancePageObject.getAttachmentsButton())));
		$(GuidancePageObject.getAttachmentsButton()).click();
	}

	public void clickURLButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GuidancePageObject.getUrlButton())));
		$(GuidancePageObject.getUrlButton()).click();

	}
	
	public void fillURLLink(String URL) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(GuidancePageObject.getUrlLinkBox())));
		$(GuidancePageObject.getUrlLinkBox()).clear();
		$(GuidancePageObject.getUrlLinkBox()).sendKeys(URL);
	}
	
	public void clickSaveURLButton() {
		$(GuidancePageObject.getUrlSaveButton()).click();
		
	}
	
	public void verifyUrlWasAdded(String URL) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GuidancePageObject.getUrlAttachementsSection())));
		String urlAttach = $(GuidancePageObject.getUrlAttachementsSection()).getText().trim();
		assertEquals(URL, urlAttach);
		
	}
	
	public void selectPdfAndVerify(String pdfFileName) {
		File file = new File(System.getProperty("user.dir") + "/files/" + pdfFileName);
		String path = file.getAbsolutePath();
		$(GuidancePageObject.getPdfFileButton()).sendKeys(path);
		String pdfNameInAttach = $(GuidancePageObject.getPdfAttachmentsSection()).getText();
		assertEquals(pdfFileName, pdfNameInAttach.trim());
	}

}
