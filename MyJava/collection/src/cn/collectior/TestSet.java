package cn.collectior;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		System.out.println(set.size());
		set.remove("aaa");
		System.out.println(set.contains("aaa"));
		System.out.println(set.size());
		set.add(new String("aaa"));
		System.out.println(set.toString());
		set.clear();
		System.out.println(set.size());
	}

}
