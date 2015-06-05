package cn.testDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * ≤‚ ‘DateFromat¿‡
 * @author YR
 *
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
	Date df = new Date();
	DateFormat date = DateFormat.getDateInstance();
	DateFormat date2 = DateFormat.getDateTimeInstance();
	DateFormat date3 = DateFormat.getTimeInstance();
	df = date.parse("2011-05-28");
	System.out.println(df);
	System.out.println(DateFormat.SHORT);
	System.out.println(DateFormat.LONG);
    }
}
