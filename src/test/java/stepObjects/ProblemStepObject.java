package stepObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LeftSideMenuPageObject;
import pageObjects.ProblemPageObject;
import utils.BaseClass;

public class ProblemStepObject extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public ProblemStepObject(WebDriver driver) {
		super(driver);
	}

	public void addNewProblem(String assetGroup, String firstLevel) throws InterruptedException {
		clickSetupMenu();
		getToProblemSection();
		clickAddNewProblemButton();
		selectAssetGroup(assetGroup);
		fillFirstLevel(firstLevel);
		clickSaveButton();
		verifyProblemSuccessfullySavedMessage();
	}

	public void addProblemWithoutMandatoryFields() {
		this.clickSetupMenu();
		this.getToProblemSection();
		this.clickAddNewProblemButton();
		this.clickSaveButton();
	}

//	public void cancelCreatingProblem(String assetGroup, String cancelFirstLevel, String contractor, String guidance) {
//		this.clickSetupMenu();
//		this.getToProblemSection();
//		this.clickAddNewProblemButton();
//		this.addNewAssetGroup();
//		this.selectAssetGroup(assetGroup);
//		this.fillFirstLevel(cancelFirstLevel);
//		this.selectContractor(contractor);
//		this.selectGuidance(guidance);
//		this.clickCancelButton();
//	}

	public void clickCancelButton() {
		$(ProblemPageObject.getCancelButton()).click();
		
	}

	public void clickSetupMenu() {
		scrollToXpathElement(LeftSideMenuPageObject.getDefectSetupButton());
		$(LeftSideMenuPageObject.getDefectSetupButton()).click();
	}

	public void getToProblemSection() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeftSideMenuPageObject.getDefectProblemButton())));
		$(LeftSideMenuPageObject.getDefectProblemButton()).click();

	}

	public void clickAddNewProblemButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProblemPageObject.getAddNewProblemButton())));
		$(ProblemPageObject.getAddNewProblemButton()).click();
	}

	public void addNewAssetGroup() {
//		$(ProblemPageObject.getProblemAddAssetGroupBtn()).click();
//		WebElement element = $(ProblemPageObject.getProblemAddAssetGroupBtn());
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
		
	}

	public void selectAssetGroup(String assetGroup) throws InterruptedException {
		Thread.sleep(1000);
		$(ProblemPageObject.getProblemAddAssetGroupBtn()).click();
		Thread.sleep(1000);
		WebElement assetGroupUL = driver.findElement(By.xpath(ProblemPageObject.getSelectAssetGroup()));
		List<WebElement> assetGroupIL = assetGroupUL.findElements(By.tagName("li"));
		for (WebElement li : assetGroupIL) {
			if (li.getText().equals(assetGroup)) {
				li.click();
				break;
			}
		}
	}

	public void fillFirstLevel(String firstLevel) {
		$(ProblemPageObject.getFirstLevelField()).sendKeys(firstLevel);

	}

	public void selectContractor(String contractor) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ProblemPageObject.getContractorField())));
		$(ProblemPageObject.getContractorField()).click();
		String selector = String.format(ProblemPageObject.getContractorDropDown(), contractor);
		$(selector).click();
		
	}
	private void selectGuidance(String guidance) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ProblemPageObject.getGuidanceField())));
		$(ProblemPageObject.getGuidanceField()).click();
		String selector = String.format(ProblemPageObject.getGuidanceDropDown(), guidance);
		$(selector).click();
	}

	public void clickSaveButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProblemPageObject.getSaveButton())));
		$(ProblemPageObject.getSaveButton()).click();
	}

	public void verifyProblemSuccessfullySavedMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProblemPageObject.getProblemSavedMessage())));
		assertEquals($(ProblemPageObject.getProblemSavedMessage()).getText(), "Problem created successfully.",
				"Problem message is:");
	}

	public void verifyProblemSaved(String firstLevel) {
		$(ProblemPageObject.getProblemSearchBar()).sendKeys(firstLevel);
		String selector = String.format(ProblemPageObject.getProblemInTable(), firstLevel);
		assertTrue($(selector).isDisplayed());
		assertEquals($(selector).getText(), firstLevel);
	}

	public void verifyProblemMandatoryFields() {
		assertEquals($(ProblemPageObject.getAssetGroupMandatoryError()).getText(),
				"  Error!Looks wrong!");
		assertEquals($(ProblemPageObject.getFirstLevelMandatoryError()).getText(),
				"  Error! Please insert the first level or remove the second level!");
		assertEquals($(ProblemPageObject.getContractorMandatoryError()).getText(), "  Error!Looks wrong!");
		assertEquals($(ProblemPageObject.getGuidanceMandatoryError()).getText(), "  Error!Looks wrong!");

	}

	public void verifyProblemNotSaved(String cancelFirstLevel) {
		$(ProblemPageObject.getProblemSearchBar()).sendKeys(cancelFirstLevel);
		String selector = String.format(ProblemPageObject.getProblemInTable(), cancelFirstLevel);
		List<WebElement> problems = elems(selector);
		assertTrue(problems.size() == 0);
		
	}

}
