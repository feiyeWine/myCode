package com.singleton;
/**
 *单例模式：
 *静态内部类
 * @author YR
 *
 */
public class Singleton3 {
    SingletonDemo s = SingletonDemo.getInstance();
   private static class  SingletonDemo{
	private SingletonDemo() {
	}
	private static final SingletonDemo instance = new SingletonDemo();
	public static SingletonDemo getInstance(){
	    return SingletonDemo.instance;
	}
    }
}
