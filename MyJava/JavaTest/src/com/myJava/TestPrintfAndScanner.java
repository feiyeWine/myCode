package com.myJava;

import java.util.Scanner;

/**
 * 测试格式化输出
 * @author YR
 *
 */
public class TestPrintfAndScanner {
    public static void main(String[] args) {
	
	//测试格式化输出
	//System.out.printf("%1$4.2s %2$4d %3$4.2f",'a',2,223.7897);
	
	//测试scanner
	getScanner();
    }
    public static void getScanner(){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()){
	    if(scanner.hasNextInt()){
		System.out.println(scanner.nextInt());
	    }
	    else{
		System.out.println("不是int");
		//扫描器指向下一个元素
		scanner.next();
	    }
	}
	scanner.close();
    }
}
