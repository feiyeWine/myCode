package com.prototype;

import java.util.Date;

/**
 * 测试原型模式
 * 深复制
 * @author YR
 *
 */
public class Sheep2 implements Cloneable{
    private String name;
    private  Date birthday;
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
       Object obj = super.clone();
       //实现深复制,clone 属性
       Sheep2 s = (Sheep2) obj;
       s.birthday = (Date) this.birthday.clone();
       return obj;
    }
    public Sheep2(String name, Date birthday) {
	super();
	this.name = name;
	this.birthday = birthday;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public Sheep2(){}
}
