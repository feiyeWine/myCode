package cn.ThreadCreate;

public class RabbitApp
{
	public static void main(String[] args)
	{
		//�����������
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();
		//����start����
		rab.start();
		tor.start();
		for(int i = 0;i<20;i++)
		{
			System.out.println("main����>"+i);
		}
		
	}
}
