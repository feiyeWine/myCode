package cn.thread;
/**
 * 生产者和消费者模式
 * @author YR
 *
 */
public class ProducerCustomer {
    public static void main(String[] args) {
	ShareData data = new ShareData();
	new Customer(data).start();
	new Producer(data).start();
    }
}

/*
*  同步块
*/
class ShareData{
    private char c;
    private boolean flag = false;
    
    public synchronized void produceData(char c){
	
	if(flag){
	    try {
		wait(); //还未消费，等待
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	this.c = c;
	flag = true;
	//通知消费
	notify();
    }
   
    public synchronized char customeData(){
	if(!flag){
	    try {
		wait();	//消费者等待
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	flag = false;
	notify(); //通知生产者生产
	return this.c;
    }
}

class Producer extends Thread{
    private ShareData data;
    Producer(ShareData data){
	this.data = data;
    }
    @Override
    public void run() {
	try {
	    Thread.sleep((int)Math.random()*500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	for(char ch='A';ch<'Z';ch++){
	    data.produceData(ch);
	    System.out.println("生产者生产了："+ch);
	}
    }
}
class Customer extends Thread{
    private ShareData data;
    
    Customer(ShareData data){
	this.data = data;
    }
    @Override
    public void run() {
	char c;
	try {
	    Thread.sleep((int)Math.random()*500);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	do{
	    c = data.customeData();
	    System.out.println("消费者消费了："+c);
	}while(c!='Z');
    }
}
