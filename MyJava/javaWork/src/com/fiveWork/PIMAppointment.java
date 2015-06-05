package com.fiveWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PIMAppointment extends PIMEntity implements DateFormat{
    private Date date;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void fromString(String s) {
	System.out.println(s);
    }

    @Override
    public String toString() {
	return "APPOINTMENT "+getPriority()+" "+dateFormatString(getDate())+" "+getDescription();
    }

    @Override
    public Date stringFormatDate(String str) {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	try {
	    date = sdf.parse(str);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return date;
    }

    @Override
    public String dateFormatString(Date date) {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	String str = sdf.format(date);
	return str;
    }
}
