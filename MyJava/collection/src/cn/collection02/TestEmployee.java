package cn.collection02;

import java.util.ArrayList;
import java.util.List;

public class TestEmployee {
	public static void main(String[] args) {
		Employee e = new Employee("001","高琪",3000,"2007-10");
		Employee e1 = new Employee("002","马士兵",3500,"2006-10");
		Employee e2 = new Employee("003","裴新",3600,"2007-10");
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e1);
		list.add(e2);
		for(int i = 0;i<list.size();i++)
		{
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getDate());
		}
	}

}
