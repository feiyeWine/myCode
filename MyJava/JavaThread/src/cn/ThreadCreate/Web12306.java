package cn.ThreadCreate;
/**
 * 共享资源
 * @author YR
 *
 */
public class Web12306 implements Runnable
{
	private int num = 50;
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
				System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
			}
		}
	}
	public static void main(String[] args)
	{
		Web12306 web = new Web12306();
		Thread t1 = new Thread(web,"线程一");
		Thread t2 = new Thread(web,"线程二");
		Thread t3 = new Thread(web,"线程三");
		t1.start();
		t2.start();
		t3.start();
	}
}
