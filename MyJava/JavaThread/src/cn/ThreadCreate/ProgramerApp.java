package cn.ThreadCreate;

public class ProgramerApp
{
	public static void main(String[] args)
	{
		Programer pro = new Programer();
		Thread proxy = new Thread(pro);
		proxy.start();
		for(int i = 0;i<10;i++)
		{
			System.out.println("Ò»±ßÁÄQQ");
		}
	}
}
