import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AgeCalculator {

	public static void main(String[] args) throws ParseException {
		
		Date d = new Date();
		Date bday = new SimpleDateFormat("yyyy/dd/MM").parse("1992/20/12");
		System.out.println(d);
		System.out.println(bday);
		long totalMill = d.getTime() - bday.getTime();
		// 1 sec = 1000 millisec
		//Calendar.
		long days = totalMill/(1000*60*60*24);
		System.out.println(days);
		long year = days/365;
		long months = (days%365)/30;
		System.out.println(year);
		System.out.println(months);
		System.out.println(TimeUnit.DAYS.convert(totalMill, TimeUnit.MILLISECONDS));
		//Calendar cal = Calendar.getInstance();

	}
}
