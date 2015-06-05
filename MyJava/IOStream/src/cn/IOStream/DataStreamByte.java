package cn.IOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * д���ֽ����顢�����ֽ�����
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
		
		//ѡ����
		DataInputStream read= new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)));
		//��������ȡ˳����д��һ��
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
		String str = "��������";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//ѡ����
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
