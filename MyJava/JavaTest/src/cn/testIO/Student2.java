package cn.testIO;

import java.io.Serializable;

/**
 * 实行序列化
 * @author YR
 *
 */
public class Student2 implements Serializable{
     int id;
     String name;
     int age ;
    public Student2(int id, String name, int age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
    }
}
