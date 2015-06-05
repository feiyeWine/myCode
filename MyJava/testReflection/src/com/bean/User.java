package com.bean;

public class User {
    private String num;
    private String name;
    private int age ;
    public User(){
	
    }
    public User(String num, String name, int age) {
	super();
	this.num = num;
	this.name = name;
	this.age = age;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
