package cn.test04.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ִ��cmd����
 * @author YR
 *
 */
public class TestCmd {
    public static void main(String[] args) {
	try {
	    //ִ��ping www.baidu.com����
	    Process pr = Runtime.getRuntime().exec("ping www.163.com");
	    BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	    while(true){
		String s = br.readLine();
		if(null==s){
		    break;
		}
		System.out.println(s);
	    }
	    br.close();
	    //�ȴ�process�����ʾ�Ľ�����ֹ
	    try {
		pr.waitFor();
		if(0==pr.exitValue()){
			System.out.println("���гɹ�");
		    }
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	   
	} catch (IOException e) {
	    System.out.println("���д���");
	    e.printStackTrace();
	}
	
    }
}
