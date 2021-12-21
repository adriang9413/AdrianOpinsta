package stepObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.LeftSideMenuPageObject;
import pageObjects.BriefGroupPageObject;
import pageObjects.ProblemPageObject;
import utils.BaseClass;

import java.util.List;

public class BriefGroupStepObject extends BaseClass {

    public BriefGroupStepObject(WebDriver driver) {
        super(driver);
    }

    public void accessGroupPage() {
        scrollToXpathElement(LeftSideMenuPageObject.getBriefSetupButton());
        $(LeftSideMenuPageObject.getBriefSetupButton()).click();
        $(LeftSideMenuPageObject.getBriefGroupsButton()).click();
    }

    public void addNewGroup(String name, String groupUser) throws InterruptedException {
        wait_for_xpath_elem_to_be_clickable(BriefGroupPageObject.getAddGroupButton(), 5000);
        $(BriefGroupPageObject.getAddGroupButton()).click();
        wait_for_xpath_elem_to_be_visible(BriefGroupPageObject.getInputGroupName(), 5000);
        $(BriefGroupPageObject.getInputGroupName()).sendKeys(name);
        $(BriefGroupPageObject.getInputUser()).click();
        Thread.sleep(1000);
        WebElement groupUL = driver.findElement(By.xpath(BriefGroupPageObject.getUserDropdown()));
        List<WebElement> groupIL = groupUL.findElements(By.tagName("li"));
        for (WebElement li : groupIL) {
            if (li.getText().equals(groupUser)) {
                li.click();
                break;
            }
        }
        //selectDropdownByText(BriefGroupPageObject.getUserDropdown(), groupUser);
        //$(BriefGroupPageObject.getInputGroupName()).click();
        Thread.sleep(1000);
        $(BriefGroupPageObject.getCreateGroupButton()).click();
        Thread.sleep(2000);

    }
}