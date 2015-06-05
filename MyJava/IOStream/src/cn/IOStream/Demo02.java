package cn.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 * 	1、建立联系，File对象
	2、选择流 文件输入流，InputStream FileInputStream
	3、操作 ： byte[] car = new byte[1024];+read+读取大小
	4、释放资源，关闭
 * @author YR
 *
 */
public class Demo02
{
	public static void main(String[] args)
	{
		//1、建立联系，File对象
		String path = ("E:/MyJava/IOStream/src/cn/IOStream/test");
		File file = new File(path);
		//2、选择流
		InputStream is = null;
		try
		{
			is = new FileInputStream(file);
			//3.操作不断读取缓冲数组
			byte[] car = new byte[11];
			int len = 0; //接受实际读取大小
			//循环读取
			try
			{
				while(-1!=(len = is.read(car)))
				{
					String info = new String(car,0,len);
					System.out.println(info);
				}
			} catch (IOException e)
			{
				System.out.println("读取失败");
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e)
		{
			System.out.println("文件不存在");
			e.printStackTrace();
		}finally
		{

				try
				{
					if(null != is)
					is.close();
				} catch (IOException e)
				{
					System.out.println("关闭失败");
					e.printStackTrace();
				}
		}
		
	}
}
