package cn.IOStream;

import java.io.File;
import java.io.IOException;


/**
 * 文件夹的copy
 * @author YR
 *
 */
public class CopyDir
{
	public static void main(String[] args)
	{
		String dirPath = "E:/MyJava/IOStream/src/cn/IOStream/FileTest";
		File dir = new File(dirPath);
		String dirCopyPath = "E:/MyJava/IOStream/src/cn/IOStream/CopyFileTest";
		File dirCopy = new File(dirCopyPath);
		
		DirCopyDetail(dir,dirCopy);	
	}
	public static void DirCopyDetail(File dir,File dirCopy)
	{
		if(dir.isDirectory())
		{
			dirCopy = new File(dirCopy,dir.getName());
		}
		if(dir.isFile())
		{
			try
			{
				CopyFile.CopyFile(dir, dirCopy);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if(dir.isDirectory())
		{
			//确保文件夹存在
			dirCopy.mkdir();
			
			//获取下一级文件或目录
			for(File src:dir.listFiles())
			{
				DirCopyDetail(src, new File(dirCopy,src.getName()));
				
			}
			
		}
	}
}
