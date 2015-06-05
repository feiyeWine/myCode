package cn.IOStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出文件
1、建立联系，File对象 目的地
2、选择流 文件输出流，OutStream FileOutputStream
3、操作 ： write()+flush;
4、释放资源，关闭

 * @author YR
 *
 */
public class Demo03
{
	public static void main(String[] args)
	{
		//1、建立联系，File对象
		String path = ("E:/MyJava/IOStream/src/cn/IOStream/test");
		File file = new File(path);
		//2、选择流
		OutputStream os = null;
		//以追加形式写出文件
		try
		{
			//已追加形式写出文件
			os = new FileOutputStream(file,true);
			//3.操作
			String str = "\n这是一首田园诗！！";
			byte[] data = str.getBytes();
			try
			{
				os.write(data,0,data.length);
				os.flush();//强制刷新出去
			} catch (IOException e)
			{
				System.out.println("写出失败");
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
				if(null!=os)
				{
					os.close();
				}
			} catch (Exception e)
			{
				System.out.println("关闭失败");
				e.printStackTrace();
			}
		}
				
	}
}
