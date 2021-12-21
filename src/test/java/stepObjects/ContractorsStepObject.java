package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.ManageContractorsPageObject;
import utils.BaseClass;

public class ContractorsStepObject extends BaseClass {


	public ContractorsStepObject(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public void addNewContractor(String contractorName, String contractorEmail, String contractorPhone, String contractorSpeciality) {
		scrollToXpathElement(ManageContractorsPageObject.getSetupButton());
		$(ManageContractorsPageObject.getSetupButton()).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(ManageContractorsPageObject.getContractorsButton())));
		$(ManageContractorsPageObject.getContractorsButton()).click();
		$(ManageContractorsPageObject.getAddNewContractor()).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(ManageContractorsPageObject.getContractorName())));

		$(ManageContractorsPageObject.getContractorName()).sendKeys(contractorName);
		$(ManageContractorsPageObject.getContractorEmail()).sendKeys(contractorEmail);
		$(ManageContractorsPageObject.getContractorPhone()).sendKeys(contractorPhone);
		$(ManageContractorsPageObject.getContractorSpeciality()).sendKeys(contractorSpeciality);
		$(ManageContractorsPageObject.getSaveButton()).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageContractorsPageObject.getTooltip())));
	}

	public void verifyContractorSaved(String contractorName) {
		assertEquals(driver.findElement(By.id(ManageContractorsPageObject.getAlertAbove())).getText(),"Contractor created successfully.", "The value of the assertion is: ");
		$(ManageContractorsPageObject.getContractorSearchBar()).sendKeys(contractorName);
		String selector = String.format(ManageContractorsPageObject.getContractorInTable(), contractorName);
		assertTrue($(selector).isDisplayed());
	}
}
