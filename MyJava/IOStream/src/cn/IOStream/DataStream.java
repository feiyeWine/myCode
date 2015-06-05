package cn.IOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型（基本+String）处理流
 * 1、输入流 DataInputStream
 * 2、输出流 DataOutputStream
 * @author YR
 *
 */
public class DataStream
{
	public static void main(String[] args)
	{
		String path = ("E:/MyJava/IOStream/src/cn/IOStream/dataTest.txt");
		try
		{
			//Write(path);
			Read(path);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void Read(String srcPath) throws IOException
	{
		File src = new File(srcPath);
		//选择流
		DataInputStream read= new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)));
		//操作，读取顺序与写入一致
		double num1 = read.readDouble();
		long num2 = read.readLong();
		String num3 = read.readUTF();
		System.out.println(num2);
		
	}
	public static void Write(String destPath) throws IOException
	{
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		
		File dest = new File(destPath);
		//选择流
		DataOutputStream data = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)));
		data.writeDouble(point);
		data.writeLong(num);
		data.writeUTF(str);
		data.flush();
		data.close();
	}
}
