package tests;

import org.testng.annotations.Test;
import pageObjects.BriefCategoriesPageObject;
import stepObjects.BriefCategoriesStepObject;
import utils.Configuration;
import utils.Setup;

import java.io.IOException;

public class BriefCategoryTests extends Setup {

    public static String categoryName1, categoryName2;

    {
        try {
            categoryName1 = Configuration.getBriefCategoryName();
            categoryName2 = Configuration.getBriefCategory2Name();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 1)
    public void SAM606_addCategories() throws Exception{
        loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
        assertionOnSamStepObject.assertLogin();
        briefCategoriesStepObject.accessCategoriesPage();
        briefCategoriesStepObject.addNewCategory(categoryName1, Configuration.getBriefCategoryDeadline(), Configuration.getBriefCategoryCriticality());
        assertionOnSamStepObject.assertBriefCategoryCreated(categoryName1);
        briefCategoriesStepObject.addNewCategory(categoryName2, Configuration.getBriefCategoryDeadline(), Configuration.getBriefCategoryCriticality());
        assertionOnSamStepObject.assertBriefCategoryCreated(categoryName2);
    }

}
