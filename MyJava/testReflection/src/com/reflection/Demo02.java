package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bean.User;

/**
 * ͨ���������User��
 * @author YR
 *
 */
public class Demo02 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
	String path = "com.bean.User";
	
	//���ù�����
	    try {
		Class<User> clazz = (Class<User>) Class.forName(path);
		//ͨ���޲ι�����
		User  user1 = clazz.newInstance();
		System.out.println(user1);
		//ͨ���вι�����
		Constructor<User> c = clazz.getDeclaredConstructor(String.class,String.class,int.class); 
		User user2 = c.newInstance("13121","Mr wang",23);
		System.out.println(user2.getName());
		
		//������ͨ����
		User user3 = clazz.newInstance();
		Method method = clazz.getMethod("setName", String.class);
		method.invoke(user3, "Mr zhang");//user3.setName("Mr zhang")
		System.out.println(user3.getName());
		//��������
		User user4 = clazz.newInstance();
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);//������ȫ��飬����ֱ�ӷ���private����
		f.set(user4, "Mr li");
		System.out.println(user4.getName());//ͨ������ֱ�Ӷ����Ե�ֵ
		System.out.println(f.get(user4));
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    } catch (InstantiationException e) {
		e.printStackTrace();
	    } catch (IllegalAccessException e) {
		e.printStackTrace();
	    }
    }
}
