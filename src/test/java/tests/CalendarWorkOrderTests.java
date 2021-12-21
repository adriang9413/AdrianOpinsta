package tests;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;

import utils.Configuration;
import utils.Setup;

public class CalendarWorkOrderTests extends Setup {

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
	public String user1, user2;

	{
		try {
			user1 = Configuration.getBriefGroupUser();
			user2 = Configuration.getBriefNewUser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CalendarWorkOrderTests(){
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

	@Test(priority = 1)
	public void SAM478_addWorkOrder() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		calendarFormStepObject.getToCalendarSection();
		calendarWorkOrderStepObject.selectUser(user1);
		calendarFormStepObject.clickScheduleButton();
		calendarWorkOrderStepObject.addWorkOrder(startHour1, endHour1, week1, dayOfWeek1, month1, user1,  DefectReportTests.defectReportIdentifier);
		calendarWorkOrderStepObject.selectUser(user1);
		calendarWorkOrderStepObject.selectDateFromTop(month1, calendarFormStepObject.actualDate);
		assertionOnSamStepObject.assertWorkOrderCreated("WO");
	}

	@Test(priority = 1) //must be run only after running SAM478
	public void SAM479_editWorkOrder() throws Exception {
		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
		assertionOnSamStepObject.assertLogin();
		calendarFormStepObject.getToCalendarSection();
		calendarWorkOrderStepObject.selectUser(user1);
		calendarWorkOrderStepObject.selectDateFromTop(month1, calendarFormStepObject.actualDate);
		calendarWorkOrderStepObject.clickOnCalendarScheduleItem(hourBase1);
		calendarWorkOrderStepObject.editWorkOrder(startHour2, endHour2, week2, dayOfWeek2, month2, user2,  DefectReportTests.defectReportIdentifier);
		loginStepObject.logOutApp();
		loginStepObject.logInApp(Configuration.getAdminUser1(), Configuration.getAdminUserPassword1());
		assertionOnSamStepObject.assertLogin();
		calendarFormStepObject.getToCalendarSection();
		calendarWorkOrderStepObject.selectUser(user2);
		calendarWorkOrderStepObject.selectDateFromTop(month2, calendarFormStepObject.actualDate);
		assertionOnSamStepObject.assertWorkOrderEdited("WO");
	}

//	@Test(priority = 3)
//	public void removeWorkOrder() throws Exception{
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		calendarFormStepObject.getToCalendarSection();
//		calendarFormStepObject.navigateToDate(calendarWorkOrderStepObject.editDate);
//		calendarFormStepObject.clickEditForm();
//		calendarWorkOrderStepObject.removeDefectReport();
//		calendarFormStepObject.clickSaveButton();
//
//	}
//
//	@Test(priority = 4)
//	public void SAM649_newEntryFormCalendar() throws Exception {//add new entry at 15pm and delete it
//		loginStepObject.logInApp(Configuration.getAdminUser(), Configuration.getAdminUserPassword());
//		// Assert that I am logged in to SAM
//		assertionOnSamStepObject.assertLogin();
//		calendarFormStepObject.getToCalendarSection();
//		calendarWorkOrderStepObject.addNewEntryWorkOrder();
//		//cleaning
//		calendarFormStepObject.navigateToDate(calendarWorkOrderStepObject.date);
//		calendarFormStepObject.clickEditForm();
//		calendarWorkOrderStepObject.removeDefectReports();
//		calendarFormStepObject.clickSaveButton();
//
//	}
}
