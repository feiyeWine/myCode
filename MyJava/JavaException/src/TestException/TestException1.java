package TestException;

import java.util.Scanner;

public class TestException1 {
	public static void main(String[] args) {
	//int a=1/0;	
	Computer c=new Computer();
	if(c!=null){
		c.start();//�����ǿյģ������˶���ķ���������
	}
//	Scanner s=new Scanner(System.in);
//	int a=s.nextInt();
//	System.out.println(a);
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
}
class Computer{
	void start(){
		System.out.println("���������");
	}
}