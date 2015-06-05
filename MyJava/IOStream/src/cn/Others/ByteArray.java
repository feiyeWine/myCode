package cn.Others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ����� �ڵ���
 * ����ĳ������ޣ����ݵ������Ǻܴ�
 * @author YR
 *
 */

public class ByteArray
{
	public static void main(String[] args) throws IOException
	{
		/**
		 * ������ �������ļ�����������һ��
		 * ��ȡ�ֽ�����
		 * 
		 */
		read(write());
	}
	public static byte[]  write() throws IOException
	{
		//Ŀ�ĵ�
		byte[] dest;
		//ѡ���� ��ͬ��
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//���� д��
		String msg = "�������ļ�����������һ��";
		byte[] info = msg.getBytes();
		bos.write(info,0,info.length);
		//��ȡ����
		dest = bos.toByteArray();
		//�ͷ���Դ
		bos.close();
		return dest;
		
	}
	public static void read(byte[] src) throws IOException
	{
		//����Դ
		
		//ѡ����
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src)
				);
		//����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flush)))
		{
			System.out.println(new String(flush,0,len));
		}
		//�ͷ���Դ
		is.close();
	}
}
