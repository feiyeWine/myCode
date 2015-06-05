package cn.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 资源配置文件store 存储
 * @author YR
 *
 */
public class Demo02
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Properties pro = new Properties();
		pro.setProperty("url01", "hello world");
		pro.setProperty("url02", "hello zhang");
		pro.setProperty("url03", "hello wang");
		
		pro.store(new FileOutputStream(new File("src/cn/properties/db.properties")), "db配置");
	}
	
}
