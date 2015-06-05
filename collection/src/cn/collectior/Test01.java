package cn.collectior;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add(new Date());
		list.add(1234);  //包装类的：自动装箱
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	//	list.remove("aaa");
	//	System.out.println(list.size());
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		System.out.println(list.size());
		
		//跟顺序的操作
		String str = (String)list.get(0);
		System.out.println(str);
		list.set(1,"abcdef");
		list.remove(0);
	}
}
