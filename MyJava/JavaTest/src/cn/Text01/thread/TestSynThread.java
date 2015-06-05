package cn.Text01.thread;

import java.util.LinkedList;

/**
 * ��������Ӧ�õĶ��߳�Ӧ�ó�����һ���߳̽������У����������߳���ȡ����
 * @author YR
 *
 */
public class TestSynThread {
    public static void main(String[] args) {
	WorkQueue workQueue = new WorkQueue();
	new WorkThead1("�߳�0", workQueue).start();
	new WorkThread2("�߳�1", workQueue, 1).start();
	new WorkThread2("�߳�2", workQueue, 2).start();
    }
}
class WorkQueue{
    LinkedList<Object> queue = new LinkedList<>();
    public synchronized void addWork(Object o){
	queue.addLast(o); //��ӣ���β
	notify();//���������߳�����
    }
    public synchronized Object getWork() throws InterruptedException{
	while(queue.isEmpty()){
	    wait(); //����Ϊ��ʱ����ǰ�̴߳��ڵȴ�״̬
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
		    System.out.println(this.getName()+"ȡ��ֵ�ǣ�"+d);
		}
		sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}


