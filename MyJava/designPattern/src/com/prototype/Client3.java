package com.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * ����ǳ����
 * ���л��������л�
 * @author YR
 *
 */
public class Client3 {
    public static void main(String[] args) throws CloneNotSupportedException, Exception, IOException {
	Date date =  new Date(1232454343L);
	Sheep s1 = new Sheep("����",date );
	System.out.println(s1);
	System.out.println(s1.getName());
	System.out.println(s1.getBirthday());
	//Sheep s2 = (Sheep) s1.clone();
	
	//���л�
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);
	oos.writeObject(s1);
	byte[] b = baos.toByteArray();
	//�����л�
	ByteArrayInputStream bais = new ByteArrayInputStream(b);
	ObjectInputStream ois = new ObjectInputStream(bais);
	
	Sheep s2 = (Sheep) ois.readObject();
	
	date.setTime(183598435943465L);
	
	
	System.out.println(s1.getBirthday());
	System.out.println(s2);
	System.out.println(s2.getName());
	System.out.println(s2.getBirthday());
    }
}
