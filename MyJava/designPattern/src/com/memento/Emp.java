package com.memento;
/**
 * ԭ������
 * @author YR
 *
 */
public class Emp {
    private String name;
    private int age;
    private int salary;
    
    //���б��������������ر���¼����
    public EmpMemento memento(){
	return new EmpMemento(this);
    }
    //���лָ�����
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
