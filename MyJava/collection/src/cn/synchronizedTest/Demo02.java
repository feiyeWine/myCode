package cn.synchronizedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ֻ��
 * 1.emptyList()
 * 	emptyMap()
 * 	emptySet()
 * 2.singleton(T o) set  ����һ��ֻ����ָ������Ĳ��ɱ� set��
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
		
		//list2.add("c");���ɲ���
		System.out.println(list2.size());
		Set set = new HashSet();
		set.add("abc");
		Set set2 = Collections.singleton(set);
		//set2.add("bbb"); ���ɲ���
		System.out.println(set2.size());
		Map<String,String> map = Collections.EMPTY_MAP;
		//map.put("aaa", "vvv");���ɲ���
		System.out.println(map.size());
		
	}
}
