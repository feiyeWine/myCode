package com.testClassLoad;
/**
 * ���Լ򵥼��ܽ��ܲ�����ȥ����
 * @author YR
 *
 */
//�д���
public class TestCode {
    public static void main(String[] args) throws Exception {
	
	//FileSystemClassLoader loader = new FileSystemClassLoader("E:/MyJava/ClassLoadTest/src/com/testClassLoad/com/testClassLoad/Hello.class");
	DecrptClassLoader loader = new DecrptClassLoader("E:/MyJava/ClassLoadTest/src/com/testClassLoad/com/testClassLoad");
	Class<?> c = loader.loadClass("Hello");
	System.out.println(c);
    }
}
