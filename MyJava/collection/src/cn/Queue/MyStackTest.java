package cn.Queue;

public class MyStackTest
{
	public static void main(String[] args)
	{
		MyStack<String> t = new MyStack<>(3);
		t.push("www.baidu.com");
		t.push("www.sina.com");
		t.push("www.googel.com");
		System.out.println(t.cap());
		while(t.cap()!=0)
		{
			System.out.println(t.pop());
		}
		
	}
	
}
