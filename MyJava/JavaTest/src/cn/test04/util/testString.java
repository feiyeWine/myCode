package cn.test04.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testString {
    public static void main(String[] args) {
	//test();
	//test2();
	//test3();
	//test4();
	test5();
    }
    //ȥ���ַ����ո�
    public static void test(){
	String str = "  hello , world   !  ";
	System.out.println("ȥ��ͷβ�ո�"+str.trim());
	System.out.println("ȥ�����пո�"+str.replace(" ", ""));
    }
    //��ȡ�ַ���
    public static void test2(){
	String str ="��� It is nice day!!";
	System.out.println("��ȡ�ַ���Ϊ��"+str.substring(0,5));
	System.out.println("��ȡ���ַ���Ϊ��"+str.substring(5));
    }
    //�ж��ַ����Ƿ������ֵ��ʽ������
    public static void test3(){
	String str = "nihao 13432";
	Pattern p = Pattern.compile("\\d*");
	Matcher m = p.matcher(str);
	System.out.println(m.matches());
    }
    //��ĸѭ���Ƚ�
    public static void test4(){
	String str = "it is 123435";
	StringBuffer sb = new StringBuffer(str);
	for(int i = 0;i<sb.length();i++){
	    char c = sb.charAt(i);
	    if(c>'0'&&c<'9'){
		System.out.print(c);
	    }
	}
    }
    //�ַ����и����
    public static void test5(){
	String str = "javase,javaee,javame";
	String[] s=str.split(",");
	for(String i:s){
	    System.out.println(i);
	}
    }
}
