package cn.ThreadState;

import cn.ThreadCreate.Web12306;

public class ThreadSleep
{
	public static void main(String[] args) throws InterruptedException
	{
		Web02 web = new Web02();
		Thread t1 = new Thread(web,"线程一");
		Thread t2 = new Thread(web,"线程二");
		Thread t3 = new Thread(web,"线程三");
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
					Thread.sleep(500);//数据不准确，并发
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
			}
		}
	}
}
