package cn.enumeration;

import java.util.StringTokenizer;

/**
 * enumeration����
 * StringTokenizer(String str, String delim) 
          Ϊָ���ַ�������һ�� string tokenizer��
          �ַ����ָ�
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
