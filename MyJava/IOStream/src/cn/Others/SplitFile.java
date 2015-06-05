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
	//�ļ�·��
	private String filePath;
	//����
	private int size;
	//ÿ���С
	private long blockSize; 
	//ÿ�������
	private List<String> blockPath;
	//�ļ���
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
	 *��ʼ������ ���������ȷ���ļ���
	 * @param args
	 */
	public void init()
	{
		File src = null;
		//��׳��
		if (null == filePath ||!((src = new File(filePath)).exists()))
		{
			return;	
		}
		if(src.isDirectory())
		{
			System.out.println("�ļ��в��ָܷ�");
			return ;
		}
		//���������ʵ�ʴ�С��ÿ��Ĵ�С
		this.length = src.length();
		fileName = src.getName();
		//����û��Ĵ�С
		if(this.blockSize>length)
		{
			this.blockSize = length;
		}
		//ȷ������
		size = (int)(Math.ceil(length*1.0/this.blockSize));
		//ÿ�������
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
		//ȷ���ļ���·��
		initPathName(destPath);
		long beginPos = 0;
		long actualBlockSize = blockSize;
		//����ÿ��Ĵ�С��λ�ã�����
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
	//�ļ��ķָ�
		public void spiltDetail(int index, long beginPos, long actualBlockSize) throws IOException
		{
			File src = new File(this.filePath);	//Դ�ļ�
			File dest = new File(this.blockPath.get(index));//Ŀ���ļ�
			RandomAccessFile raf =null;
			BufferedOutputStream bos=null;
			//ѡ����
			try
			{
				raf = new RandomAccessFile(src,"r");
				 bos= new BufferedOutputStream(new FileOutputStream(dest));
				raf.seek(beginPos);
				int len =0;
				byte[] flush = new byte[1024];
				while(-1!=(len = raf.read()))
				{
					if(actualBlockSize-len>0)//�鿴�Ƿ��㹻
					{
						bos.write(flush,0,len);//д��
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
