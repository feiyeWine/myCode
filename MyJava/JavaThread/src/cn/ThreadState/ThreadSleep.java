package cn.ThreadState;

import cn.ThreadCreate.Web12306;

public class ThreadSleep
{
	public static void main(String[] args) throws InterruptedException
	{
		Web02 web = new Web02();
		Thread t1 = new Thread(web,"�߳�һ");
		Thread t2 = new Thread(web,"�̶߳�");
		Thread t3 = new Thread(web,"�߳���");
		t1.start();
		t2.start();
		t3.start();
	}
}
class Web02 implements Runnable
{
	private int num = 100;
	@Override
	public void run()
	{
		while(true)
		{
			if(num<0)
			{
				break;
			}
			else
			{
				try
				{
					Thread.sleep(500);//���ݲ�׼ȷ������
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"������"+num--);
			}
		}
	}
}
