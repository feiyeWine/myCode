package com.myJava;

import java.util.Scanner;

/**
 * ���Ը�ʽ�����
 * @author YR
 *
 */
public class TestPrintfAndScanner {
    public static void main(String[] args) {
	
	//���Ը�ʽ�����
	//System.out.printf("%1$4.2s %2$4d %3$4.2f",'a',2,223.7897);
	
	//����scanner
	getScanner();
    }
    public static void getScanner(){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNext()){
	    if(scanner.hasNextInt()){
		System.out.println(scanner.nextInt());
	    }
	    else{
		System.out.println("����int");
		//ɨ����ָ����һ��Ԫ��
		scanner.next();
	    }
	}
	scanner.close();
    }
}
