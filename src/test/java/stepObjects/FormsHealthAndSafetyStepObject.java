package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.FormsHealthAndSafetyPageObject;
import pageObjects.LeftSideMenuPageObject;
import pageObjects.ProblemPageObject;
import utils.BaseClass;

import java.util.List;

public class FormsHealthAndSafetyStepObject extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public FormsHealthAndSafetyStepObject(WebDriver driver) {
		super(driver);
	}

	public void createHealthFormWithGuidance(String formName, String publicURL, String guidance) {
		this.clickFormCategoriesLeftMenu();
		this.clickHealthSafetyLeftMenu();
		this.clickAddNewFormButton();
		this.fillFormName(formName);
		this.selePublicURL(publicURL);
		this.selectGuidance(guidance);
		this.clickSaveButton();
	}

	public void createHealthForm(String formName,String categoryName,String publicURL) {
		this.clickFormCategoriesLeftMenu();
		this.clickHealthSafetyLeftMenu();
		this.clickAddNewFormButton();
		this.fillFormName(formName);
		this.selePublicURL(publicURL);
		this.verifyCategoryName(categoryName);
		this.clickSaveButton();

	}

	public void clickFormCategoriesLeftMenu() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getFormCategoriesLeftMenu())));
		$(LeftSideMenuPageObject.getFormCategoriesLeftMenu()).click();

	}

	public void clickHealthSafetyLeftMenu() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getHealthAndSafetyLeftMenu())));
		$(LeftSideMenuPageObject.getHealthAndSafetyLeftMenu()).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddNewFormButton() {
		wait.until(
				ExpectedConditions.elementToBeClickable(By.id(FormsHealthAndSafetyPageObject.getAddNewFormButton())));
		$(FormsHealthAndSafetyPageObject.getAddNewFormButton()).click();
	}

	public void fillFormName(String formName) {
		$(FormsHealthAndSafetyPageObject.getFormName()).clear();
		$(FormsHealthAndSafetyPageObject.getFormName()).sendKeys(formName);

	}

	public void selePublicURL(String publicURL) {
		$(FormsHealthAndSafetyPageObject.getFormPublicUrl()).click();

		WebElement publicURLUL = driver.findElement(By.xpath(FormsHealthAndSafetyPageObject.getPublicUrlDropdown()));
		List<WebElement> publicURLIL = publicURLUL.findElements(By.tagName("li"));
		for (WebElement li : publicURLIL) {
			if (li.getText().equals(publicURL)) {
				li.click();
			}
		}
//		Select select = new Select($(FormsHealthAndSafetyPageObject.getFormPublicUrlDropdown()));
//		select.selectByVisibleText(publicURL);

	}

	public void selectGuidance(String guidance) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(FormsHealthAndSafetyPageObject.getFormGuidance())));
		$(FormsHealthAndSafetyPageObject.getFormGuidance()).click();

		//TODO select guidance - check problemStep
//		String selector = String.format(FormsHealthAndSafetyPageObject.getStagingGuidanceDropdown(), guidance);
//		$(selector).click();

		// production
//		Select select = new Select($(FormsHealthAndSafetyPageObject.getFormGuidanceDropdown()));
//		select.selectByVisibleText(guidance);

	}

	public void clickSaveButton() {
		$(FormsHealthAndSafetyPageObject.getSaveButton()).click();
	}

	public void verifyFormSavedMessage() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(FormsHealthAndSafetyPageObject.getAboveAlert())));
		String actualAlert = "Form stored successfully";
		String alert = $(FormsHealthAndSafetyPageObject.getAboveAlert()).getText();
		assertEquals(actualAlert, alert);

	}

	public void verifyFormSavedInTable(String formName) throws InterruptedException {
		$(FormsHealthAndSafetyPageObject.getSearchBar()).sendKeys(formName);
		String selector = String.format(FormsHealthAndSafetyPageObject.getFormInTable(), formName);
		Thread.sleep(2000);
		assertTrue($(selector).isDisplayed());

	}

	public void verifyCategoryName(String categoryName) {
		wait_for_id_elem_to_be_visible(FormsHealthAndSafetyPageObject.getCategoryTypeRightPage(), 10);
		assertEquals($(FormsHealthAndSafetyPageObject.getCategoryTypeRightPage()).getAttribute("value"), categoryName);
		
	}

	public void verifyFormRedirect(String formName) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait_for_xpath_elem_to_be_visible(FormsHealthAndSafetyPageObject.getRedirectFormPageTitle(), 40);
		assertEquals($(FormsHealthAndSafetyPageObject.getRedirectFormPageTitle()).getText(), formName, "Form name:");
		
	}

	public void createHealthFormWithoutMandatoryFields() throws InterruptedException {
		this.clickFormCategoriesLeftMenu();
		this.clickHealthSafetyLeftMenu();
		this.clickAddNewFormButton();
		this.fillFormName("");
		this.verifyCategoryName("Health & Safety");
		this.clickSaveButton();
	}

	public void verifyFormNotSavedMessage() {
		assertEquals($(FormsHealthAndSafetyPageObject.getFormNameMandatoryError()).getText(),
				"  Error!  Looks wrong!");
		assertEquals($(FormsHealthAndSafetyPageObject.getPublicUrlMandatoryField()).getText(),
				"  Error!  This field is mandatory, please complete");
		
	}

	public void editForm(String form){
		wait_for_id_elem_to_be_visible(FormsHealthAndSafetyPageObject.getSearchBar(), 10);
		$(FormsHealthAndSafetyPageObject.getSearchBar()).sendKeys(form);
		$(FormsHealthAndSafetyPageObject.getSearchBar()).sendKeys(Keys.ENTER);
		$(FormsHealthAndSafetyPageObject.getEditFormButton()).click();
	}

}
