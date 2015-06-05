package cn.testDate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
    public static void main(String[] args) {
	System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	System.out.println(sdf.format(date));
    }
}
