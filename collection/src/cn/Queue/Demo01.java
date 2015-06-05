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
			final int num = i; //�����ڲ���ֻ�ܷ���final ����
			que.offer(new Request(){
				
				@Override
				public void dispost()
				{
					System.out.println("���"+"��"+num+"���˴��Ϊ��"+(Math.random()*10000));
					
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
	//���ҵ��
		void dispost();
	}