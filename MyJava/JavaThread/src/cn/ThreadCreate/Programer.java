package cn.ThreadCreate;
/**
 * �Ƽ�ʹ��Runnable �����߳�
 * 1�������ⵥ�̳еľ�����
 * 2�������ڹ�����Դ
 * ʹ��Runnable �����߳�
 * 1����ʵ��Runnable �ӿ�+��дrun()����>��ʵ��ɫ
 * 2���������߳�  ʹ�þ�̬����
 * 1����������ʵ��ɫ
 * 2�������������ɫ+��ʵ��ɫ������
 * 3��������.start()�����߳�
 * @author YR
 *
 */
public class Programer implements Runnable
{

	@Override
	public void run()
	{
		for(int i = 0;i<10;i++)
		System.out.println("һ���ô��롣����");
	}
	
}
