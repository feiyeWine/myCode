package cn.Text01.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * �м��������ⲿ���Ȼ��ִ��
 * @author YR
 *
 */
public class TestProcess {
    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	//���������ַ���
	String command = sc.nextLine();
	//��ʽ�������ַ���
	command = /*"cmd /c " +*/ command;
	Process child = Runtime.getRuntime().exec(command);
	System.out.println(command);
	BufferedReader br = new BufferedReader(new InputStreamReader(child.getInputStream()));
	String s ;
	while(true){
	    s = br.readLine();
	    if(null==s){
		break;
	    }
	    System.out.println(s);
	}
	br.close();
    }
}
