package sort;

public class Workers implements Comparable<Workers>{
	private String type;
	private double salary;
	
	public Workers(String type, double salary) {
		super();
		this.type = type;
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Workers o) {
		
		return this.salary>o.salary?1:(this.salary==o.salary?0:-1);
	}
	@Override
	public String toString() {
		
		return "职业："+this.type+"工资："+this.salary+"\n";
	}

}
