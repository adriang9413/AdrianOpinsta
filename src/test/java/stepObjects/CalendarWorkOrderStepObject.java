package stepObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CalendarPageObject;
import pageObjects.CalendarWorkOrderFormPageObject;
import utils.BaseClass;

public class CalendarWorkOrderStepObject extends BaseClass {
	CalendarFormStepObject calendarForm = new CalendarFormStepObject(driver);

	public CalendarWorkOrderStepObject(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);

	private String reference;

	public void selectUser(String user) throws Exception {
		Thread.sleep(1000);
		WebElement groupUL = $(CalendarPageObject.getListOfUsers());
		List<WebElement> groupIL = groupUL.findElements(By.tagName("li"));
		for (WebElement li : groupIL) {
			if (li.getText().equals("Select all")) {
				li.click();
				li.click();
			}
			if(li.getText().equals(user)){
				li.click();
				break;
			}
		}
	}

	public void addWorkOrder(String startHour, String endHour, int week, int day, int month, String assignee, String defectReport) throws Exception {
		calendarForm.selectStartHour(startHour);
		calendarForm.selectEndHour(endHour);
		calendarForm.selectDateFromCalendar(week, day, month);
		calendarForm.selectAssignee(assignee);
		calendarForm.selectEntryType("Work order");
		addDefectReports();
		selectDefectReport(defectReport);
		clickProceedButton();
		calendarForm.clickSaveButton();
	}

	public void editWorkOrder(String startHour, String endHour, int week, int day, int month, String assignee, String defectReport) throws Exception {
		calendarForm.selectStartHour(startHour);
		calendarForm.selectEndHour(endHour);
		calendarForm.selectDateFromCalendar(week, day, month);
		calendarForm.selectAssignee(assignee);
		removeDefectReport();
		addDefectReports();
		selectDefectReport(defectReport);
		clickProceedButton();
		calendarForm.clickSaveButton();
	}

//	public void addNewEntryWorkOrder() throws InterruptedException {
//		calendarForm.clickNewEntry(1, 17, 1);
//		calendarForm.selectEndHour(editEndHour);
//		calendarForm.selectDateFromCalendar(day);
//		calendarForm.selectAssignee(editAssignee);
//		calendarForm.selectAssignee(assignee);
//		calendarForm.selectEntryType("Work order");
//		this.addDefectReports();
//		this.addNewDefectReports();
//		this.clickProceedButton();
//		this.verifyAllFieldsMultiReferences("15:00", editEndHour, calendarForm.dateInCalendarForm(date), assignee, entryType, multiReference);
//		calendarForm.clickSaveButton();
//
//	}

//	private void addNewDefectReports() throws InterruptedException {
//		for (int i = 0; i < 3; i++) {
//			List<WebElement> allDefectReports = elems(CalendarWorkOrderFormPageObject.getAllCheckboxesDefectReports());
//			List<WebElement> allReferences = elems(CalendarWorkOrderFormPageObject.getAllReferencesDefectReports());
//			multiReference.add(allReferences.get(0).getText());
//			allDefectReports.get(0).click();
//			Thread.sleep(1000);
//			if (allDefectReports.size() >= 10) {
//				nextPageDefectReports();
//			}
//
//		}
//	}

	public void selectDateFromTop(int month, String dayOfMonth) throws Exception {
		for(int i=0;i<month;i++){
			$(CalendarPageObject.getTopCalendarNextButton()).click();
			Thread.sleep(1500);
		}
		$("//*[@id='day-selector_container']/div["+dayOfMonth+"]/p[2]").click();
		Thread.sleep(500);
	}

	public void clickOnCalendarScheduleItem(int hour){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		action.moveToElement($(CalendarPageObject.getScheduleContainer()));
		for(int i=0;i<50;i++){
			if(!$("//*[@id='"+LoginStepObject.userID+"_"+ hour+"_1']").isDisplayed()){
				je.executeScript("window.scrollTo(0,"+i+"000)");
			}else{
				$("//*[@id='"+LoginStepObject.userID+"_"+hour+"_1']").click();
				break;
			}
		}
	}

//	public void goToCalendarScheduleItem(int hour){
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		Actions action = new Actions(driver);
//		action.moveToElement($(CalendarPageObject.getScheduleContainer()));
//		for(int i=0;i<50;i++){
//			if(!$("//*[@id='235_"+hour+"_1']").isDisplayed()){
//				je.executeScript("window.scrollTo(0,"+i+"000)");
//			}else{
//				break;
//			}
//		}
//	}

	private void nextPageDefectReports() {
		$(CalendarWorkOrderFormPageObject.getNextPageDefectReport()).click();
	}

	public void removeDefectReport() throws Exception {
		$(CalendarWorkOrderFormPageObject.getRemoveDefectReportWO()).click();
		Thread.sleep(1500);
	}
	public void removeDefectReports() {
		List<WebElement> defectReports = elems(CalendarWorkOrderFormPageObject.getRemoveDefectReportWO());
		for(int i=0; i< defectReports.size(); i++) {
			defectReports.get(i).click();
		}
	}

	public void addDefectReports() {
		wait_for_id_elem_to_be_visible(CalendarWorkOrderFormPageObject.getAddDefectReport(), 10);
		$(CalendarWorkOrderFormPageObject.getAddDefectReport()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CalendarWorkOrderFormPageObject.getAllReportsTitle())));
	}

	public void selectDefectReport(String defectReport) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(CalendarWorkOrderFormPageObject.getSearchDefectReportBar())));
		$(CalendarWorkOrderFormPageObject.getSearchDefectReportBar()).clear();
		$(CalendarWorkOrderFormPageObject.getSearchDefectReportBar()).sendKeys(defectReport);
		String selector = String.format(CalendarWorkOrderFormPageObject.getDefectReportCheckbox(), defectReport);
		reference = referenceInTable(defectReport);
		$(selector).click();
	}

	public void clickProceedButton() throws Exception {
		$(CalendarWorkOrderFormPageObject.getAddWorkOrderButton()).click();
		Thread.sleep(500);
	}

//	public void verifyEventSaved(String eventDuration) {
//		String selector = String.format(CalendarPageObject.getScheduleContainerColumn(), 1);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
//		String event = $(selector).getText();
//		Assert.assertEquals(eventDuration, event);
//	}

	public String referenceInTable(String defectReport) {
		String selector = String.format(CalendarWorkOrderFormPageObject.getReferenceInTableReport(), defectReport);
		String referenceName = $(selector).getText();
		return referenceName;
	}

//	public void verifyAllFields(String startHour, String endHour, String date, String assignee, String entryType, String defectReportReference) {
//		assertEquals($(CalendarPageObject.getCalendarStartHourButton()).getAttribute("value"), startHour,
//				"The start hour does not match!");
//		assertEquals($(CalendarPageObject.getCalendarEndHourButton()).getAttribute("value"), endHour, "The end hour does not match!");
//		assertEquals($(CalendarPageObject.getOpenCalendar()).getAttribute("value"), date, "The Date does not match");
//		assertEquals($(CalendarPageObject.getAssigneeSelection()).getAttribute("value"), assignee,
//				"Assignee does not match!");
//		assertEquals($(CalendarPageObject.getEntryTypeSelection()).getAttribute("value"), entryType,
//				"Entry type does not match!");
//		assertEquals($(CalendarWorkOrderFormPageObject.getReferenceInPopUp()).getText(), defectReportReference,
//				"Reference does not match!");
//
//	}

//	public void verifyAllEditedFields(String startHour, String endHour, String date, String assignee, String defectReportReference) {
//		assertEquals($(CalendarPageObject.getCalendarStartHourButton()).getAttribute("value"), startHour,
//				"The start hour does not match!");
//		assertEquals($(CalendarPageObject.getCalendarEndHourButton()).getAttribute("value"), endHour, "The end hour does not match!");
//		assertEquals($(CalendarPageObject.getOpenCalendar()).getAttribute("value"), date, "The Date does not match");
//		assertEquals($(CalendarPageObject.getAssigneeSelection()).getAttribute("value"), assignee, "Assignee does not match!");
//		assertEquals($(CalendarWorkOrderFormPageObject.getReferenceInPopUp()).getText(), defectReportReference, "Reference does not match!");
//	}

//	public void verifyAllFieldsMultiReferences(String startHour, String endHour, String date, String assignee,
//			String entryType, List<String> defectReportReference) {
//		assertEquals($(CalendarPageObject.getCalendarStartHourButton()).getAttribute("value"), startHour,
//				"The start hour does not match!");
//		assertEquals($(CalendarPageObject.getCalendarEndHourButton()).getAttribute("value"), endHour, "The end hour does not match!");
//		assertEquals($(CalendarPageObject.getOpenCalendar()).getAttribute("value"), date, "The Date does not match");
//		assertEquals($(CalendarPageObject.getAssigneeSelection()).getAttribute("value"), assignee,
//				"Assignee does not match!");
//		assertEquals($(CalendarPageObject.getEntryTypeSelection()).getAttribute("value"), entryType,
//				"Entry type does not match!");
//		for (int i = defectReportReference.size() - 1; i <= 0; i--) {
//			assertEquals($(CalendarWorkOrderFormPageObject.getReferenceInPopUp()).getText(), defectReportReference.get(i),
//					"Reference does not match!");
//		}
//	}
}
