package cn.Reference;

import java.util.IdentityHashMap;

/**
 *  IdentityHashMap���Ƚϵ�ַȥ��
 */
public class IdentityHashMapDemo
{
	public static void main(String[] args)
	{
		IdentityHashMap<String,String> map = new IdentityHashMap<>();
		//�������е�a
		map.put("a","a1");
		map.put("a","a2");
		System.out.println(map.size());
		map.put(new String("a"), "a3");
		map.put(new String ("a"), "a4");
		System.out.println(map.size());
	}
}
