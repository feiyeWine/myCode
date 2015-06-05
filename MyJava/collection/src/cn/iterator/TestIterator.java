package cn.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestIterator {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		for(int i = 0; i<list.size();i++){
			System.out.println(list.get(i));
		}
		Set set = new HashSet();
		set.add("111");
		set.add("222");
		set.add("333");
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			System.out.println((String)ite.next());	
		}
		ite.remove();
		
	}
}
