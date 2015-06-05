package cn.Text01.thread;

import java.util.LinkedList;

/**
 * 建立队列应用的多线程应用程序，由一个线程建立队列，另外两个线程提取数据
 * @author YR
 *
 */
public class TestSynThread {
    public static void main(String[] args) {
	WorkQueue workQueue = new WorkQueue();
	new WorkThead1("线程0", workQueue).start();
	new WorkThread2("线程1", workQueue, 1).start();
	new WorkThread2("线程2", workQueue, 2).start();
    }
}
class WorkQueue{
    LinkedList<Object> queue = new LinkedList<>();
    public synchronized void addWork(Object o){
	queue.addLast(o); //入队，队尾
	notify();//唤醒其他线程运行
    }
    public synchronized Object getWork() throws InterruptedException{
	while(queue.isEmpty()){
	    wait(); //队列为空时，当前线程处于等待状态
	}
	return queue.removeFirst();
    }
}

class WorkThead1 extends Thread{
    WorkQueue workQueue;
    public WorkThead1(String name,WorkQueue workQueue){
	super(name);
	this.workQueue = workQueue;
    }
    public void run(){
	while(true){
	    workQueue.addWork(new Double(Math.random()));
	    try {
		sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}

class WorkThread2 extends Thread{
    WorkQueue workQueue;
    int type;
    WorkThread2(String name, WorkQueue workQueue, int type){
	super(name);
	this.workQueue = workQueue;
	this.type = type;
    }
    public void run(){
	while(true){
	    try {
		double d = ((Double)workQueue.getWork()).doubleValue();
		if((type ==1&&d<0.5)||(type ==2&&d>0.5)){
		    System.out.println(this.getName()+"取得值是："+d);
		}
		sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}


