package cn.thread;

import java.io.IOException;
import java.util.Date;

/**
 * 创建线程，每隔一秒显示当前时间
 * @author YR
 *
 */
public class TimerPrint implements Runnable{
    
    boolean stop = false;
    
    
    
    
    @Override
    public void run() {
	
	while(!stop){
	    System.out.println("当前时间："+new Date(System.currentTimeMillis()));
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	System.out.println("当前线程为：\n id:"+Thread.currentThread().getId()+"\n name:"+Thread.currentThread().getName()
		+"\n优先级："+Thread.currentThread().getPriority()
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
	System.out.println("线程终止"+Thread.currentThread());
    }
}
