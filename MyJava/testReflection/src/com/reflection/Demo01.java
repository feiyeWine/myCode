package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���Է���
 * @author YR
 *
 */
public class Demo01 {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
	String path = "com.bean.User";
	try {
	    Class<?> clazz = Class.forName(path);
	    //��ȡ�������
	    System.out.println(clazz.getName());//��ȡ����+����
	    System.out.println(clazz.getSimpleName());//��ȡ������User
	    //��ȡ������Ϣ
	    //Field[] fields = clazz.getFields();//ֻ�ܻ��public��field
	    Field[] fields = clazz.getDeclaredFields();//������е�field
	    Field f = clazz.getDeclaredField("name");
	    System.out.println(fields.length);
	    for(Field temp:fields){
		System.out.println("���ԣ�"+temp);
	    }
	    //��ȡ������Ϣ
	    Method[] methods  = clazz.getDeclaredMethods();
	    Method m = clazz.getDeclaredMethod("getName",null );
	    Method m2 = clazz.getDeclaredMethod("setName", String.class);//��������в��������봫������
	    for(Method mt : methods){
		System.out.println("����:"+mt);
	    }
	    //��ù��췽������Ϣ
	    Constructor<?>[] cons =  clazz.getConstructors();
	    for(Constructor<?> c:cons){
		System.out.println("��������"+c);
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
