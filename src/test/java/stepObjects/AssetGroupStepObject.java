package stepObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.TemplatePageObject;
import pageObjects.LeftSideMenuPageObject;
import utils.BaseClass;

public class AssetGroupStepObject extends BaseClass {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public AssetGroupStepObject(WebDriver driver) {
        super(driver);
    }

    
    public void addNewAssetGroup (String assetGroupName) {
        wait_for_id_elem_to_be_clickable(TemplatePageObject.getAddNewAssetGroupButton(), 10);
        $(TemplatePageObject.getAddNewAssetGroupButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TemplatePageObject.getNameAssetGroupField())));
        $(TemplatePageObject.getNameAssetGroupField()).sendKeys(assetGroupName);
        $(TemplatePageObject.getAssetGroupSaveButton()).click();
    }

    public void navigateToTemplatePage() {
        scrollToXpathElement(LeftSideMenuPageObject.getDefectSetupButton());
        $(LeftSideMenuPageObject.getDefectSetupButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getDefectTemplatesButton())));
        $(LeftSideMenuPageObject.getDefectTemplatesButton()).click();
    }

  
//    public void editAssetGroup() {
//    	scrollToXpathElement(ManageContractorsPageObject.getSetupButton());
//        $(ManagePageObject.getSetupButton()).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManagePageObject.getAssetGroup())));
//        $(ManagePageObject.getAssetGroup()).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManagePageObject.getCreatedAsset())));
//        $(ManagePageObject.getCreatedAsset()).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManagePageObject.getEditAsset())));
//        $(ManagePageObject.getEditAsset()).click();
//        $(ManagePageObject.getEditAssetGroup()).clear();
//		$(ManagePageObject.getEditAssetGroup()).sendKeys(assetGroup);
//        $(ManagePageObject.getUpdateAssetGroupButton()).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManagePageObject.getEditCreatedAsset())));
//    }

}
