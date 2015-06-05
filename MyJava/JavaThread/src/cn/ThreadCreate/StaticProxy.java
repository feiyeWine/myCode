package cn.ThreadCreate;
/**
 * 静态代理设计模式
 * 1、真实角色
 * 2、代理角色：持有真实角色的引用
 * 3、二者实现相同的接口
 * @author YR
 *
 */
public class StaticProxy
{
	public static void main(String[] args)
	{
		Marry you = new You();
		MarryCompany pro = new MarryCompany(you);
		pro.marry();	
	}
}
//接口
interface Marry
{
	void marry();
}
//真实角色
class  You implements Marry
{

	@Override
	public void marry()
	{
		System.out.println("You and 嫦娥结婚");
	}	
}
//代理角色
class MarryCompany implements Marry
{
	private Marry you;
	
	
	public MarryCompany()
	{
	}
	public MarryCompany(Marry you)
	{
		this.you = you;
	}
	private void before()
	{
		System.out.println("布置新房");
	}
	private void after()
	{
		System.out.println("闹新房");
	}
	@Override
	public void marry()
	{
		before();
		you.marry();
		after();
	}
}


