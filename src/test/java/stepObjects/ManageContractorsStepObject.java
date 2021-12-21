package stepObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ManageContractorsPageObject;
import utils.BaseClass;

public class ManageContractorsStepObject extends BaseClass {

    public ManageContractorsStepObject(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void addNewContractor () {
        $(ManageContractorsPageObject.getSetupButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageContractorsPageObject.getContractorsButton())));
        $(ManageContractorsPageObject.getContractorsButton()).click();
        $(ManageContractorsPageObject.getAddNewContractor()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageContractorsPageObject.getContractorName())));
        $(ManageContractorsPageObject.getContractorName()).sendKeys("3AutomationName");
        $(ManageContractorsPageObject.getContractorEmail()).sendKeys("3Automation@selenium.ro");
        $(ManageContractorsPageObject.getContractorPhone()).sendKeys("0734540913");
        $(ManageContractorsPageObject.getContractorSpeciality()).sendKeys("selenium");
        $(ManageContractorsPageObject.getSaveButton()).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ManageContractorsPageObject.getTooltip())));
    }
}
