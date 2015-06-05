package com.fiveWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PIMTodo extends PIMEntity implements DateFormat{
    private Date date;
    private String text;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void fromString(String s) {
	System.out.println(s);
    }

    @Override
    public String toString() {
	return "TODO "+getPriority()+" "+dateFormatString(getDate())+" "+getText();
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
