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
		System.out.println("创建成功");
	}
	else 
	{
		System.out.println("创建失败");
	}
			System.out.println(file.length());
			
	}
}
