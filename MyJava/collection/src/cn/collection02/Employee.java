package cn.collection02;

public class Employee {
	private String id;
	private String name;
	private int salary;
	private String date;
	
	public Employee(String id, String name, int salary, String date) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.date = date;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
