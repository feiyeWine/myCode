package cn.collectior;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEqual {
	public static void main(String [] args){
		List list = new ArrayList();
		String s1 = new String("aaa");
		String s2 = new String("aaa");
		list.add(s1);
		list.add(s2);
		System.out.println(list.size());
		Map map = new HashMap();
		//¼ü²»ÄÜÖØ¸´
		map.put(s1,"AAAA");
		map.put(s2,"BBBBB");
		System.out.println(map.get("aaa"));
	}
}
	