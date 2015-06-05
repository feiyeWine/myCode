package com.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试单例模式
 * @author YR
 *
 */
public class TestSingleton {
    public static void main(String[] args) throws Exception {
	Singleton5 s1 = Singleton5.getInstance();
	System.out.println(s1);
	
	//通过反射破解单例
	/*Class<Singleton5> clazz = (Class<Singleton5>) Class.forName("com.singleton.Singleton5");
	Constructor<Singleton5> c = clazz.getDeclaredConstructor(null);
	c.setAccessible(true);
	Singleton5 s2 = c.newInstance();
	System.out.println(s2);*/
	
	//通过反序列化破解单例
	FileOutputStream fos = new FileOutputStream("./singleton.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(s1);
	oos.close();
	//反序列化
	FileInputStream fis = new FileInputStream("./singleton.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);
	Singleton5 s3 = (Singleton5) ois.readObject();
	System.out.println(s3);
    }
    
}
