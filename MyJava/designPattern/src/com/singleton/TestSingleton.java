package com.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ���Ե���ģʽ
 * @author YR
 *
 */
public class TestSingleton {
    public static void main(String[] args) throws Exception {
	Singleton5 s1 = Singleton5.getInstance();
	System.out.println(s1);
	
	//ͨ�������ƽⵥ��
	/*Class<Singleton5> clazz = (Class<Singleton5>) Class.forName("com.singleton.Singleton5");
	Constructor<Singleton5> c = clazz.getDeclaredConstructor(null);
	c.setAccessible(true);
	Singleton5 s2 = c.newInstance();
	System.out.println(s2);*/
	
	//ͨ�������л��ƽⵥ��
	FileOutputStream fos = new FileOutputStream("./singleton.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(s1);
	oos.close();
	//�����л�
	FileInputStream fis = new FileInputStream("./singleton.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);
	Singleton5 s3 = (Singleton5) ois.readObject();
	System.out.println(s3);
    }
    
}
