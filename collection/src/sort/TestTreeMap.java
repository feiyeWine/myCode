package sort;

import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		Workers w1 = new Workers("垃圾回收员",1000);
		Workers w2 = new Workers("农民工",2000);
		Workers w3 = new Workers("程序员",6000);
		TreeMap<Workers,String> employee = new TreeMap<>();
		
		employee.put(w1,"hello");
		employee.put(w2,"hello");
		employee.put(w3,"hello");
		System.out.println(employee.keySet());
	}

}
