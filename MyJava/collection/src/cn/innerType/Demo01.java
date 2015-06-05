package cn.innerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01 {
	public static void main(String[] args) {
		String arr[]={"abd","abc","abcd"};
		Util.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		List<String> list= new ArrayList();
		list.add("aaa");
		list.add("abd");
		list.add("abc");
		Util.sort(list);
		System.out.println(list.toString());
		
	}

}
