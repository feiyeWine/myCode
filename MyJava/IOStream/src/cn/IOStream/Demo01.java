package cn.IOStream;

import java.io.File;

public class Demo01
{
	public static void main(String[] args)
	{
		
		File file = new File("E:/MyJava/IOStream/test");
		System.out.println(file.getAbsoluteFile());
	if(file.isFile())
	{
		System.out.println("�����ɹ�");
	}
	else 
	{
		System.out.println("����ʧ��");
	}
			System.out.println(file.length());
			
	}
}
