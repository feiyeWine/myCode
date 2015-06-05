package cn.ThreadCreate;
/**
 * 推荐使用Runnable 创建线程
 * 1）、避免单继承的局限性
 * 2）、便于共享资源
 * 使用Runnable 创建线程
 * 1、类实现Runnable 接口+重写run()——>真实角色
 * 2、启动多线程  使用静态代理
 * 1）、创建真实角色
 * 2）、创建代理角色+真实角色的引用
 * 3）、调用.start()启动线程
 * @author YR
 *
 */
public class Programer implements Runnable
{

	@Override
	public void run()
	{
		for(int i = 0;i<10;i++)
		System.out.println("一边敲代码。。。");
	}
	
}
