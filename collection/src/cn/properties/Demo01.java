package cn.properties;

import java.util.Properties;

/**
 * properties ��Դ�����ļ��Ķ�д
 * @author YR
 *
 */
public class Demo01
{
	public static void main(String[] args)
	{
		Properties pro = new Properties();
		pro.setProperty("url01", "hello world");
		pro.setProperty("url02", "hello zhang");
		pro.setProperty("url03", "hello wang");
		
		String url = pro.getProperty("url02");
		System.out.println(url);
	}
}
