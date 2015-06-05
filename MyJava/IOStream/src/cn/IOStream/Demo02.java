package cn.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��Ķ�ȡ
 * 	1��������ϵ��File����
	2��ѡ���� �ļ���������InputStream FileInputStream
	3������ �� byte[] car = new byte[1024];+read+��ȡ��С
	4���ͷ���Դ���ر�
 * @author YR
 *
 */
public class Demo02
{
	public static void main(String[] args)
	{
		//1��������ϵ��File����
		String path = ("E:/MyJava/IOStream/src/cn/IOStream/test");
		File file = new File(path);
		//2��ѡ����
		InputStream is = null;
		try
		{
			is = new FileInputStream(file);
			//3.�������϶�ȡ��������
			byte[] car = new byte[11];
			int len = 0; //����ʵ�ʶ�ȡ��С
			//ѭ����ȡ
			try
			{
				while(-1!=(len = is.read(car)))
				{
					String info = new String(car,0,len);
					System.out.println(info);
				}
			} catch (IOException e)
			{
				System.out.println("��ȡʧ��");
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e)
		{
			System.out.println("�ļ�������");
			e.printStackTrace();
		}finally
		{

				try
				{
					if(null != is)
					is.close();
				} catch (IOException e)
				{
					System.out.println("�ر�ʧ��");
					e.printStackTrace();
				}
		}
		
	}
}
