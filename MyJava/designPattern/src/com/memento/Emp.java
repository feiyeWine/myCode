package com.memento;
/**
 * 原生器类
 * @author YR
 *
 */
public class Emp {
    private String name;
    private int age;
    private int salary;
    
    //进行备忘操作，并返回备忘录对象
    public EmpMemento memento(){
	return new EmpMemento(this);
    }
    //进行恢复操作
    public void recovery(EmpMemento emp){
	this.name = emp.getName();
	this.age  = emp.getAge();
	this.salary = emp.getSalary();
		
    }
    
    
    public Emp(String name, int age, int salary) {
	super();
	this.name = name;
	this.age = age;
	this.salary = salary;
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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
