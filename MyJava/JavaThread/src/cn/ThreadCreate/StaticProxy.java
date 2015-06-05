package cn.ThreadCreate;
/**
 * ��̬�������ģʽ
 * 1����ʵ��ɫ
 * 2�������ɫ��������ʵ��ɫ������
 * 3������ʵ����ͬ�Ľӿ�
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
//�ӿ�
interface Marry
{
	void marry();
}
//��ʵ��ɫ
class  You implements Marry
{

	@Override
	public void marry()
	{
		System.out.println("You and �϶���");
	}	
}
//�����ɫ
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
		System.out.println("�����·�");
	}
	private void after()
	{
		System.out.println("���·�");
	}
	@Override
	public void marry()
	{
		before();
		you.marry();
		after();
	}
}


