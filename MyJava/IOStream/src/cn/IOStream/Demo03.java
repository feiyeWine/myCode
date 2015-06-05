package cn.IOStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * д���ļ�
1��������ϵ��File���� Ŀ�ĵ�
2��ѡ���� �ļ��������OutStream FileOutputStream
3������ �� write()+flush;
4���ͷ���Դ���ر�

 * @author YR
 *
 */
public class Demo03
{
	public static void main(String[] args)
	{
		//1��������ϵ��File����
		String path = ("E:/MyJava/IOStream/src/cn/IOStream/test");
		File file = new File(path);
		//2��ѡ����
		OutputStream os = null;
		//��׷����ʽд���ļ�
		try
		{
			//��׷����ʽд���ļ�
			os = new FileOutputStream(file,true);
			//3.����
			String str = "\n����һ����԰ʫ����";
			byte[] data = str.getBytes();
			try
			{
				os.write(data,0,data.length);
				os.flush();//ǿ��ˢ�³�ȥ
			} catch (IOException e)
			{
				System.out.println("д��ʧ��");
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
				if(null!=os)
				{
					os.close();
				}
			} catch (Exception e)
			{
				System.out.println("�ر�ʧ��");
				e.printStackTrace();
			}
		}
				
	}
}
