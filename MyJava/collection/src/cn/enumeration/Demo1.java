package cn.enumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration��ʹ��
 * 1���ж�hasMoreElements()
 * 2.��ȡnextElement()
 * Vector��elements()����
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
		//����Vector
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}
}
