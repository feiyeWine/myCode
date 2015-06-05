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
    //去除字符串空格
    public static void test(){
	String str = "  hello , world   !  ";
	System.out.println("去除头尾空格："+str.trim());
	System.out.println("去除所有空格："+str.replace(" ", ""));
    }
    //截取字符串
    public static void test2(){
	String str ="你好 It is nice day!!";
	System.out.println("截取字符串为："+str.substring(0,5));
	System.out.println("截取的字符串为："+str.substring(5));
    }
    //判断字符串是否符合数值格式：正则
    public static void test3(){
	String str = "nihao 13432";
	Pattern p = Pattern.compile("\\d*");
	Matcher m = p.matcher(str);
	System.out.println(m.matches());
    }
    //字母循环比较
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
    //字符串切割查找
    public static void test5(){
	String str = "javase,javaee,javame";
	String[] s=str.split(",");
	for(String i:s){
	    System.out.println(i);
	}
    }
}
