package cn.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 读取资源配置文件
 * @author YR
 *
 */
public class Demo03
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Properties pro = new Properties();
		pro.load(new FileReader("src/cn/properties/db.properties"));
		System.out.println(pro.getProperty("url01","erro"));
	}
		
	
}
