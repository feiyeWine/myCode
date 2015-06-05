package cn.Reference;

import java.util.WeakHashMap;

/**
 * WeakHashMap ��Ϊ�����ͣ�gc����ʱ��������
 * @author YR
 *
 */
public class WeakHashMapDemo
{
	public static void main(String[] args)
	{
		WeakHashMap<String,String> map = new WeakHashMap<>();
		//��������
		//�����ض��󣬲������
		map.put("a","good");
		map.put("b", "very Good");
		//gc���� �ѱ�����
		map.put(new String("d"),"bad");
		map.put(new String("e"), "bad");
		//֪ͨ����
		System.gc();
		System.runFinalization();
		
		System.out.println(map.size());
	}
}
