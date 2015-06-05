package cn.Others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class SplitFile
{
	//文件路径
	private String filePath;
	//块数
	private int size;
	//每块大小
	private long blockSize; 
	//每块的名称
	private List<String> blockPath;
	//文件名
	private String fileName;
	private long length;
	public SplitFile()
	{
		blockPath = new ArrayList();
	}
	public SplitFile(String filePath)
	{
		this(filePath,1024);
	}
	public SplitFile(String filePath, long blockSize)
	{
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		init();
	}
	/**
	 *初始化操作 计算块数、确定文件名
	 * @param args
	 */
	public void init()
	{
		File src = null;
		//健壮性
		if (null == filePath ||!((src = new File(filePath)).exists()))
		{
			return;	
		}
		if(src.isDirectory())
		{
			System.out.println("文件夹不能分割");
			return ;
		}
		//计算块数、实际大小、每块的大小
		this.length = src.length();
		fileName = src.getName();
		//修正没块的大小
		if(this.blockSize>length)
		{
			this.blockSize = length;
		}
		//确定块数
		size = (int)(Math.ceil(length*1.0/this.blockSize));
		//每块的名称
		}
	private void initPathName(String destPath)
	{
		for(int i = 0;i<this.size;i++)
		{
			this.blockPath.add(destPath+"/"+this.fileName+".part"+i);
		}
	}
	private void split(String destPath) throws IOException
	{
		//确定文件的路径
		initPathName(destPath);
		long beginPos = 0;
		long actualBlockSize = blockSize;
		//计算每块的大小，位置，索引
		for(int i = 0;i<size;i++)
		{
			if(i == size-1)
			{
				actualBlockSize =this.length- beginPos;
			}
				spiltDetail(i,beginPos,actualBlockSize);
				beginPos+=actualBlockSize;
		}	
	}
	//文件的分割
		public void spiltDetail(int index, long beginPos, long actualBlockSize) throws IOException
		{
			File src = new File(this.filePath);	//源文件
			File dest = new File(this.blockPath.get(index));//目标文件
			RandomAccessFile raf =null;
			BufferedOutputStream bos=null;
			//选择流
			try
			{
				raf = new RandomAccessFile(src,"r");
				 bos= new BufferedOutputStream(new FileOutputStream(dest));
				raf.seek(beginPos);
				int len =0;
				byte[] flush = new byte[1024];
				while(-1!=(len = raf.read()))
				{
					if(actualBlockSize-len>0)//查看是否足够
					{
						bos.write(flush,0,len);//写出
						actualBlockSize-=len;
					}else
					{
						bos.write(flush,0,(int)actualBlockSize);
						break;
					}
				}		
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				Close.close(bos,raf);
			}
		}
	
	public static void main(String[] args) throws IOException
	{
		SplitFile split = new SplitFile("E:/MyJava/IOStream/src/cn/IOStream/test",20);
		System.out.println(split.size);
		split.split("E:/MyJava/IOStream/src/cn/IOStream");
	}
}
