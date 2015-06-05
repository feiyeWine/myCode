package cn.testDate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar c= new GregorianCalendar();
		//c.set(2001,1,10,12,23,34);
		Date d = c.getTime();
		System.out.println(d);
		c.set(Calendar.YEAR,2001);
		c.set(Calendar.DATE, 10);
		System.out.println(c.getTime());
		c.add(Calendar.MONTH,30);
		System.out.println(c);
	
	
	}

}
