package cn.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<E>
{
	private Deque<E> container = new ArrayDeque<>();
	private int elem;
	public MyStack(int elem)
	{
		super();
		this.elem = elem;
	}
	public MyStack()
	{
		elem = this.container.size();
	}
	//ѹջ
	public boolean push(E e)
	{
		if(container.size()+1>elem)
		{
			return false;
		}
		else return container.offerLast(e);
	}
	//��ջ
	public E pop()
	{
		return container.pollLast();
	}
	//��ȡ
	public E peek()
	{
		return container.peekLast();
	}
	// ����
	public int cap()
	{
		return this.container.size();
	}
}