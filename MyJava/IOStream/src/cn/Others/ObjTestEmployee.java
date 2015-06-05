package cn.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author YR
 *
 */
public class ObjTestEmployee
{
	public static void main(String[] args) throws ClassNotFoundException
	{
		String destPath = ("E:/MyJava/IOStream/src/cn/Others/ObjectTest");
		try
		{
			//Emp(destPath);
			read(destPath);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	//反序列化
	public static void read (String srcPath) throws FileNotFoundException, IOException, ClassNotFoundException{
		File src = new File(srcPath);
		ObjectInputStream dis = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)));
		Object bos = dis.readObject();
		if(bos instanceof Employee)
		{
			Employee emp = (Employee)bos;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		
		}
		dis.close();
	}
	//序列化
	public static void Emp(String destPath)  throws IOException
	
	{
		Employee employee = new Employee("zhang",20000);
		File dest = new File(destPath);
		ObjectOutputStream obj = new ObjectOutputStream(
				new BufferedOutputStream(
				new FileOutputStream(dest)));
		obj.writeObject(employee);
		obj.flush();
		obj.close();
	}
}
