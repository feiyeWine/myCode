package cn.Text01.thread;

import java.applet.Applet;
import java.awt.TextArea;

/**
 * 实现线程之间的同步控制
 * 关键字：synchonized
 * @author YR
 *
 */

public class TestThread002 extends Applet implements Runnable{
	int money = 1000;
	TextArea text1,text2;
	Thread 会计,出纳;
	public void init(){
		会计 = new Thread(this);
		出纳 = new Thread(this);
		text1 = new TextArea(16,10);
		text2 = new TextArea(16,10);
		add(text1);
		add(text2);
	}
	public void start(){
		出纳.start();
		会计.start();
	}
	public synchronized void withdraw(int number){
		if(Thread.currentThread()==会计){
			for(int i = 1;i<=3;i++){
				money = money+number;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
				
		else if(Thread.currentThread()==出纳){
			for(int i = 1;i<=2;i++){
				money = money - number/2;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	
	@Override
	public void run() {
		if(Thread.currentThread()==会计||Thread.currentThread()==出纳){
			for(int i = 1;i<= 3;i++)
				withdraw(100);
		}
		
	}
	

}
