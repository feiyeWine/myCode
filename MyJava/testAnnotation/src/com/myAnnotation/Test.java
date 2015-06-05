package com.myAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ½âÎö×¢½â
 * @author YR
 *
 */
public class Test {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
	try {
	    Class clazz = Class.forName("com.myAnnotation.AnnotationTest");
	   Annotation[] annotation = clazz.getAnnotations();
	   for (Annotation an : annotation) {
	    System.out.println(an);
	   }
	   Field[] f = clazz.getDeclaredFields();
	   for (Field field : f) {
	    System.out.println(field.getName());
	}
	   Field f2 = clazz.getDeclaredField("uname");
	   TestAnnotation an2 = f2.getAnnotation(TestAnnotation.class);
	   System.out.println(an2.column()+"  "+an2.uname()+"  "+an2.length());
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }
     
}
