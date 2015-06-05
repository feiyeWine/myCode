package cn.ThreadState;

public class ThreadState implements Runnable
{

	@Override
	public void run()
	{
		for(int i = 0 ;i<100;i++)
		System.out.println("前进了"+i);
	}
	public static void main(String[] args) throws InterruptedException
	{
		ThreadState s =new ThreadState();
		Thread t = new Thread(s);
		t.start();
		for(int i = 0;i<100;i++)
		{
			//t.join(2000);//合并线程
			if(50==i)
			{
				Thread.yield();//暂停本线程
			}
			System.out.println("main--->"+i);
		}
	}
}
