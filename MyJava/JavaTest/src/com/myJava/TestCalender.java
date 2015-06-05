package com.myJava;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 输入年、月值，排出该月月历
 * @author YR
 *
 */
public class TestCalender {
    public static void main(String[] args) {
	getCalender();
    }
    private static void getCalender(){
	Scanner sc = new Scanner(System.in);
	int year = sc.nextInt();
	int month = sc.nextInt();
	Calendar today = new GregorianCalendar(year,month-1,1);
	System.out.println(year+"年"+month+"月 月历");
	System.out.println("	星期六 星期一 星期二 星期三 星期四 星期五 星期日");
	for (int i = 0; i < today.get(Calendar.DAY_OF_WEEK)-1; i++) {
	    System.out.print("	");
	}
	for(int i = 0;i<today.getActualMaximum(Calendar.DAY_OF_MONTH);i++){
	    if((i+today.get(Calendar.DAY_OF_WEEK)-1)%7==0){
		System.out.println();
	    }
	    if(i+1<10){
		System.out.print(" ");
	    }
	    System.out.print("	"+(i+1));
	}
	
    }
}
