package cn.ThreadState;

public class ThreadState implements Runnable
{

	@Override
	public void run()
	{
		for(int i = 0 ;i<100;i++)
		System.out.println("ǰ����"+i);
	}
	public static void main(String[] args) throws InterruptedException
	{
		ThreadState s =new ThreadState();
		Thread t = new Thread(s);
		t.start();
		for(int i = 0;i<100;i++)
		{
			//t.join(2000);//�ϲ��߳�
			if(50==i)
			{
				Thread.yield();//��ͣ���߳�
			}
			System.out.println("main--->"+i);
		}
	}
}
