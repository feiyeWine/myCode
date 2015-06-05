package cn.Others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * ДђгЁСї
 * @author YR
 *
 */
public class PrintStreamDemo
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("test");
		PrintStream print = System.out;
		print.println("test");
		File src = new File("E:/MyJava/IOStream/src/cn/Others/printTest");
		PrintStream bos = new PrintStream(
				new BufferedOutputStream(new FileOutputStream(src)));
		bos.print("Hello квзг");
		bos.flush();
		bos.close();
		
	}
}
