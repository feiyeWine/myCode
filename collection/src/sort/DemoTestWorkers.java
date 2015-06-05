package sort;

import java.util.TreeSet;

public class DemoTestWorkers {
	public static void main(String[] args) {
		Workers w1 = new Workers("垃圾回收员",1000);
		Workers w2 = new Workers("农民工",2000);
		Workers w3 = new Workers("程序员",6000);
		TreeSet<Workers> employee = new TreeSet<>();
		
		employee.add(w1);
		employee.add(w2);
		employee.add(w3);
		System.out.println(employee);
	}

}
