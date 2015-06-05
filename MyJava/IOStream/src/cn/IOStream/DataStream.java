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
 * �������ͣ�����+String��������
 * 1�������� DataInputStream
 * 2������� DataOutputStream
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
		//ѡ����
		DataInputStream read= new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)));
		//��������ȡ˳����д��һ��
		double num1 = read.readDouble();
		long num2 = read.readLong();
		String num3 = read.readUTF();
		System.out.println(num2);
		
	}
	public static void Write(String destPath) throws IOException
	{
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		
		File dest = new File(destPath);
		//ѡ����
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
