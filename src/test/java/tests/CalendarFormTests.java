package tests;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageObjects.CalendarPageObject;
import utils.Configuration;
import utils.Setup;

public class CalendarFormTests extends Setup {

	static Random rand = new Random();
	public int month1 = rand.nextInt(12);
	public int month2 = rand.nextInt(12);
	public int week1 = rand.nextInt(3)+2;
	public int week2 = rand.nextInt(3)+2;
	public int dayOfWeek1 = rand.nextInt(5)+1;
	public int dayOfWeek2 = rand.nextInt(5)+1;
	public static int hourBase1 = rand.nextInt(12)+12;
	public static int hourBase2 = rand.nextInt(12)+12;
	public static String startHour1, startHour2, endHour1, endHour2;
	public String user1, user2, category = "Inspections";

	{
		try {
			user1 = Configuration.getBriefGroupUser();
			user2 = Configuration.getBriefNewUser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CalendarFormTests(){
		if (hourBase1 <10){
			startHour1 = "0"+ hourBase1 +":00";
			endHour1 = "0"+ hourBase1 +":30";
			startHour2 = "0"+ hourBase2 +":00";
			endHour2 = "0"+ hourBase2 +":30";
		}else{
			startHour1 = hourBase1 +":00";
			endHour1 = hourBase1 +":30";
			startHour2 = hourBase2 +":00";
			endHour2 = hourBase2 +":30";
		}
	}

	@Test(priority = 2)
	public void SAM648_addForm() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		calendarFormStepObject.getToCalendarSection();
		calendarWorkOrderStepObject.selectUser(user1);
		calendarFormStepObject.clickScheduleButton();
		calendarFormStepObject.addForm(startHour1, endHour1, week1, dayOfWeek1, month1, user1, category);
		calendarWorkOrderStepObject.selectUser(user1);
		calendarWorkOrderStepObject.selectDateFromTop(month1, calendarFormStepObject.actualDate);
		assertionOnSamStepObject.assertFormCreated(FormCategoriesInspectionsTests.form);
	}

	@Test(priority = 2, groups = "smoke")
	public void SAM651_editForm() throws Exception {// edit the form created in the first test
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		calendarFormStepObject.getToCalendarSection();
		calendarWorkOrderStepObject.selectUser(user1);
		calendarWorkOrderStepObject.selectDateFromTop(month1, calendarFormStepObject.actualDate);
		calendarWorkOrderStepObject.clickOnCalendarScheduleItem(hourBase1);
		calendarFormStepObject.editForm(startHour2, endHour2, week2, dayOfWeek2, month2, user2, category);
		loginStepObject.logOutApp();
		loginStepObject.logInApp(Configuration.getAdminUser1(), Configuration.getAdminUserPassword1());
		assertionOnSamStepObject.assertLogin();
		calendarFormStepObject.getToCalendarSection();
		calendarWorkOrderStepObject.selectUser(user2);
		calendarWorkOrderStepObject.selectDateFromTop(month2, calendarFormStepObject.actualDate);
		assertionOnSamStepObject.assertFormEdited(FormCategoriesInspectionsTests.form);
	}

//	@Test(priority = 3, groups = "smoke")
//	public void deleteFormEventFromCalendar() throws Exception {// delete the edited form
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		calendarFormStepObject.getToCalendarSection();
//		calendarFormStepObject.navigateToDate(calendarFormStepObject.editDate);
//		calendarFormStepObject.clickEditForm();
//		calendarFormStepObject.clickRemoveScheduleButton();
//	}
//
//	@Test(priority = 4)
//	public void createFormWithoutMainMandatoryFields() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		calendarFormStepObject.getToCalendarSection();
//		calendarFormStepObject.clickScheduleButton();
//		calendarFormStepObject.clickSaveButton();
//		assertEquals(driver.findElement(By.xpath(CalendarPageObject.getUserMandatoryError())).getText(),
//				"  Error!This field is mandatory, please select an option!");
//		assertEquals(driver.findElement(By.xpath(CalendarPageObject.getEntryTypeMandatoryError())).getText(),
//				"  Error!This field is mandatory, please select an option!");
//	}
//
//	@Test(priority = 5)
//	public void createFormWithoutFormCategoriesAndName() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		calendarFormStepObject.getToCalendarSection();
//		calendarFormStepObject.clickScheduleButton();
//		calendarFormStepObject.selectAssignee(calendarFormStepObject.assignee);
//		calendarFormStepObject.selectEntryType(calendarFormStepObject.entryType);
//		calendarFormStepObject.clickSaveButton();
//		assertEquals(driver.findElement(By.xpath(CalendarPageObject.getFormCategoriesError())).getText(),
//				"  Error!This field is mandatory, please select an option!");
//		assertEquals(driver.findElement(By.xpath(CalendarPageObject.getFormNameError())).getText(),
//				"  Error!This field is mandatory, please select an option!");
//	}
//
//	@Test(priority = 6, groups = "smoke")
//	public void SAM652_createFormEventInCalendar() throws Exception {
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		assertionOnSamStepObject.assertLogin();
//		calendarFormStepObject.addForm();
//		calendarFormStepObject.navigateToDate(calendarFormStepObject.date);
//		calendarFormStepObject.verifyEventSaved(1);// 1st user column calendar schedule
//
//	}
}
