import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyDate {
	static String pdate = "14 June 2021";
	//static String pdate = LocalDate.now().toString();
	
	public static void main(String[] args) {
		LocalDate lDate = LocalDate.of(2021, 06, 14);
		DayOfWeek dayOfWeek = lDate.getDayOfWeek();
		//System.out.println(dayOfWeek.toString());
		MyDate myDate = new MyDate();
		
		getDayStringNew(lDate, Locale.ENGLISH);
		String string = "14 January 2010";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(string, formatter);
		System.out.println("date in calendar: " + myDate.dateInCalendarForm(pdate));
		System.out.println(date); 
	}
	
	public String dateInCalendarForm(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
		LocalDate lDate = LocalDate.parse(date, formatter);
		String [] myDate = lDate.toString().split("-");
		String [] data = getSplitDate(date);
		//LocalDate localDate = LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0]));
		String dayOfWeek = getDayStringNew(lDate, Locale.ENGLISH);
		return dayOfWeek + " - " + data[1] + " " + data[0];
	}
//	public String getDayStringNew(LocalDate date) {
//	    DayOfWeek day = date.getDayOfWeek();
//	    return day.toString();
//	}
	
	public static String getDayStringNew(LocalDate date, Locale locale) {
	    DayOfWeek day = date.getDayOfWeek();
	    return day.getDisplayName(TextStyle.FULL, locale);
	}
	public String[] getSplitDate(String dayMonthYearValue) {
		return dayMonthYearValue.split(" ");
	}

}
