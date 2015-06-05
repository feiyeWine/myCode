package cn.Reference;

import java.lang.ref.WeakReference;

/**
 * 引用：强、软、弱、虚
 * 强与弱
 * @author YR
 *
 */

public class RefDemo01
{
	public static void main(String[] args)
	{
		//字符串常量池
		String str = new String("it is very good");
		//弱引用 管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc 运行前："+wr.get());
		//断开引用
		str = null;
		//通知回收,被回收
		System.gc();
		System.runFinalization();
		System.out.println("gc 运行后："+wr.get());			
	}
	public static void test()
	{
		//字符串常量池、共享（不能回收）
		String str = "it is very good";
		//弱引用 管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc 运行前："+wr.get());
		//断开引用
		str = null;
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc 运行后："+wr.get());
	}
}
