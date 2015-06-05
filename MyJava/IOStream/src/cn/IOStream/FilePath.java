package cn.IOStream;

import java.io.File;

/**
 * 常量分割符
 * File.pathSeparator
 * File.separator
 * @author YR
 *
 */

public class FilePath
{
	public static void main(String[] args)
	{
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		System.out.println(File.pathSeparatorChar);
		//分隔符分类
		System.out.println("E:\\Io\\test");
		System.out.println("E:"+File.separator+"Io"+File.separator+"test");
		System.out.println("E:/Io/test");
	}
}
