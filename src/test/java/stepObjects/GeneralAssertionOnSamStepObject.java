package stepObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import pageObjects.*;
import tests.CalendarFormTests;
import tests.CalendarWorkOrderTests;
import utils.BaseClass;

public class GeneralAssertionOnSamStepObject extends BaseClass{


	public GeneralAssertionOnSamStepObject(WebDriver driver) {
		super(driver);
	}
	
	public void assertLogin() {
		assertTrue($(DefectOverviewPage.getMyProfilePageSectionTitle()).getText().equals("My profile"));
	}

	public void assertAssetGroupCreated(String asset) throws Exception {
		Thread.sleep(2000);
		wait_for_id_elem_to_be_clickable(TemplatePageObject.getSearchAssetGroup(), 10);
		$(TemplatePageObject.getSearchAssetGroup()).sendKeys(asset);
		assertTrue($(TemplatePageObject.getFirstAssetGroupName()).getText().equals(asset));
	}

	public void assertBriefGroupCreated(String groupName) throws Exception {
		wait_for_id_elem_to_be_clickable(BriefGroupPageObject.getSearchBar(), 50);
		Thread.sleep(500);
		$(BriefGroupPageObject.getSearchBar()).sendKeys(groupName);
		assertTrue($(BriefGroupPageObject.getGroupName()).getText().equals(groupName));
	}

	public void assertBriefCategoryCreated(String categoryName) throws InterruptedException {
		Thread.sleep(1000);
		$(BriefCategoriesPageObject.getSearchBar()).sendKeys(categoryName);
		assertTrue($(BriefCategoriesPageObject.getCategoryName()).getText().equals(categoryName));
	}

	public void assertBriefCreated(String briefTitle) {
		wait_for_id_elem_to_be_visible(BriefDetailsPageObject.getBriefTitle(), 50);
		assertTrue($(BriefDetailsPageObject.getBriefTitle()).getText().equals(briefTitle));
	}

	public void assertBriefUpdate(String version) {
		wait_for_id_elem_to_be_visible(BriefDetailsPageObject.getBriefVersion(), 50);
		assertTrue($(BriefDetailsPageObject.getBriefVersion()).getText().equals(version));
	}

	public void assertUserAddedToBrief(String user){
		wait_for_xpath_elem_to_be_visible(BriefDetailsPageObject.getNewUser(), 50);
		assertTrue($(BriefDetailsPageObject.getNewUser()).getText().equals(user));
	}

	public void assertUserRemovedBrief(String user){
		wait_for_xpath_elem_to_be_visible(BriefDetailsPageObject.getAudienceUser(), 50);
		assertTrue($(BriefDetailsPageObject.getAudienceUser()).getText() != user);
	}

	public void assertBriefReadAndRated(String percentage) throws Exception {
		Thread.sleep(1000);
		assertTrue($(BriefDetailsPageObject.getCompletionPercentage()).getText().equals(percentage));
	}

	public void assertDefectReportUpdatedSuccessfully(String message) throws Exception {
		Thread.sleep(1000);
		assertTrue($(DefectOverviewPageObject.getConfirmDefectReportUpdatedAlert()).getText().equals(message));
	}

	public void assertNoMoreActiveElements(String content) throws Exception {
		Thread.sleep(1000);
		assertTrue($(DefectOverviewPageObject.getActiveTableContent()).getText().equals(content));
	}

	public void assertNoMoreInactiveElements(String content){
		assertTrue($(DefectOverviewPageObject.getInactiveTableContent()).getText().equals(content));
	}

	public void assertWorkOrderCreated(String workOrder) throws Exception {
		Thread.sleep(1000);
		WebElement elem = $("//*[@id='"+LoginStepObject.userID+"_"+ CalendarWorkOrderTests.hourBase1 +"_1']");
		assertTrue(elem.getText().contains(workOrder));
	}

	public void assertWorkOrderEdited(String workOrder) throws Exception {
		Thread.sleep(1000);
		WebElement elem = $("//*[@id='"+LoginStepObject.userID+"_"+ CalendarWorkOrderTests.hourBase2 +"_1']");
		assertTrue(elem.getText().contains(workOrder));
	}

	public void assertFormCreated(String form) throws Exception {
		Thread.sleep(2000);
		WebElement elem = $("//*[@id='"+LoginStepObject.userID+"_"+ CalendarFormTests.hourBase1 +"_1']");
		assertTrue(elem.getText().contains(form));
	}

	public void assertFormEdited(String form) throws Exception {
		Thread.sleep(1000);
		WebElement elem = $("//*[@id='"+LoginStepObject.userID+"_"+ CalendarFormTests.hourBase2 +"_1']");
		assertTrue(elem.getText().contains(form));
	}
}
