package com.secondWork;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日历
 *  @author 尹榕（13121073）
 *
 *
 */
public class Cal {
    public static void main(String[] args) 
    {
	try
	{
	Calendar calendar=new GregorianCalendar();
	int month=0;
	int year=0;
	if(args.length==0){	//是否以参数形式写入年月份
	 month = calendar.get(Calendar.MONTH)+1;
	 year = calendar.get(Calendar.YEAR);
	 }else{			//读取当前年月份
	     try {
		month = Integer.parseInt(args[0]);
		year = Integer.parseInt(args[1]);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	 }
	String temp = month+" "+year;
	DateFormat format=new SimpleDateFormat("MM yyyy");		
	Date date=format.parse(temp);
	calendar.setTime(date);
    	int day = calendar.get(Calendar.DATE);
    	calendar.set(Calendar.DATE, 1);
    	System.out.println(getMonth(calendar.get(Calendar.MONTH)+1)+" "+calendar.get(Calendar.YEAR));
    	int maxDate=calendar.getActualMaximum(Calendar.DATE);
    	System.out.println("Su\tMo\tTu\tWe\tTh\tFr\tSa");
    	for (int i = 1; i <calendar.get(Calendar.DAY_OF_WEEK); i++) 
    	{
    		System.out.print('\t');
    				
    	}
    	for(int i=1;i<=maxDate;i++){
    	    if(i==day)
    		System.out.print("");
    		System.out.print(i+"\t");
    		int w=calendar.get(Calendar.DAY_OF_WEEK);
    		if(w==Calendar.SATURDAY){
    		System.out.println('\n');
    		}
    		calendar.add(Calendar.DATE,1);
    	}
    			
    	}catch (Exception e) {
    	    e.printStackTrace();
    	}	
    }
    //十二个月份的英文表示
    public static String getMonth(int month){
	String value=null;
	switch(month){
	case 1:
	    value = "January";
	    break;
        case 2:
            value="February" ;   
            break;
        case 3:
            value="March" ;
            break;
        case 4:
            value="April" ;
            break;
        case 5:
            value="May" ;
            break;
        case 6:
            value="June" ;
            break;
        case 7:
            value="Juny" ;
            break;
        case 8:
            value="August" ;
            break;
        case 9:
            value="September" ;
            break;
        case 10:
            value="October" ;
            break;
        case 11:
            value="November" ;
            break;
        case 12:
            value="December" ;
            break;
	}
	return value;
    }
}
