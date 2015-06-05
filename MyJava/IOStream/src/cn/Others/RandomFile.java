package cn.Others;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ·Ö¸îÎÄ¼þ
 * @author YR
 *
 */
public class RandomFile
{
	public static void main(String[] args) throws IOException
	{
		RandomAccessFile dom =new RandomAccessFile(new File("E:/MyJava/IOStream/src/cn/IOStream/test"),"r");
		byte[] flush = new byte[1024] ;
		int len = 0;
		dom.seek(12);
		while(-1!=(len = dom.read(flush)))
		{
			if(len>=20)
			System.out.println(new String(flush,0,20));
			else
			{
				System.out.println(new String (flush,0,len));
			}
		}
		dom.close();
	}
}
