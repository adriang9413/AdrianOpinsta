package pageObjects;

public class CalendarPageObject {
	private static String calendarScheduleButton = "//*[@dt-at='calendarScheduleButton']";
	private static String scheduleForm = "//*[@dt-at='scheduleForm']";
	private static String firstUserMidnight = "235_0_1";
	private static String secondUserMidnight = "234_0_1";
	private static String dateRowForCalendarForm = "//*[@dt-at='dateRowForCalendarForm']";
	private static String calendarStartHourButton = "start_hour";
	private static String calendarStartHourDropdown = "start_hour--dropdown";
	private static String calendarEndHourButton = "end_hour";
	private static String calendarEndHourDropdown = "end_hour--dropdown";
	private static String topDateRow = "day-selector_container";
	private static String openCalendar = "current_datetime";
	private static String moveNextCalendar = "//div[@class='drp-calendar left single']//div[@class='calendar-table']//table[@class='table-condensed']//thead//tr//th[@class='next available']";
	private static String movePreviousCalendar = "//th[@class='prev available']";
	private static String allDaysCalendar = "//td[@class='available' or @class='weekend available']";
	private static String monthCalendar = "//table[@class='table-condensed']/thead/tr[1]/th[2]";
	private static String monthMiddlePage = "//div[@class='month-selector']/p";
	private static String leftArrowMonth = "//*[@dt-at='leftArrowMonth']";
	private static String rightArrowMonth  = "//*[@dt-at='rightArrowMonth']";
	private static String yearMiddlePage = "//div[@class='year-selector']/p";
	private static String leftArrowYear = "//*[@dt-at='leftArrowYear']";
	private static String rightArrowYear = "//*[@dt-at='rightArrowYear']";
	private static String allDatesMiddlePage = "//div[@dt-day]//p[2]";
	private static String applyButtonCalendar = "//*[@dt-at='applyButtonCalendar']";
	private static String assigneeSelection = "assigned_user_id--input";
	private static String assigneeDropdown = "//*[@dt-at='userEntryTypesButton']";
	private static String entryTypeSelection = "entry_type--input";
	private static String entryTypeDropdown = "entry_type--select";
	private static String formCategories = "form_categories--input";
	private static String formCategoriesDropdown = "form_categories--select";
	private static String formName = "form_names--input";
	private static String formNameDropdown = "form_names--select";
	private static String saveScheduleButton = "//*[@dt-at='saveScheduleButton']";
	private static String allUsersCalendar = "//div[@id='users_container']/div/div/p";
	private static String scheduleContainerUserColumn = "//div[@id='schedule_container']/div[%d]//div[1]/p";
	private static String formEventInCalendar = "//*[@dt-at='formEventInCalendar']";
	private static String removeScheduleCalendar = "remove_schedule--btn";
	private static String userMandatoryError ="//*[@dt-at='userMandatoryError']";
	private static String entryTypeMandatoryError = "//*[@dt-at='entryTypeMandatoryError']";
	private static String formCategoriesError = "//*[@dt-at='formCategoriesError']";
	private static String formNameError = "//*[@dt-at='formNameError']";
	private static String newEntryFormUser = "//div[@id='schedule_container']/div[%d]/div[%d]/div[%d]";
	private static String closeScheduleModal = "//*[@dt-at='closeScheduleModal']";
	private static String listOfUsers = "//ul/ul";
	private static String calendarNextButton = "//div[4]/div[2]/div[1]/table/thead/tr[1]/th[3]";
	private static String topCalendarNextButton = "//*[@dt-at='rightArrowMonth']";
	private static String scheduleContainer = "schedule_container";
	private static String editFormTitle = "addScheduleTitle";


	public static String getCalendarScheduleButton() {
		return calendarScheduleButton;
	}

	public static String getScheduleForm() {
		return scheduleForm;
	}

	public static String getCalendarStartHourButton() {
		return calendarStartHourButton;
	}

	public static String getCalendarStartHourDropdown() {
		return calendarStartHourDropdown;
	}

	public static String getCalendarEndHourButton() {
		return calendarEndHourButton;
	}

	public static String getOpenCalendar() {
		return openCalendar;
	}

	public static String getMoveNextCalendar() {
		return moveNextCalendar;
	}

	public static String getMovePreviousCalendar() {
		return movePreviousCalendar;
	}

	public static String getAllDaysCalendar() {
		return allDaysCalendar;
	}

	public static String getMonthCalendar() {
		return monthCalendar;
	}

	public static String getMonthMiddlePage() {
		return monthMiddlePage;
	}

	public static String getLeftArrowMonth() {
		return leftArrowMonth;
	}

	public static String getRightArrowMonth() {
		return rightArrowMonth;
	}

	public static String getCalendarEndHourDropdown() {
		return calendarEndHourDropdown;
	}

	public static String getAssigneeSelection() {
		return assigneeSelection;
	}

	public static String getAssigneeDropdown() {
		return assigneeDropdown;
	}

	public static String getEntryTypeSelection() {
		return entryTypeSelection;
	}

	public static String getEntryTypeDropdown() {
		return entryTypeDropdown;
	}

	public static String getFormCategories() {
		return formCategories;
	}

	public static String getFormCategoriesDropdown() {
		return formCategoriesDropdown;
	}

	public static String getFormName() {
		return formName;
	}

	public static String getFormNameDropdown() {
		return formNameDropdown;
	}

	public static String getSaveScheduleButton() {
		return saveScheduleButton;
	}

	public static String getAllUsersCalendar() {
		return allUsersCalendar;
	}

	public static String getScheduleContainerColumn() {
		return scheduleContainerUserColumn;
	}

	public static String getRightArrowYear() {
		return rightArrowYear;
	}

	public static String getLeftArrowYear() {
		return leftArrowYear;
	}

	public static void setLeftArrowYear(String leftArrowYear) {
		CalendarPageObject.leftArrowYear = leftArrowYear;
	}

	public static String getYearMiddlePage() {
		return yearMiddlePage;
	}

	public static String getApplyButtonCalendar() {
		return applyButtonCalendar;
	}

	public static String getAllDatesMiddlePage() {
		return allDatesMiddlePage;
	}

	public static String getFormEventInCalendar() {
		return formEventInCalendar;
	}

	public static String getRemoveScheduleCalendar() {
		return removeScheduleCalendar;
	}

	public static String getUserMandatoryError() {
		return userMandatoryError;
	}

	public static String getEntryTypeMandatoryError() {
		return entryTypeMandatoryError;
	}

	public static String getFormCategoriesError() {
		return formCategoriesError;
	}

	public static String getFormNameError() {
		return formNameError;
	}

	public static String getNewEntryFormUser() {
		return newEntryFormUser;
	}

	public static String getCloseScheduleModal() {
		return closeScheduleModal;
	}

	public static String getFirstUserMidnight() {
		return firstUserMidnight;
	}

	public static String getDateRowForCalendarForm() {
		return dateRowForCalendarForm;
	}

	public static String getSecondUserMidnight() {
		return secondUserMidnight;
	}

	public static String getTopDateRow() {
		return topDateRow;
	}

	public static String getListOfUsers() {
		return listOfUsers;
	}

	public static String getCalendarNextButton() {
		return calendarNextButton;
	}

	public static String getTopCalendarNextButton() {
		return topCalendarNextButton;
	}

	public static String getScheduleContainer() {
		return scheduleContainer;
	}

	public static String getEditFormTitle() {
		return editFormTitle;
	}
}
