package com.prototype;

import java.util.Date;

/**
 * ≤‚ ‘«≥∏¥÷∆
 * @author YR
 *
 */
public class Client2 {
    public static void main(String[] args) throws CloneNotSupportedException {
	Date date =  new Date(1232454343L);
	Sheep2 s1 = new Sheep2("…Ÿ¿˚",date );
	System.out.println(s1);
	System.out.println(s1.getName());
	System.out.println(s1.getBirthday());
	Sheep2 s2 = (Sheep2) s1.clone();
	
	date.setTime(183598435943465L);
	
	System.out.println(s1.getBirthday());
	System.out.println(s2);
	System.out.println(s2.getName());
	System.out.println(s2.getBirthday());
    }
}
