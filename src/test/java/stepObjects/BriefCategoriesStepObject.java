package stepObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BriefCategoriesPageObject;
import pageObjects.BriefGroupPageObject;
import pageObjects.LeftSideMenuPageObject;
import utils.BaseClass;

import java.util.List;


public class BriefCategoriesStepObject extends BaseClass {

    public BriefCategoriesStepObject(WebDriver driver) {
        super(driver);
    }

    public void accessCategoriesPage() {
        scrollToXpathElement(LeftSideMenuPageObject.getBriefSetupButton());
        $(LeftSideMenuPageObject.getBriefSetupButton()).click();
        $(LeftSideMenuPageObject.getBriefCategoriesButton()).click();
    }

    public void addNewCategory(String name, String deadline, String criticality) throws InterruptedException {
        wait_for_xpath_elem_to_be_clickable(BriefCategoriesPageObject.getAddCategoryButton(), 5000);
        $(BriefCategoriesPageObject.getAddCategoryButton()).click();
        wait_for_xpath_elem_to_be_visible(BriefCategoriesPageObject.getInputCategoryName(), 5000);
        $(BriefCategoriesPageObject.getInputCategoryName()).sendKeys(name);
        $(BriefCategoriesPageObject.getDeadlineField()).sendKeys(deadline);
        $(BriefCategoriesPageObject.getInputCritical()).click();
        Thread.sleep(1000);
        WebElement groupUL = driver.findElement(By.xpath(BriefCategoriesPageObject.getCriticalDropdown()));
        List<WebElement> groupIL = groupUL.findElements(By.tagName("li"));
        for (WebElement li : groupIL) {
            if (li.getText().equals(criticality)) {
                li.click();
            }
        }
        $(BriefCategoriesPageObject.getCreateCategoryButton()).click();
        Thread.sleep(1000);
    }
}