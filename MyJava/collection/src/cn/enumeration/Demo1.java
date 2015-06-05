package cn.enumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration的使用
 * 1、判断hasMoreElements()
 * 2.获取nextElement()
 * Vector的elements()方法
 * 
 * @author YR
 *
 */
public class Demo1
{
	public static void main(String[] args)
	{
		Vector<String> vector = new Vector<>();
		vector.add("abc");
		vector.add("bcd");
		vector.add("efg");
		Enumeration<String> en = vector.elements();
		//遍历Vector
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}
}
