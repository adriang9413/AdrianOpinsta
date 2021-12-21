package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import stepObjects.*;

public class Setup {

	protected GeneralAssertionOnSamStepObject assertionOnSamStepObject;
	protected LoginStepObject loginStepObject;
	protected DefectReportsStepObject defectReportsStepObject;
	protected AssetGroupStepObject manageStepObject;
	protected ContractorsStepObject manageContractorsStepObject;
	protected CalendarFormStepObject calendarFormStepObject;
	protected CalendarWorkOrderStepObject calendarWorkOrderStepObject;
	protected AssetGroupStepObject assetGroupStepObject;
	protected AssetStepObject assetStepObject;
	protected GuidanceStepObject guidanceStepObject;
	protected ProblemStepObject problemStepObject;
	protected DefectOverviewStepObject defectOverviewStepObject;
	protected FormsOverviewStepObject formsOverviewStepObject;
	protected FormsHealthAndSafetyStepObject formsHealthAndSafetyStepObject;
	protected FormsInspectionsStepObject formsInspectionsStepObject;
	protected ManageUsersStepObject manageUsersStepObject;
	protected BriefGroupStepObject briefGroupObject;
	protected BriefCategoriesStepObject briefCategoriesStepObject;
	protected BriefOverviewStepObject briefOverviewStepObject;

	public WebDriver driver;
	private String baseURL = "https://staging-portal.opinsta.com/login";
//	private String baseUrlProduction = "https://portal.opinsta.com/login";

	@AfterMethod
	public void takeSS(ITestResult result) throws Exception {
		takeSnapShot(driver, "./testScreenshots/" + result.getMethod().getMethodName() + ".png");
		driver.quit();
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		initializeClasses();
	}

	public void initializeClasses() {
		assertionOnSamStepObject = new GeneralAssertionOnSamStepObject(driver);
		loginStepObject = new LoginStepObject(driver);
		defectReportsStepObject = new DefectReportsStepObject(driver);
		manageStepObject = new AssetGroupStepObject(driver);
		manageContractorsStepObject = new ContractorsStepObject(driver);
		calendarFormStepObject = new CalendarFormStepObject(driver);
		calendarWorkOrderStepObject = new CalendarWorkOrderStepObject(driver);
		assetGroupStepObject = new AssetGroupStepObject(driver);
		assetStepObject = new AssetStepObject(driver);
		guidanceStepObject = new GuidanceStepObject(driver);
		problemStepObject = new ProblemStepObject(driver);
		defectOverviewStepObject = new DefectOverviewStepObject(driver);
		formsOverviewStepObject = new FormsOverviewStepObject(driver);
		formsHealthAndSafetyStepObject = new FormsHealthAndSafetyStepObject(driver);
		formsInspectionsStepObject = new FormsInspectionsStepObject(driver);
		manageUsersStepObject = new ManageUsersStepObject(driver);
		briefGroupObject = new BriefGroupStepObject(driver);
		briefCategoriesStepObject = new BriefCategoriesStepObject(driver);
		briefOverviewStepObject = new BriefOverviewStepObject(driver);
	}

	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(fileWithPath);

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
