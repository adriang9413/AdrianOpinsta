package stepObjects;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.CalendarPageObject;
import pageObjects.LeftSideMenuPageObject;
import tests.FormCategoriesInspectionsTests;
import utils.BaseClass;
import utils.Configuration;

public class CalendarFormStepObject extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public static String actualDate;

	public String section = "Calendar";
	public String startHour = "09:00";
	public String endHour = "10:00";
	public String assignee = "Test User";
	public String entryType = "Form";
	public String formCategories = "Incidents";
	public String formName = "2nd Incident";
	public String eventDuration = "09:00 - 10:00";
	public String date; /*= LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("d MMMM yyyy"));*/
	public String editStartHour = "11:00";
	public String editEndHour = "12:00";
	public String editAssignee = "Jalila Alhaj";
	public String editFormCategories = "Inspections";
	public String editFormName = "SeleHealthForm";
	public String editEventDuration = "11:00 - 12:00";
	public String editDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("d MMMM yyyy"));

	public CalendarFormStepObject(WebDriver driver) {
		super(driver);
	}

	public void getToCalendarSection() {
		scrollToXpathElement(LeftSideMenuPageObject.getCalendarButton());
		$(LeftSideMenuPageObject.getCalendarButton()).click();
	}

	public void addForm(String startHour, String endHour, int week, int day, int month, String assignee, String category) throws Exception {
		selectStartHour(startHour);
		selectEndHour(endHour);
		selectDateFromCalendar(week, day, month);
		selectAssignee(assignee);
		selectEntryType("Form");
		selectFormCategories(category);
		selectFormName(FormCategoriesInspectionsTests.form);
		clickSaveButton();
	}

	public void editForm(String startHour, String endHour, int week, int day, int month, String assignee, String category) throws Exception {
		selectStartHour(startHour);
		selectEndHour(endHour);
		selectDateFromCalendar(week, day, month);
		selectAssignee(assignee);
		selectFormCategories(category);
		selectFormName(FormCategoriesInspectionsTests.form);
		clickSaveButton();
	}

	public void addNewEntryForm() throws Exception {
		selectAssignee(editAssignee);
		selectAssignee(assignee);
		selectEntryType(entryType);
		selectFormCategories(formCategories);
		selectFormName(formName);
		clickSaveButton();
	}

	public void verifyAllFields(String startHour, String endHour, String date, String assignee, String formCategories,
			String formName) {
		System.out.println("start hour: " + $(CalendarPageObject.getCalendarStartHourButton()).getAttribute("value"));
		assertEquals($(CalendarPageObject.getCalendarStartHourButton()).getAttribute("value"), startHour,
				"The start hour does not match!");
//		System.out.println("end hour: " + $(CalendarPageObject.getEndHour()).getAttribute("value"));
		assertEquals($(CalendarPageObject.getCalendarEndHourButton()).getAttribute("value"), endHour, "The end hour does not match!");
		assertEquals($(CalendarPageObject.getOpenCalendar()).getAttribute("value"), date, "The Date does not match");
		assertEquals($(CalendarPageObject.getAssigneeSelection()).getAttribute("value"), assignee,
				"Assignee does not match!");
		assertEquals($(CalendarPageObject.getFormCategories()).getAttribute("value"), formCategories,"Form Categorie is:");
		assertEquals($(CalendarPageObject.getFormName()).getAttribute("value"), formName, "Form names do not match!");
	
	}

	public String dateInCalendarForm(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
		LocalDate lDate = LocalDate.parse(date, formatter);
//		String[] myDate = lDate.toString().split("-");
		String[] data = getSplitDate(date);
		// LocalDate localDate = LocalDate.of(Integer.parseInt(data[2]),
		// Integer.parseInt(data[1]), Integer.parseInt(data[0]));
		String dayOfWeek = getDayStringNew(lDate);
		return dayOfWeek + " - " + data[1] + " " + data[0];
	}

	public static String getDayStringNew(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}

	public void clickScheduleButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CalendarPageObject.getCalendarScheduleButton())));
		$(CalendarPageObject.getCalendarScheduleButton()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CalendarPageObject.getScheduleForm())));
	}

	public void selectStartHour(String startHour) throws Exception {
		Thread.sleep(500);
		$(CalendarPageObject.getCalendarStartHourButton()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CalendarPageObject.getCalendarStartHourDropdown())));
		WebElement startHourUL = driver.findElement(By.id(CalendarPageObject.getCalendarStartHourDropdown()));
		List<WebElement> startHourIL = startHourUL.findElements(By.tagName("a"));
		for (WebElement li : startHourIL) {
			if (li.getText().equals(startHour)) {
				Thread.sleep(500);
				li.click();
			}
		}
	}

	public void selectEndHour(String endHour) throws InterruptedException {
		Thread.sleep(500);
		$(CalendarPageObject.getCalendarEndHourButton()).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CalendarPageObject.getCalendarEndHourDropdown())));
		WebElement endHourUL = driver.findElement(By.id(CalendarPageObject.getCalendarEndHourDropdown()));
		List<WebElement> endHourIL = endHourUL.findElements(By.tagName("a"));
		for (WebElement li : endHourIL) {
			if (li.getText().equals(endHour)) {
				Thread.sleep(500);
				li.click();
			}
		}
	}

	public void selectDateFromCalendar(int week, int day, int month) throws Exception {
		wait_for_id_elem_to_be_clickable(CalendarPageObject.getOpenCalendar(), 10);
		$(CalendarPageObject.getOpenCalendar()).click();
		Thread.sleep(1000);
		for(int i=0;i<month;i++){
			$(CalendarPageObject.getCalendarNextButton()).click();
		}
		WebElement elem = $("//div[4]/div[2]/div[1]/table/tbody/tr["+week+"]/td[@class='available']["+day+"]");
		if(!elem.isDisplayed()) {
			day=day-2;
			elem = $("//div[4]/div[2]/div[1]/table/tbody/tr["+week+"]/td[@class='available']["+day+"]");
			actualDate = elem.getText();
			elem.click();
		}else{
			actualDate = elem.getText();
			elem.click();
		}
		$(CalendarPageObject.getApplyButtonCalendar()).click();
	}

	public void selectAssignee(String assigneeName) throws InterruptedException {
		wait_for_id_elem_to_be_clickable(CalendarPageObject.getAssigneeSelection(), 10);
		Thread.sleep(3500);
		$(CalendarPageObject.getAssigneeSelection()).click();
		Select select = new Select($(CalendarPageObject.getAssigneeDropdown()));
		select.selectByVisibleText(assigneeName);
	}

	public void selectEntryType(String entryTypeName) {
		wait_for_id_elem_to_be_clickable(CalendarPageObject.getEntryTypeSelection(), 15);
		$(CalendarPageObject.getEntryTypeSelection()).click();
		Select select = new Select($(CalendarPageObject.getEntryTypeDropdown()));
		select.selectByVisibleText(entryTypeName);
	}

	public void selectFormCategories(String categoryName) {
		$(CalendarPageObject.getFormCategories()).click();
		Select select = new Select($(CalendarPageObject.getFormCategoriesDropdown()));
		select.selectByVisibleText(categoryName);
		$(CalendarPageObject.getEditFormTitle()).click();
	}

	public void selectFormName(String formName) throws Exception {
		Thread.sleep(500);
		$(CalendarPageObject.getFormName()).click();
		Select select = new Select($(CalendarPageObject.getFormNameDropdown()));
		select.selectByVisibleText(formName);
		$(CalendarPageObject.getEditFormTitle()).click();
	}

	public void clickSaveButton() throws Exception {
		$(CalendarPageObject.getSaveScheduleButton()).click();
		Thread.sleep(500);
	}

	public void verifyEventSaved(int userColumn) {
		String selector = String.format(CalendarPageObject.getScheduleContainerColumn(), userColumn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
		String eventActual = $(selector).getText();
		Assert.assertTrue(eventActual.contains("WO"));
	}

	public void clickEditForm() throws InterruptedException {
		wait_for_xpath_elem_to_be_clickable(CalendarPageObject.getFormEventInCalendar(), 10);
		$(CalendarPageObject.getFormEventInCalendar()).click();
		Thread.sleep(500);
	}

	public void clickRemoveScheduleButton() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(CalendarPageObject.getRemoveScheduleCalendar())));
		$(CalendarPageObject.getRemoveScheduleCalendar()).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String[] getSplitDate(String dayMonthYearValue) {
		return dayMonthYearValue.split(" ");
	}

	public void navigateToDate(String monthYear) {
		String[] dayMonthYear = getSplitDate(monthYear);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CalendarPageObject.getMonthMiddlePage())));
		String actualMonth = $(CalendarPageObject.getMonthMiddlePage()).getText();
		String actualYear = $(CalendarPageObject.getYearMiddlePage()).getText();
		//System.out.println("actual month: " + actualMonth);
		//$(CalendarPageObject.getCloseOverlay()).click();
		while (!actualMonth.equals(dayMonthYear[1])) {
			$(CalendarPageObject.getRightArrowMonth()).click();
			actualMonth = $(CalendarPageObject.getMonthMiddlePage()).getText();
		}
		while (!actualYear.equalsIgnoreCase(dayMonthYear[2])) {
			$(CalendarPageObject.getRightArrowYear()).click();
			actualYear = $(CalendarPageObject.getYearMiddlePage()).getText();
		}

		try {
			List<WebElement> allDays = driver.findElements(By.xpath(CalendarPageObject.getAllDatesMiddlePage()));
			//System.out.println(allDays.size());
			for (WebElement day : allDays) {
				if (day.getText().equals(dayMonthYear[0])) {
					JavascriptExecutor je = (JavascriptExecutor) driver;
					je.executeScript("arguments[0].scrollIntoView(true);", day);
					day.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> allDays = driver.findElements(By.xpath(CalendarPageObject.getAllDatesMiddlePage()));
			for (WebElement day : allDays) {
				if (day.getText().equals(dayMonthYear[0])) {
					day.click();
				}
			}
		}

	}

	public void selectDate(String expectedDay, String expectedMonth, String expectedYear) {
//		System.out.println(">>>expected day: " + expectedDay);
		if (expectedMonth.equals("February") && Integer.parseInt(expectedDay) > 29) {
			System.out.println("wrong date:" + expectedMonth + " " + expectedDay);
			return;
		}
		if (Integer.parseInt(expectedDay) > 31) {
			System.out.println("wrong date:" + expectedMonth + " " + expectedDay);
			return;
		}
		String monthAndYearVal = $(CalendarPageObject.getMonthCalendar()).getText();
		//System.out.println("monthAndYear: " + monthAndYearVal);

		while (!(getSplitDate(monthAndYearVal)[0].equals(expectedMonth)
				&& getSplitDate(monthAndYearVal)[1].equals(expectedYear))) {
			$(CalendarPageObject.getMoveNextCalendar()).click();
			monthAndYearVal = $(CalendarPageObject.getMonthCalendar()).getText();
			//System.out.println(monthAndYearVal);

		}
		try {
			List<WebElement> allDays = driver.findElements(By.xpath(CalendarPageObject.getAllDaysCalendar()));
			for (WebElement day : allDays) {
				if (day.getText().contains(expectedDay)) {
					day.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			List<WebElement> allDays = driver.findElements(By.xpath(CalendarPageObject.getAllDaysCalendar()));
			for (WebElement day : allDays) {
				if (day.getText().equalsIgnoreCase(expectedDay)) {
					day.click();
				}
			}
		}

	}

	public void clickNewEntry(int userCol, int hour, int hourDivision) {
		String selector = String.format(CalendarPageObject.getNewEntryFormUser(), userCol, hour, hourDivision);
		$(selector).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
