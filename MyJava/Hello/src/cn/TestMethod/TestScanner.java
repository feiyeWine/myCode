package cn.TestMethod;
import java.util.Scanner;
/**
 * ����Scanner��ʹ�ã���δӼ��̽�������
 * @author Administrator
 *
 */
public class TestScanner {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println("�ղż������룺"+str);
		System.out.println("������һ��������");
		int a=s.nextInt();
		System.out.println("\n��������һ��������");
		int b=s.nextInt();
		System.out.println("����ǣ�"+a+b);
		
	}

}
