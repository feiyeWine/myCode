package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bean.User;

/**
 * 通过反射访问User类
 * @author YR
 *
 */
public class Demo02 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
	String path = "com.bean.User";
	
	//调用构造器
	    try {
		Class<User> clazz = (Class<User>) Class.forName(path);
		//通过无参构造器
		User  user1 = clazz.newInstance();
		System.out.println(user1);
		//通过有参构造器
		Constructor<User> c = clazz.getDeclaredConstructor(String.class,String.class,int.class); 
		User user2 = c.newInstance("13121","Mr wang",23);
		System.out.println(user2.getName());
		
		//调用普通方法
		User user3 = clazz.newInstance();
		Method method = clazz.getMethod("setName", String.class);
		method.invoke(user3, "Mr zhang");//user3.setName("Mr zhang")
		System.out.println(user3.getName());
		//操作属性
		User user4 = clazz.newInstance();
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);//不做安全检查，可以直接访问private属性
		f.set(user4, "Mr li");
		System.out.println(user4.getName());//通过反射直接读属性的值
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
