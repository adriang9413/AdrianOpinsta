package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AssetPageObject;
import pageObjects.FormsOverviewPageObject;
import pageObjects.LeftSideMenuPageObject;
import tests.AssetGroupTests;
import utils.BaseClass;

public class AssetStepObject extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public AssetStepObject(WebDriver driver) {
		super(driver);
	}



	public void addNewAsset(String assetGroupName, String firstSubcategory) throws Exception {
		this.clickAddAssetButton();
		this.selectAssetGroup(assetGroupName);
		this.fillFirstSubcategory(firstSubcategory);
		this.clickSaveButton();
	}

//	public void addAssetWithoutMandatoryFields() {
//		this.clickSetupMenu();
//		this.navigateToAssetPage();
//		this.clickAddAssetButton();
//		this.clickSaveButton();
//
//	}
//	public void cancelCreatingAsset(String assetGroupName, String cancelFirstSubcat) throws Exception {
//		this.clickSetupMenu();
//		this.navigateToAssetPage();
//		this.clickAddAssetButton();
//		this.fillFirstSubcategory(cancelFirstSubcat);
//		this.selectAssetGroup(assetGroupName);
//		this.clickCancelButton();
//	}

	public void clickSetupMenu() {
		scrollToXpathElement(LeftSideMenuPageObject.getDefectSetupButton());
		$(LeftSideMenuPageObject.getDefectSetupButton()).click();
	}

	public void navigateToAssetPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getAssetLeftMenu())));
		$(LeftSideMenuPageObject.getAssetLeftMenu()).click();
	}

	public void clickAddAssetButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AssetPageObject.getAddNewAssetButton())));
		$(AssetPageObject.getAddNewAssetButton()).click();

	}

	public void selectAssetGroup(String assetGrName) throws Exception {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(AssetPageObject.getAssetGroupBtn())));
		$(AssetPageObject.getAssetGroupBtn()).click();
		WebElement assetGroupUL = driver.findElement(By.id(AssetPageObject.getAssetGroupNameDropdown()));
		List<WebElement> assetGroupIL = assetGroupUL.findElements(By.tagName("li"));
		for (WebElement li : assetGroupIL) {
			if (li.getText().equals(assetGrName)) {
				li.click();
				break;
			}
		}
	}

	public void fillFirstSubcategory(String firstSubcategory) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AssetPageObject.getAssetFirstSubcategory())));
		$(AssetPageObject.getAssetFirstSubcategory()).clear();
		$(AssetPageObject.getAssetFirstSubcategory()).sendKeys(firstSubcategory);
	}

	public void clickSaveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AssetPageObject.getAssetSaveButton())));
		$(AssetPageObject.getAssetSaveButton()).click();
	}

	public void verifyAssetSuccessfullySavedMessage() {
		wait_for_id_elem_to_be_clickable(AssetPageObject.getAssetSavedMessage(), 10);
		assertEquals($(AssetPageObject.getAssetSavedMessage()).getText(), "Asset created successfully.","Asset message is:");
	}

	public void verifyAssetSaved(String firstSubcategory) {
		$(AssetPageObject.getAssetSearch()).sendKeys(firstSubcategory);
		String selector = String.format(AssetPageObject.getAssetInTable(), firstSubcategory);
		assertTrue($(selector).isDisplayed());

	}

	public void verifyAssetMandatoryFilds() {
		assertEquals($(AssetPageObject.getAssetGroupNameMandatoryError()).getText(),
				"  Error! Please complete this field or choose an active asset group");
		assertEquals($(AssetPageObject.getAssetFirstSubCategoryMandatoryError()).getText(),
				"  Error! Please insert the first subcategory or remove the second subcategory!");

	}

	public void clickCancelButton() {
		$(AssetPageObject.getCancelButton()).click();
	}

	public void verifyAssetNotSaved(String cancelFirstSubcat) {
		$(AssetPageObject.getAssetSearch()).sendKeys(cancelFirstSubcat);
		String selector = String.format(AssetPageObject.getAssetInTable(), cancelFirstSubcat);
		List<WebElement> assets = elems(selector);
		assertTrue(assets.size() == 0);

	}

}
