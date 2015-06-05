package cn.IOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 写入字节数组、读到字节数组
 * @author YR
 *
 */
public class DataStreamByte
{
	public static void main(String[] args)
	{
		String path = ("E:/MyJava/IOStream/src/cn/IOStream/dataTest.txt");
		try
		{
			byte[] data =Write();
			System.out.println(data.length);
			Read(Write());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void Read(byte[] src) throws IOException
	{
		
		//选择流
		DataInputStream read= new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)));
		//操作，读取顺序与写入一致
		double num1 = read.readDouble();
		long num2 = read.readLong();
		String num3 = read.readUTF();
		System.out.println(num1+"\r"+num2+num3);
		
	}
	public static byte[] Write() throws IOException
	{
		byte[] dest = null;
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//选择流
		DataOutputStream data = new DataOutputStream(
				new BufferedOutputStream(
						(bos)));
		data.writeDouble(point);
		data.writeLong(num);
		data.writeUTF(str);
		data.flush();
		dest = bos.toByteArray();
		data.close();
		
		return dest;
	}
}
