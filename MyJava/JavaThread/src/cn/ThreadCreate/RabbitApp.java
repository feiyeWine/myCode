package cn.ThreadCreate;

public class RabbitApp
{
	public static void main(String[] args)
	{
		//调用子类对象
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();
		//调用start方法
		rab.start();
		tor.start();
		for(int i = 0;i<20;i++)
		{
			System.out.println("main——>"+i);
		}
		
	}
}
