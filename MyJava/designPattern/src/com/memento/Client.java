package com.memento;

public class Client {
    public static void main(String[] args) {
	CareTaker c = new CareTaker();
	Emp emp = new Emp("Mr Li", 29, 900);
	
	System.out.println("��һ�δ�������"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
	c.setMmt(emp.memento());
	emp.setName("Mr huang");
	emp.setAge(22);
	emp.setSalary(6000);
	System.out.println("�ڶ��δ�������"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
	emp.recovery(c.getMmt());
	System.out.println("�����δ�������"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
    }
}
