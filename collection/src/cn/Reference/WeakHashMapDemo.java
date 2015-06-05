package cn.Reference;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱类型，gc运行时立即回收
 * @author YR
 *
 */
public class WeakHashMapDemo
{
	public static void main(String[] args)
	{
		WeakHashMap<String,String> map = new WeakHashMap<>();
		//测试数据
		//常量池对象，不会回收
		map.put("a","good");
		map.put("b", "very Good");
		//gc运行 已被回收
		map.put(new String("d"),"bad");
		map.put(new String("e"), "bad");
		//通知回收
		System.gc();
		System.runFinalization();
		
		System.out.println(map.size());
	}
}
