package cn.TestMethod;
import java.util.Scanner;
/**
 * 测试Scanner的使用，如何从键盘接受输入
 * @author Administrator
 *
 */
public class TestScanner {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println("刚才键盘输入："+str);
		System.out.println("请输入一个加数：");
		int a=s.nextInt();
		System.out.println("\n请输入另一个加数：");
		int b=s.nextInt();
		System.out.println("结果是："+a+b);
		
	}

}
