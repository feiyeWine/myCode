package com.testClassLoad;
/**
 * 测试自定义加载类
 * @author YR
 *
 */
public class TestFileSystemClassLoader {
    public static void main(String[] args) throws Exception {
	
    
        FileSystemClassLoader loader = new FileSystemClassLoader("E:/MyJava/ClassLoadTest/src/com/testClassLoad");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("E:/MyJava/ClassLoadTest/src/com/testClassLoad");
        Class<?> c = loader.loadClass("com.testClassLoad.Hello");
        System.out.println(c);
        Class<?> c2 = loader.loadClass("com.testClassLoad.Hello");
        Class<?> c3 = loader2.loadClass("com.testClassLoad.Hello");
        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}