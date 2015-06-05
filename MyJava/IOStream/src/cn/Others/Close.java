package cn.Others;

import java.io.Closeable;
import java.io.IOException;

public class Close 
{
	public static void close(Closeable ...io)
	{
		for(Closeable temp:io)
		{
			if(null!= io)
			{
				try
				{
					temp.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public static<T extends Closeable> void close2(T ...io)
	{
		for(Closeable temp:io)
		{
			if(null!= io)
			{
				try
				{
					temp.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
