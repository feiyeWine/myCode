package com.singleton;
/**
 *����ģʽ��
 *��̬�ڲ���
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
