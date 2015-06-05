package TestException;

import java.util.Scanner;

public class TestException1 {
	public static void main(String[] args) {
	//int a=1/0;	
	Computer c=new Computer();
	if(c!=null){
		c.start();//对象是空的，调用了对象的方法或属性
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
		System.out.println("计算机启动");
	}
}