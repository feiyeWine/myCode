package cn.stringBulider;
/**
 * String ���ɱ��ַ�����
 * ���Կɱ��ַ����У�StringBuilder(�̲߳���ȫ��Ч�ʸ�)��String Buffer(�̰߳�ȫ��Ч�ʵ�)
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args){
		StringBuilder sb=new StringBuilder();//�ַ���ʼ����Ϊ16
		StringBuilder sb1=new StringBuilder(32);
		StringBuilder sb2=new StringBuilder("abcd");//�ַ����鳤�ȳ�ʼΪ32��value[]={'a','b','c','d',\u0000,����}
		sb2.append("efg");
		sb2.append(true).append(321).append("���");
		System.out.println(sb2);
	}
	
}
