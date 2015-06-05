package com.singleton;
/**
 * ����ģʽSingleton
 * Ӧ�ó��ϣ���Щ����ֻ��Ҫһ�����㹻��
 * ���ã���֤����Ӧ�ó�����ĳ��ʵ������ֻ��һ��
 * ���ͣ�����ģʽ������ģʽ
 * @author YR
 *
 */
//����ģʽ
public class Singleton {
    //1�������췽��˽�л����������ⲿֱ�Ӵ�������
    private Singleton(){
	
    }
    //2���������Ψһʵ��,ʹ��private static����
   private static Singleton instance = new Singleton();
   //3���ṩһ�����ڻ�ȡʵ���ķ�����ʹ��public static����
   public static  Singleton getIntance(){
       return instance;
   }
}
