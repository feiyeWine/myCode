package cn.thread;

import java.io.IOException;
import java.util.Date;

/**
 * �����̣߳�ÿ��һ����ʾ��ǰʱ��
 * @author YR
 *
 */
public class TimerPrint implements Runnable{
    
    boolean stop = false;
    
    
    
    
    @Override
    public void run() {
	
	while(!stop){
	    System.out.println("��ǰʱ�䣺"+new Date(System.currentTimeMillis()));
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	System.out.println("��ǰ�߳�Ϊ��\n id:"+Thread.currentThread().getId()+"\n name:"+Thread.currentThread().getName()
		+"\n���ȼ���"+Thread.currentThread().getPriority()
		);
    }
    public static void main(String[] args) {
	TimerPrint tp = new TimerPrint();
	Thread t = new Thread(tp);
	t.start();
	try {
	    System.in.read();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	tp.stop = true;
	System.out.println("�߳���ֹ"+Thread.currentThread());
    }
}
