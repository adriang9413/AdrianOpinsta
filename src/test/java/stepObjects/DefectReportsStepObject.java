package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.DefectOverviewPageObject;
import pageObjects.DefectReportPageObject;
import pageObjects.LeftSideMenuPageObject;
import utils.BaseClass;

public class DefectReportsStepObject extends BaseClass {
	

	public DefectReportsStepObject(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);
	

	public void addNewDefectReport(String asset, String section_name, String option1, String option2) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getDefectSetupButton())));
		$(LeftSideMenuPageObject.getDefectSetupButton()).click();

		$(DefectReportPageObject.getDefectReportsMenuButton()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DefectReportPageObject.getEditReportButton())));
		$(DefectOverviewPageObject.getDefectsSearchBar()).sendKeys(asset);
		$(DefectReportPageObject.getEditReportButton()).click();
		Thread.sleep(2000);

		$(DefectReportPageObject.getAddNewReport()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DefectReportPageObject.getRadioElement())));
		$(DefectReportPageObject.getRadioElement()).click();
		$(DefectReportPageObject.getSectionName()).sendKeys(section_name);
		$(DefectReportPageObject.getOption1()).sendKeys(option1);
		$(DefectReportPageObject.getOption2()).sendKeys(option2);
		$(DefectReportPageObject.getSaveForm()).click();
	}

	public void addNewDefectReportWithCheckBox(String assetGroupName,String section_name, String option1, String option2) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getDefectSetupButton())));
		$(LeftSideMenuPageObject.getDefectSetupButton()).click();
		$(DefectReportPageObject.getDefectReportsMenuButton()).click();
		this.searchAssetGroupName(assetGroupName);
		this.editReport();
		this.clickCheckBoxButton();
		this.fillCheckBoxOptions(section_name, option1, option2);
	}

	public void formPreview(String section_name, String option1, String option2) throws InterruptedException {
		$(DefectReportPageObject.getFormPreview()).click();
		Thread.sleep(500);
//		goThroughMultipleStuff(DefectReportsObjectPage.getFormPreviewH5(), section_name);
		assertEquals($(DefectReportPageObject.getFormPreviewH5()).getText(), section_name, "Section name:");
		assertTrue(goThroughMultipleStuff(DefectReportPageObject.getFormPreviewOptionLabels(), option1), "First option:");
		assertTrue(goThroughMultipleStuff(DefectReportPageObject.getFormPreviewOptionLabels(), option2), "Second option");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DefectReportPageObject.getCloseModal())));
		$(DefectReportPageObject.getCloseFormPreview()).click();
	}

	public void editReport() throws InterruptedException {
		wait_for_id_elem_to_be_clickable(DefectReportPageObject.getActionsButton(), 50);
		$(DefectReportPageObject.getActionsButton()).click();
		$(DefectReportPageObject.getEditReportButton()).click();
	}

	public void searchAssetGroupName(String assetGroupName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DefectOverviewPageObject.getDefectsSearchBar())));
		$(DefectOverviewPageObject.getDefectsSearchBar()).sendKeys(assetGroupName);
	}

	public void clickCheckBoxButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DefectReportPageObject.getCheckboxElement())));
		$(DefectReportPageObject.getCheckboxElement()).click();
	}

	public void fillCheckBoxOptions(String section_name, String option1, String option2) {
		$(DefectReportPageObject.getSectionName()).sendKeys(section_name);
		$(DefectReportPageObject.getOption1()).sendKeys(option1);
		$(DefectReportPageObject.getOption2()).sendKeys(option2);
		$(DefectReportPageObject.getSaveForm()).click();
	}

	public void verifyReportWasCreated(String section_name) {
		String selector = String.format(DefectReportPageObject.getAssetGroupInDefectReportsTable(), section_name);
		Assert.assertTrue($(selector).getText().contains(section_name));
	}

}
