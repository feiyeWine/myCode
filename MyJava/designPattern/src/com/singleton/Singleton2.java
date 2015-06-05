package com.singleton;
/**
 * ����ģʽ
 * @author YR
 *
 */
public class Singleton2 {
    //1�������췽��˽�л������������ֱ�Ӵ�������
    private Singleton2(){
	
    }
    //2���������Ψһʵ����ʹ��private static����
    private static Singleton2 instance;
    //3���ṩһ�����ڻ�ȡʵ���ķ�����ʹ��public static����
    public static synchronized Singleton2 getIntance(){
	if(instance==null){
	   instance = new Singleton2();
	}
	return instance;
    }
}
