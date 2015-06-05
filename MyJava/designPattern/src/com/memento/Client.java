package com.memento;

public class Client {
    public static void main(String[] args) {
	CareTaker c = new CareTaker();
	Emp emp = new Emp("Mr Li", 29, 900);
	
	System.out.println("第一次创建对象："+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
	c.setMmt(emp.memento());
	emp.setName("Mr huang");
	emp.setAge(22);
	emp.setSalary(6000);
	System.out.println("第二次创建对象："+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
	emp.recovery(c.getMmt());
	System.out.println("第三次创建对象："+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
    }
}
