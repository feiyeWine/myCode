package cn.Convert;

import java.io.UnsupportedEncodingException;

public class Convert01
{
	public static void main(String[] args) throws UnsupportedEncodingException
	{
		//���룺byte����>char
		String str = "�й�"; //gbk
		//���룺char����>byte
		byte[] data = str.getBytes();
		//�ֽ�������
		System.out.println(new String(data,0,3));
	}
	public static void test01() throws UnsupportedEncodingException
	{
		//���룺byte����>char
		String str = "�й�"; //gbk
		//���룺char����>byte
		byte[] data = str.getBytes();
		//����������ַ���ͬһ
		System.out.println(new String(data));
		data = str.getBytes("utf-8"); //�趨�����ַ���
		//��ͬһ����������
		System.out.println(new String(data));
		//����
		byte[] data2 = "�й�".getBytes("utf-8");
		//����
		str = new String(data2,"utf-8");
		System.out.println(str);
		
	}
}
