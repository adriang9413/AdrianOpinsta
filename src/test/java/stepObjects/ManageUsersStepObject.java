package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LeftSideMenuPageObject;
import pageObjects.ManageUsersPageObject;
import utils.BaseClass;

public class ManageUsersStepObject extends BaseClass{

	public ManageUsersStepObject(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, 15);

	public void createUser(String userName, String userEmail, String userJobTitle, String location) {
		this.clickSetupMenu();
		this.getToUsersSection();
		this.clickAddNewUserButton();
		this.fillUserName(userName);
		this.fillUserEmail(userEmail);
		this.fillUserJobTitle(userJobTitle);
		this.selectUserLocation(location);
		this.selectPortalAccess();
		this.selectCommunicateAccess();
		this.selectSamAccess();
		this.selectLostAndFound();
		this.clickSaveButton();
		
	}

	public void clickSetupMenu() {
		scrollToXpathElement(LeftSideMenuPageObject.getCalendarSetupButton());
		$(LeftSideMenuPageObject.getCalendarSetupButton()).click();
		
	}

	public void getToUsersSection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getUsersButton())));
		$(LeftSideMenuPageObject.getUsersButton()).click();
	}

	public void clickAddNewUserButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageUsersPageObject.getAddNewUserButton())));
		$(ManageUsersPageObject.getAddNewUserButton()).click();
	}

	public void fillUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ManageUsersPageObject.getUserName())));
		$(ManageUsersPageObject.getUserName()).clear();
		$(ManageUsersPageObject.getUserName()).sendKeys(userName);
		
	}

	public void fillUserEmail(String userEmail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ManageUsersPageObject.getUserEmail())));
		$(ManageUsersPageObject.getUserEmail()).clear();
		$(ManageUsersPageObject.getUserEmail()).sendKeys(userEmail);
	}

	public void fillUserJobTitle(String userJobTitle) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ManageUsersPageObject.getUserJobTitle())));
		$(ManageUsersPageObject.getUserJobTitle()).clear();
		$(ManageUsersPageObject.getUserJobTitle()).sendKeys(userJobTitle);
	}

	public void selectUserLocation(String location) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ManageUsersPageObject.getUserLocationsButton())));
		$(ManageUsersPageObject.getUserLocationsButton()).click();
		String selector = String.format(ManageUsersPageObject.getUserLocationDropdown(), location);
		$(selector).click();
	}

	public void selectPortalAccess() {
		$(ManageUsersPageObject.getUserPortalAccess()).click();
		$(ManageUsersPageObject.getUserPortalAdminDropdown()).click();
	}

	public void selectCommunicateAccess() {
		$(ManageUsersPageObject.getUserCommunicateAccess()).click();
		$(ManageUsersPageObject.getUserCommunicateAdminDropdown()).click();
		
	}

	public void selectSamAccess() {
		$(ManageUsersPageObject.getUserSamAccess()).click();
		$(ManageUsersPageObject.getUserSamStandardDropdown()).click();
		
	}

	public void selectLostAndFound() {
		$(ManageUsersPageObject.getUserLostAndFoundAccess()).click();
		$(ManageUsersPageObject.getUserLostAndFoundDropdown()).click();
	}

	public void clickSaveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageUsersPageObject.getSaveUserButton())));
		scrollToXpathElement(ManageUsersPageObject.getSaveUserButton());
		$(ManageUsersPageObject.getSaveUserButton()).click();
		
	}

	public void verifyUserSuccesfullyCreatedMesssge() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ManageUsersPageObject.getAboveAlert())));
		assertEquals($(ManageUsersPageObject.getAboveAlert()).getText(), "User created successfully.",
				"User message is:");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ManageUsersPageObject.getAboveAlert())));
		
	}

	public void verifyUserSaved(String userEmail) throws InterruptedException {
		Thread.sleep(500);
		$(ManageUsersPageObject.getUserSearch()).sendKeys(userEmail);
		String selector = String.format(ManageUsersPageObject.getUserInTable(), userEmail);
		assertTrue($(selector).isDisplayed());
		
	}

	public void deleteUser(String userEmail) {
		clickUserInTable(userEmail);
		clickUpdateUserButton();
		clickRemoveUserButton();
		clickConfirmUserRemoval();
	}

	public void clickConfirmUserRemoval() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageUsersPageObject.getConfirmDeleteUserButton())));
		$(ManageUsersPageObject.getConfirmDeleteUserButton()).click();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ManageUsersPageObject.getAboveAlert())));

	}


	public void clickUserInTable(String userEmail) {
		String selector = String.format(ManageUsersPageObject.getUserInTable(), userEmail);
		$(selector).click();
	}
	
	public void clickUpdateUserButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageUsersPageObject.getUpdateUserButton())));
		$(ManageUsersPageObject.getUpdateUserButton()).click();
	}
	
	public void clickRemoveUserButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageUsersPageObject.getRemoveUserButton())));
		$(ManageUsersPageObject.getRemoveUserButton()).click();

	}

	

}
