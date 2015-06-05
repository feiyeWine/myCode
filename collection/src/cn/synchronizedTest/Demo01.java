package cn.synchronizedTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *同步控制（线程安全）
 *synchronizedList
 *synchronizedMap
 *synchronizedSet
 * @author YR
 *
 */
public class Demo01
{
	public static void main(String[] args)
	{
		Map<String,String> map =new HashMap<String,String>();
		map.put("a","abc");
		map.put("b","bcd");
		Map map2 = Collections.synchronizedMap(map);
		System.out.println(map2.size());
	}
}
