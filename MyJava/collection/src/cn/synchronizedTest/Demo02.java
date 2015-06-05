package cn.synchronizedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 只读
 * 1.emptyList()
 * 	emptyMap()
 * 	emptySet()
 * 2.singleton(T o) set  返回一个只包含指定对象的不可变 set。
 * 	singletonList(T o)
 * 	singletonMap(T o)
 * 3.unmodifiableList(List<? extends T> list) 
 * 	unmodifiableSet(List<? extends T> Set) 
 * unmodifiableMap(List<? extends T> Map) 
 * @author YR
 *
 */
public class Demo02
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		List list2 =Collections.unmodifiableList(list);
		
		//list2.add("c");不可操作
		System.out.println(list2.size());
		Set set = new HashSet();
		set.add("abc");
		Set set2 = Collections.singleton(set);
		//set2.add("bbb"); 不可操作
		System.out.println(set2.size());
		Map<String,String> map = Collections.EMPTY_MAP;
		//map.put("aaa", "vvv");不可操作
		System.out.println(map.size());
		
	}
}
