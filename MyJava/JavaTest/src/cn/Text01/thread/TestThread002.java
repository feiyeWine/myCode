package cn.Text01.thread;

import java.applet.Applet;
import java.awt.TextArea;

/**
 * ʵ���߳�֮���ͬ������
 * �ؼ��֣�synchonized
 * @author YR
 *
 */

public class TestThread002 extends Applet implements Runnable{
	int money = 1000;
	TextArea text1,text2;
	Thread ���,����;
	public void init(){
		��� = new Thread(this);
		���� = new Thread(this);
		text1 = new TextArea(16,10);
		text2 = new TextArea(16,10);
		add(text1);
		add(text2);
	}
	public void start(){
		����.start();
		���.start();
	}
	public synchronized void withdraw(int number){
		if(Thread.currentThread()==���){
			for(int i = 1;i<=3;i++){
				money = money+number;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
				
		else if(Thread.currentThread()==����){
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
		if(Thread.currentThread()==���||Thread.currentThread()==����){
			for(int i = 1;i<= 3;i++)
				withdraw(100);
		}
		
	}
	

}
