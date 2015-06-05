package cn.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DaemonDemo extends Thread{

    @Override
    public void run() {
	for(int i =  0;i<10;i++){
	    System.out.println("Num: "+i+" Daemo is "+isDaemon());
	}
    }
    public static void main(String[] args) {
	System.out.println("input thread status:yes(Y) or no(N):");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try {
	    String str = br.readLine();
	    if(str.equals("yes")||str.equals("Y")){
		DaemonDemo t = new DaemonDemo();
		t.setDaemon(true); //设置为守护线程
		t.start();
	    }else{
		new DaemonDemo().start(); //用户线程
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	
    }
}
