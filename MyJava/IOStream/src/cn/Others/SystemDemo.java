package cn.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;



/**
 * 三个常量：
 * System.in()
 * System.out()
 * System.err()
 * 重定向：
 * System.setIn()
 * System.setOut()
 * System.setErr()
 * @author YR
 *
 */
public class SystemDemo
{
	public static void main(String[] args) throws IOException
	{
		//test1();
		//test2();
		InputStream is =System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("请输入：");
		String msg = br.readLine();
		System.out.println(msg);
	}
	public static void test1() throws FileNotFoundException
	{

		System.out.println("test");
		System.err.println("test");
		InputStream is = System.in;
		is = new BufferedInputStream(
				new FileInputStream("E:/MyJava/IOStream/src/cn/Others/printTest"));
		Scanner sc =new Scanner(is);
		System.out.println(sc.nextLine());
	}
	public static void test2() throws FileNotFoundException
	{
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream("E:/MyJava/IOStream/src/cn/Others/printTest")),true));
		System.out.println("hello c");//控制台——>文件
		System.out.println("test");
		//回控制台
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("hello cc");
	}
}
