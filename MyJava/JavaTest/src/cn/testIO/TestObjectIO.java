package cn.testIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TestObjectIO {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	Student2 s1 = new Student2(1001,"Mr wang",20);
	Student2 s2 = new Student2(1002, "Mrs li", 23);
	File f = new File("obj.read");
	f.createNewFile();
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
	oos.writeObject(s1);
	oos.writeObject(s2);
	oos.writeObject(new Date());
	oos.close();
	
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	 s1 = (Student2) ois.readObject();
	 s2 = (Student2) ois.readObject();
	System.out.println("id="+s1.id);
	System.out.println("name="+s1.name);
	System.out.println("age="+s1.age);
	System.out.println("id="+s2.id);
	System.out.println("name="+s2.name);
	System.out.println("age="+s2.age);
	System.out.println("date="+(Date)ois.readObject());
	ois.close();
    }
    
}
