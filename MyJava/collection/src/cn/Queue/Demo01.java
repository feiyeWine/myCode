package cn.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo01
{
	public static void main(String[] args)
	{
		Queue<Request> que = new ArrayDeque<>();
		for(int i = 0;i<10; i++)
		{
			final int num = i; //匿名内部类只能访问final 变量
			que.offer(new Request(){
				
				@Override
				public void dispost()
				{
					System.out.println("输出"+"第"+num+"个人存款为："+(Math.random()*10000));
					
				}
				
			});
		}
		dealWith(que);
	}	
	public static void dealWith(Queue<Request> que)
	{
		Request req = null;
		while(null!=(req=que.poll()))
		{
			req.dispost();
		}
	}
	
}
interface  Request
	{
	//存款业务
		void dispost();
	}