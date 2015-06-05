package cn.stringBulider;
/**
 * String 不可变字符序列
 * 测试可变字符序列，StringBuilder(线程不安全，效率高)，String Buffer(线程安全，效率低)
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args){
		StringBuilder sb=new StringBuilder();//字符初始长度为16
		StringBuilder sb1=new StringBuilder(32);
		StringBuilder sb2=new StringBuilder("abcd");//字符数组长度初始为32，value[]={'a','b','c','d',\u0000,……}
		sb2.append("efg");
		sb2.append(true).append(321).append("随便");
		System.out.println(sb2);
	}
	
}
