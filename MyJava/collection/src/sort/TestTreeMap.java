package sort;

import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		Workers w1 = new Workers("��������Ա",1000);
		Workers w2 = new Workers("ũ��",2000);
		Workers w3 = new Workers("����Ա",6000);
		TreeMap<Workers,String> employee = new TreeMap<>();
		
		employee.put(w1,"hello");
		employee.put(w2,"hello");
		employee.put(w3,"hello");
		System.out.println(employee.keySet());
	}

}
