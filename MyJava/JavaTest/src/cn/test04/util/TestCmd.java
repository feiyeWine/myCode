package cn.test04.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 执行cmd命令
 * @author YR
 *
 */
public class TestCmd {
    public static void main(String[] args) {
	try {
	    //执行ping www.baidu.com命令
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
	    //等待process对象表示的进程终止
	    try {
		pr.waitFor();
		if(0==pr.exitValue()){
			System.out.println("运行成功");
		    }
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	   
	} catch (IOException e) {
	    System.out.println("运行错误");
	    e.printStackTrace();
	}
	
    }
}
