package cn.Reference;

import java.lang.ref.WeakReference;

/**
 * ���ã�ǿ����������
 * ǿ����
 * @author YR
 *
 */

public class RefDemo01
{
	public static void main(String[] args)
	{
		//�ַ���������
		String str = new String("it is very good");
		//������ �������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc ����ǰ��"+wr.get());
		//�Ͽ�����
		str = null;
		//֪ͨ����,������
		System.gc();
		System.runFinalization();
		System.out.println("gc ���к�"+wr.get());			
	}
	public static void test()
	{
		//�ַ��������ء��������ܻ��գ�
		String str = "it is very good";
		//������ �������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc ����ǰ��"+wr.get());
		//�Ͽ�����
		str = null;
		//֪ͨ����
		System.gc();
		System.runFinalization();
		System.out.println("gc ���к�"+wr.get());
	}
}
