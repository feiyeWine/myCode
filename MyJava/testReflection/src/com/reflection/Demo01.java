package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试反射
 * @author YR
 *
 */
public class Demo01 {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
	String path = "com.bean.User";
	try {
	    Class<?> clazz = Class.forName(path);
	    //获取类的名字
	    System.out.println(clazz.getName());//获取包名+类名
	    System.out.println(clazz.getSimpleName());//获取类名：User
	    //获取属性信息
	    //Field[] fields = clazz.getFields();//只能获得public的field
	    Field[] fields = clazz.getDeclaredFields();//获得所有的field
	    Field f = clazz.getDeclaredField("name");
	    System.out.println(fields.length);
	    for(Field temp:fields){
		System.out.println("属性："+temp);
	    }
	    //获取方法信息
	    Method[] methods  = clazz.getDeclaredMethods();
	    Method m = clazz.getDeclaredMethod("getName",null );
	    Method m2 = clazz.getDeclaredMethod("setName", String.class);//如果方法有参数，必须传递类型
	    for(Method mt : methods){
		System.out.println("方法:"+mt);
	    }
	    //获得构造方法的信息
	    Constructor<?>[] cons =  clazz.getConstructors();
	    for(Constructor<?> c:cons){
		System.out.println("构造器："+c);
	    }
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
