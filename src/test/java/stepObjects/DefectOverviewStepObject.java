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

import pageObjects.DefectOverviewPageObject;
import pageObjects.LeftSideMenuPageObject;
import utils.BaseClass;

public class DefectOverviewStepObject extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public DefectOverviewStepObject(WebDriver driver) {
		super(driver);
	}

	public void createReport(String assetGroupName, String firstSubCateg, String problem) throws Exception {
		clickDefectOverviewMenu();
		clickCreateReportButton();
		selectAssetGroup(assetGroupName);
		selectFirstSubcategory(firstSubCateg);
		selectProblem(problem);
		clickContinueReportButton();
		completeMandatoryFields();
		clickSaveReportButton();
	}

	public void clickDefectOverviewMenu() {
		$(LeftSideMenuPageObject.getDefectOverviewButton()).click();
	}

	public void clickCreateReportButton() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(DefectOverviewPageObject.getCreateReportButton())));
		$(DefectOverviewPageObject.getCreateReportButton()).click();
	}

	public void selectAssetGroup(String assetGroupName) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DefectOverviewPageObject.getSelectAssetGroupField())));
		$(DefectOverviewPageObject.getSelectAssetGroupField()).click();

		WebElement assetGroupUL = driver.findElement(By.xpath(DefectOverviewPageObject.getListOfAssetGroups()));
		List<WebElement> assetGroupIL = assetGroupUL.findElements(By.tagName("li"));
		for (WebElement li : assetGroupIL) {
			if (li.getText().equals(assetGroupName)) {
				li.click();
			}
		}
//		selectFromListByText(DefectOverviewPageObject.getAssetGroupName(), assetGroupName);
		// production
//		Select assetGroup = new Select($(DefectOverviewPageObject.getAssetGroupDropdown()));
//		assetGroup.selectByVisibleText(assetGroupName);

	}

	public void selectFirstSubcategory(String firstSubcategory) throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DefectOverviewPageObject.getAssetBox())));
		$(DefectOverviewPageObject.getSelectFirstSubcategoryField()).click();
		Thread.sleep(1000);
		WebElement assetGroupUL = driver.findElement(By.xpath(DefectOverviewPageObject.getListOfSubCat1()));
		List<WebElement> assetGroupIL = assetGroupUL.findElements(By.tagName("li"));
		for (WebElement li : assetGroupIL) {
			if (li.getText().equals(firstSubcategory)) {
				li.click();
			}
		}
//		String selector = String.format(DefectOverviewPageObject.getAssetGroupName(), firstSubcategory);
//		$(selector).click();

		// production
//		Select assetGroup = new Select($(DefectOverviewPageObject.getFirstSubcategoryDropdown()));
//		assetGroup.selectByVisibleText(firstSubcategory);

	}

	public void selectSecondSubcategory(String assetSecondSub) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DefectOverviewPageObject.getAssetBox2())));
		$(DefectOverviewPageObject.getAssetBox2()).click();
		String selector = String.format(DefectOverviewPageObject.getAssetGroupName(), assetSecondSub);
		$(selector).click();
	}
	public void selectThirdSubcategory(String assetThirdSub) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DefectOverviewPageObject.getAssetBox3())));
		$(DefectOverviewPageObject.getAssetBox3()).click();
		String selector = String.format(DefectOverviewPageObject.getAssetGroupName(), assetThirdSub);
		$(selector).click();
	}

	public void selectProblem(String problem) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DefectOverviewPageObject.getSelectProblemField())));
		$(DefectOverviewPageObject.getSelectProblemField()).click();

		WebElement assetGroupUL = driver.findElement(By.xpath(DefectOverviewPageObject.getListOfProblems()));
		List<WebElement> assetGroupIL = assetGroupUL.findElements(By.tagName("li"));
		for (WebElement li : assetGroupIL) {
			if (li.getText().equals(problem)) {
				li.click();
			}
		}
	}

	public void clickContinueReportButton() throws Exception {
		Thread.sleep(500);
		if ($(DefectOverviewPageObject.getContinueReportButton()).isDisplayed()) {
			$(DefectOverviewPageObject.getContinueReportButton()).click();
		}
	}

	public void clickSaveReportButton() {
		$(DefectOverviewPageObject.getSaveCreateReportButton()).click();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void verifyReportCreated() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DefectOverviewPageObject.getReportDetailsTitle())));
		String reportPageTitle = $(DefectOverviewPageObject.getReportDetailsTitle()).getText();
		Thread.sleep(1000);
		assertTrue(reportPageTitle.contains("Report"));
	}

	public void getReportIdentifier() {
		wait_for_xpath_elem_to_be_visible(DefectOverviewPageObject.getDefectReportReference(), 50);
		$(DefectOverviewPageObject.getDefectReportReference()).getText();
	}

	public void verifyReportFields(String assetGroupName, String assetFirstSubcat, String problemFirstLevel) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DefectOverviewPageObject.getViewMoreButton())));
		if ($(DefectOverviewPageObject.getViewMoreLessLabel()).getText().equals("view more")) {
			$(DefectOverviewPageObject.getViewMoreButton()).click();
		}
		String assetGr = $(DefectOverviewPageObject.getDefectReportAssetGroup()).getText();
		String firstSubcategory = $(DefectOverviewPageObject.getDefectReprtAsset()).getText();
		String firstLevel = $(DefectOverviewPageObject.getDefectReportProblem()).getText();

		assertEquals(assetGroupName, assetGr);
		assertEquals(assetFirstSubcat, firstSubcategory);
		assertEquals(problemFirstLevel, firstLevel);
	}
	public void verifyAllFields(String assetGroupName,String assetFirstSub,	String problemLevel) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DefectOverviewPageObject.getViewMoreButton())));
		if ($(DefectOverviewPageObject.getViewMoreLessLabel()).getText().equals("view more")) {
			$(DefectOverviewPageObject.getViewMoreButton()).click();
		}
		String assetGr = $(DefectOverviewPageObject.getDefectReportAssetGroup()).getText();
		List<WebElement> allSubcategories = elems(DefectOverviewPageObject.getDefectReprtAsset());
		String firstSubcategory = allSubcategories.get(0).getText();
//		String secondSubcategory = allSubcategories.get(1).getText();
//		String thirdSubcategory = allSubcategories.get(2).getText();
		String firstLevel = $(DefectOverviewPageObject.getDefectReportProblem()).getText();

		assertEquals(assetGroupName, assetGr);
		assertEquals(assetFirstSub, firstSubcategory);
		assertEquals(problemLevel, firstLevel);
		
	}

	public void editReportAddSupportingImage() {
		this.clickActionsButton();
		this.clickEditReportButton();
		this.clickAddSupportingImage();
		this.clickUploadButton();

	}

	public void clickActionsButton() {
		$(DefectOverviewPageObject.getDefectReportsActionsButton()).click();
	}

	public void clickEditReportButton() {
		$(DefectOverviewPageObject.getEditReportButton()).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddSupportingImage() {
		String filename = "blackCat.jpg";
		File file = new File(System.getProperty("user.dir") + "/images/" + filename);
		String path = file.getAbsolutePath();
		$(DefectOverviewPageObject.getAddPhotoButton()).sendKeys(path);
		String pictureName = $(DefectOverviewPageObject.getUploadedFileName()).getText();
		assertEquals(filename, pictureName.trim());

	}

	public void clickUploadButton() {
		$(DefectOverviewPageObject.getUploadButton()).click();
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyImageAddedToReport() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(DefectOverviewPageObject.getDefectReportImageRightButton())));
		$(DefectOverviewPageObject.getDefectReportImageRightButton()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DefectOverviewPageObject.getImageRight())));
		assertTrue($(DefectOverviewPageObject.getImageRight()).isDisplayed());
//		assertTrue($(DefectOverviewPageObject.getEnlargeButton()).isDisplayed());
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(DefectOverviewPageObject.getCloseImageButton())));
		$(DefectOverviewPageObject.getCloseImageButton()).click();

	}

	public void editReportAddContractor(String contractorName, String description) throws Exception {
		this.clickActionsButton();
		this.clickChangeContractor();
		this.selectContractor(contractorName);
		this.addContractorDescription(description);
		this.clickUpdateContractorButton();

	}

	public void clickUpdateContractorButton() throws Exception {
		$(DefectOverviewPageObject.getUpdateContractorButton()).click();
		Thread.sleep(2000);
	}

	public void selectContractor(String contractorName) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(DefectOverviewPageObject.getSearchContractor())));
		$(DefectOverviewPageObject.getSearchContractor()).clear();
		$(DefectOverviewPageObject.getSearchContractor()).sendKeys(contractorName);
		$(DefectOverviewPageObject.getSearchContractor()).click();
		String str = String.format(DefectOverviewPageObject.getSelectContractor(), contractorName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
		$(str).click();
	}

	public void addContractorDescription(String description) {
		$(DefectOverviewPageObject.getDescriptionContractor()).clear();
		$(DefectOverviewPageObject.getDescriptionContractor()).sendKeys(description);
	}

	public void clickChangeContractor() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(DefectOverviewPageObject.getActionsChangeContractor())));
		$(DefectOverviewPageObject.getActionsChangeContractor()).click();
	}

	public void verifyContractorAddedToReport(String contractorName) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(DefectOverviewPageObject.getContractorRightButton())));
		$(DefectOverviewPageObject.getContractorRightButton()).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(DefectOverviewPageObject.getContractorNameRight())));
		String contractor = $(DefectOverviewPageObject.getContractorNameRight()).getText();
		assertEquals(contractorName, contractor);
		$(DefectOverviewPageObject.getCloseContractorRightButton()).click();

	}

	public void editReportChangeStatus(String status, String description) throws Exception {
		this.clickActionsButton();
		this.clickUpdateStatusButton();
		this.updateStatus(status);
		this.addStatusDescription(description);
		this.clickSaveStatusButton();

	}

	public void clickUpdateStatusButton() throws Exception {
		$(DefectOverviewPageObject.getUpdateStatusButton()).click();
		Thread.sleep(1000);
	}

	public void updateStatus(String status) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(DefectOverviewPageObject.getUpdateStatusField())));
		$(DefectOverviewPageObject.getUpdateStatusField()).click();
		WebElement UL = driver.findElement(By.xpath(DefectOverviewPageObject.getUpdateStatusDropdownReport()));
		List<WebElement> IL = UL.findElements(By.tagName("li"));
		for (WebElement li : IL) {
			if (li.getText().equals(status)) {
				li.click();
				break;
			}
		}
	}

	public void addStatusDescription(String description) {
		$(DefectOverviewPageObject.getUpdateStatusDescription()).clear();
		$(DefectOverviewPageObject.getUpdateStatusDescription()).sendKeys(description);

	}

	private void clickSaveStatusButton() {
		$(DefectOverviewPageObject.getSaveStatusButton()).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyStatusChanged(String status) throws InterruptedException {
		Thread.sleep(1000);
		if ($(DefectOverviewPageObject.getViewMoreLessLabel()).getText().equals("view more")) {
			$(DefectOverviewPageObject.getViewMoreButton()).click();
		}
		String statusInReport = $(DefectOverviewPageObject.getStatusInReport()).getText();
		assertEquals(status, statusInReport);

	}

	public void accessExistingDefectReport(String identifier) throws InterruptedException {
		wait_for_id_elem_to_be_clickable(DefectOverviewPageObject.getDefectsSearchBar(), 50);
		$(DefectOverviewPageObject.getDefectsSearchBar()).sendKeys(identifier);
		$(DefectOverviewPageObject.getDefectsSearchBar()).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		$(DefectOverviewPageObject.getFirstDefectReport()).click();
	}

	public void completeMandatoryFields(){
		$(DefectOverviewPageObject.getCheckboxOption1()).click();
	}

	public void editReportFields(String content){
		$(DefectOverviewPageObject.getEditMandatoryField()).sendKeys(content);
		$(DefectOverviewPageObject.getUpdateEditedReportButton()).click();
	}

	public void accessDefectTemplates(){
		$(LeftSideMenuPageObject.getDefectSetupButton()).click();
		$(LeftSideMenuPageObject.getDefectTemplatesButton()).click();
	}

	public void selectFirstTemplate(){
		wait_for_id_elem_to_be_visible(DefectOverviewPageObject.getMainTable(), 50);
		$(DefectOverviewPageObject.getEditTemplateButton()).click();
	}

	public void modifyElementsActiveStatus() throws InterruptedException {
		Thread.sleep(2000);
		$(DefectOverviewPageObject.getActiveElements()).click();

		List<WebElement> lista = driver.findElements(By.xpath("//table[@id='table-active-reports']/tbody/tr"));
		System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			Thread.sleep(2000);
			if($(DefectOverviewPageObject.getActiveElements()).getText() != "No data available in table") {
				$(DefectOverviewPageObject.getActiveElements()).click();
//				wait_for_xpath_elem_to_be_clickable(DefectOverviewPageObject.getElementEditButton(), 50);
//				$(DefectOverviewPageObject.getElementEditButton()).click();
				wait_for_xpath_elem_to_be_clickable(DefectOverviewPageObject.getActivateButton(), 50);
				$(DefectOverviewPageObject.getActivateButton()).click();
				$(DefectOverviewPageObject.getUpdateElementButton()).click();
				Thread.sleep(3000);
			} else break;
		}
	}

	public void modifyElementsInactiveStatus() throws InterruptedException {
		Thread.sleep(2000);
		$(DefectOverviewPageObject.getInactiveElementsTabTemplateReports()).click();

		List<WebElement> lista = driver.findElements(By.xpath("//table[@id='table-disable-reports']/tbody/tr"));
		for (int i = 0; i < lista.size(); i++) {
			Thread.sleep(1000);
			if($(DefectOverviewPageObject.getInactiveElements()).getText() != "No data available in table") {
				$(DefectOverviewPageObject.getInactiveElements()).click();
//				wait_for_xpath_elem_to_be_clickable(DefectOverviewPageObject.getElementEditButton(), 50);
//				$(DefectOverviewPageObject.getElementEditButton()).click();
				wait_for_xpath_elem_to_be_clickable(DefectOverviewPageObject.getActivateButton(), 50);
				$(DefectOverviewPageObject.getActivateButton()).click();
				$(DefectOverviewPageObject.getUpdateElementButton()).click();
				Thread.sleep(3000);
			} else break;
		}
	}

	public void searchForTemplate(String name){
		wait_for_id_elem_to_be_visible(DefectOverviewPageObject.getTemplateSearchBar(), 50);
		$(DefectOverviewPageObject.getTemplateSearchBar()).sendKeys(name);
		$(DefectOverviewPageObject.getTemplateSearchBar()).sendKeys(Keys.ENTER);
	}

	public void addNewElement(String type){
		$(DefectOverviewPageObject.getAddNewElement()).click();
		wait_for_id_elem_to_be_clickable(DefectOverviewPageObject.getElementCloseButton(), 50);
		$("create-"+type).click();
	}

	public void addExtraOptions(int nr){
		wait_for_id_elem_to_be_clickable(DefectOverviewPageObject.getAddNewOptionButton(), 50);
		for(int i=0; i<nr; i++){
			$(DefectOverviewPageObject.getAddNewOptionButton()).click();
		}
	}

	public void completeCheckboxOptionFields(String name, String[] op){
		$(DefectOverviewPageObject.getSectionNameFieldAddNewReport()).sendKeys(name);
		List<WebElement> list = driver.findElements(By.xpath(DefectOverviewPageObject.getCheckboxOptionFields()));
		for(int i=0;i<list.size();i++){
			list.get(i).sendKeys(op[i]);
		}
	}

	public void saveElement(){
		$(DefectOverviewPageObject.getSaveElement()).click();
	}

	public void previewAndCloseTemplate() throws Exception {
		wait_for_id_elem_to_be_clickable(DefectOverviewPageObject.getPreviewForm(),10);
		Thread.sleep(2500);
		$(DefectOverviewPageObject.getPreviewForm()).click();
		wait_for_xpath_elem_to_be_clickable(DefectOverviewPageObject.getClosePreviewButtonReport(), 10);
		scrollToXpathElement(DefectOverviewPageObject.getClosePreviewButtonReport());
		$(DefectOverviewPageObject.getClosePreviewButtonReport()).click();
	}

	public String getActualReportIdentifier(){
		return $(DefectOverviewPageObject.getDefectReportReference()).getText();
	}
}
