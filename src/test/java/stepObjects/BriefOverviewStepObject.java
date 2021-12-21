package stepObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.*;
import utils.BaseClass;

import java.io.IOException;
import java.util.List;

public class BriefOverviewStepObject extends BaseClass {

    public BriefOverviewStepObject(WebDriver driver) {
        super(driver);
    }

    public void accessBriefOverviewPage() {
        scrollToXpathElement(LeftSideMenuPageObject.getBriefOverviewButton());
        $(LeftSideMenuPageObject.getBriefOverviewButton()).click();
    }

    public void createNewBrief() {
        wait_for_xpath_elem_to_be_clickable(BriefOverviewPageObject.getAddBriefButton(), 10);
        $(BriefOverviewPageObject.getAddBriefButton()).click();
    }

    public void previewBrief() {
        wait_for_xpath_elem_to_be_clickable(BriefCreatePageObject.getPreviewButtonBrief(), 10);
        scrollToXpathElement(BriefCreatePageObject.getPreviewButtonBrief());
        $(BriefCreatePageObject.getPreviewButtonBrief()).click();
    }

    public void launchBrief() {
        wait_for_id_elem_to_be_clickable(BriefCreatePageObject.getLaunchBriefButton(), 10);
        $(BriefCreatePageObject.getLaunchBriefButton()).click();
    }

    public void updateBrief() {
        wait_for_id_elem_to_be_clickable(BriefCreatePageObject.getUpdateBriefButton(), 10);
        $(BriefCreatePageObject.getUpdateBriefButton()).click();
    }

    public void viewAndRateBrief() {
        wait_for_xpath_elem_to_be_clickable(BriefDetailsPageObject.getViewButtonBrief(), 10);
        $(BriefDetailsPageObject.getViewButtonBrief()).click();
        wait_for_xpath_elem_to_be_clickable(BriefDetailsPageObject.getCloseButtonBrief(), 10);
        $(BriefDetailsPageObject.getCloseButtonBrief()).click();
        wait_for_xpath_elem_to_be_clickable(BriefDetailsPageObject.getConfirmReadButtonBrief(), 10);
        $(BriefDetailsPageObject.getConfirmReadButtonBrief()).click();
        wait_for_xpath_elem_to_be_clickable(BriefDetailsPageObject.getOneStarRating(), 10);
        $(BriefDetailsPageObject.getOneStarRating()).click();
        $(BriefDetailsPageObject.getConfirmRatingButton()).click();
    }

    public void selectBrief(String title) throws Exception {
        wait_for_id_elem_to_be_visible(BriefOverviewPageObject.getBriefTitleSearchBar(), 10);
        $(BriefOverviewPageObject.getBriefTitleSearchBar()).sendKeys(title);
        wait_for_xpath_elem_to_be_clickable(BriefOverviewPageObject.getBriefFromTable(), 10);
        scrollToXpathElement(BriefOverviewPageObject.getBriefFromTable());
        Thread.sleep(1000);
        $(BriefOverviewPageObject.getBriefFromTable()).click();
    }

    public void editBrief() {
        wait_for_id_elem_to_be_clickable(BriefDetailsPageObject.getThreeDots(), 10);
        $(BriefDetailsPageObject.getThreeDots()).click();
        wait_for_id_elem_to_be_clickable(BriefDetailsPageObject.getUpdateButton(), 10);
        $(BriefDetailsPageObject.getUpdateButton()).click();
    }

    public void addUserToBriefAudience(String user) throws IOException {
        wait_for_id_elem_to_be_clickable(BriefDetailsPageObject.getThreeDots(), 10);
        $(BriefDetailsPageObject.getThreeDots()).click();
        wait_for_id_elem_to_be_clickable(BriefDetailsPageObject.getManageDistribution() , 10);
        $(BriefDetailsPageObject.getManageDistribution()).click();
        wait_for_xpath_elem_to_be_visible(BriefManageDistributionPageObject.getUserInsert(), 10);
        $(BriefManageDistributionPageObject.getUserInsert()).click();
        selectDropdownByText(BriefManageDistributionPageObject.getUserSelect(), user);
        $(BriefManageDistributionPageObject.getConfirmButton()).click();
    }

    public void removeUserFromBriefAudience() {
        wait_for_id_elem_to_be_clickable(BriefDetailsPageObject.getThreeDots(), 10);
        $(BriefDetailsPageObject.getThreeDots()).click();
        wait_for_id_elem_to_be_clickable(BriefDetailsPageObject.getManageDistribution() , 10);
        $(BriefDetailsPageObject.getManageDistribution()).click();
        wait_for_xpath_elem_to_be_clickable(BriefManageDistributionPageObject.getRemoveFirstUserButton(), 10);
        $(BriefManageDistributionPageObject.getRemoveFirstUserButton()).click();
        $(BriefManageDistributionPageObject.getConfirmButton()).click();
    }

    public void closePreview() throws InterruptedException {
        Thread.sleep(1000);
        wait_for_xpath_elem_to_be_clickable(BriefCreatePageObject.getClosePreviewButtonBrief(), 10);
        $(BriefCreatePageObject.getClosePreviewButtonBrief()).click();
    }

    public void completeMandatoryFields(String title, String category, String group, String details, String date) {
        wait_for_xpath_elem_to_be_visible(BriefCreatePageObject.getInsertTitleBrief(), 10);
        $(BriefCreatePageObject.getInsertTitleBrief()).sendKeys(title);
        $(BriefCreatePageObject.getInputCategoryBrief()).click();
        WebElement categoryUL = driver.findElement(By.xpath(BriefCreatePageObject.getCategoryDropdownBrief()));
        List<WebElement> categoryIL = categoryUL.findElements(By.tagName("li"));
        for (WebElement li : categoryIL) {
            if (li.getText().equals(category)) {
                li.click();
            }
        }
        $(BriefCreatePageObject.getInputGroupBrief()).click();
        WebElement userUL = driver.findElement(By.xpath(BriefCreatePageObject.getGroupDropdownBrief()));
        List<WebElement> userIL = userUL.findElements(By.tagName("li"));
        for (WebElement li : userIL) {
            if (li.getText().equals(group)) {
                li.click();
            }
        }
        $(BriefCreatePageObject.getInsertBriefDetails()).sendKeys(details);
        $(BriefCreatePageObject.getInputDate()).sendKeys(date);
    }

    public void editBriefCategoryAndDate(String category2, String date) {
        wait_for_xpath_elem_to_be_visible(BriefEditPageObject.getEditInputCategory(), 10);
        $(BriefEditPageObject.getEditInputCategory()).click();
        selectDropdownByText(BriefEditPageObject.getSelectCategory(), category2);
        $(BriefCreatePageObject.getInputDate()).sendKeys(date);
    }

    public void editBriefDescription(String newDescription) {
        wait_for_xpath_elem_to_be_visible(BriefCreatePageObject.getInsertBriefDetails(), 10);
        $(BriefCreatePageObject.getInsertBriefDetails()).sendKeys(newDescription);
    }
}