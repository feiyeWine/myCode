package cn.Convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流:字节转为字符
 * 编码：输出流：OutputStreamWriter
 * 解码：输入流：InputStreamReader
 * @author YR
 *
 */
public class Convert02
{
	public static void main(String[] args) throws IOException 
	{
		//制定解码字符集
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("E:/MyJava/IOStream/src/cn/IOStream/test"))/*"utf-8"*/));
		String info = null;
		while(null!=(info=br.readLine()))
		{
			System.out.println(info);
		}
		br.close();
	}
}
