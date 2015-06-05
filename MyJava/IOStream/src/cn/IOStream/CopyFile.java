package cn.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ���copy
1��������ϵ��File���� Դͷ  Ŀ�ĵ�
2��ѡ����
	�ļ�������  InputStream  FileInputStream
	�ļ������  OutputStream FileOutputStream
3������������
	byte[] flush = new bute[1024];
	int len = 0;
	while(-1!=(len  = ������.read(flush))){
		�����.write(flush,0,len);
	}
	�����.flush()
4���ͷ���Դ:�ر�������
 * @author YR
 *
 */
public class CopyFile
{
	public static void main(String[] args) throws IOException
	{
		//1��������ϵԴ���ļ����ڣ�+Ŀ�ģ��ļ����Բ����ڣ�
		File src = new File("E:/MyJava/IOStream/src/cn/IOStream/test");
		File dest = new File("E:/MyJava/IOStream/src/cn/IOStream/testCopy");
		CopyFile(src,dest);
	}
	public static void CopyFile(File src,File dest) throws IOException
	{
		
		//2��ѡ����
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		//3�������ļ�  ѭ��+��ȡ+д��
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush)))
		{
			os.write(flush, 0, len);
		}
		os.flush();
		//�ر���
		os.close();
		is.close();
	}
}
