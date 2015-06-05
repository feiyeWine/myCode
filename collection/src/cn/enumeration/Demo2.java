package cn.enumeration;

import java.util.StringTokenizer;

/**
 * enumeration子类
 * StringTokenizer(String str, String delim) 
          为指定字符串构造一个 string tokenizer。
          字符串分割
 * @author YR
 *
 */
public class Demo2
{
	public static void main(String[] args)
	{
		String str = "abcd;efgh;igkl;mu";
		StringTokenizer token = new StringTokenizer(str,";");
		while(token.hasMoreElements())
		{
			System.out.println(token.nextToken());
		}
	}
}
