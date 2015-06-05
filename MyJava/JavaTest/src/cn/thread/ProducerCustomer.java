package cn.thread;
/**
 * �����ߺ�������ģʽ
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
*  ͬ����
*/
class ShareData{
    private char c;
    private boolean flag = false;
    
    public synchronized void produceData(char c){
	
	if(flag){
	    try {
		wait(); //��δ���ѣ��ȴ�
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	this.c = c;
	flag = true;
	//֪ͨ����
	notify();
    }
   
    public synchronized char customeData(){
	if(!flag){
	    try {
		wait();	//�����ߵȴ�
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	flag = false;
	notify(); //֪ͨ����������
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
	    System.out.println("�����������ˣ�"+ch);
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
	    System.out.println("�����������ˣ�"+c);
	}while(c!='Z');
    }
}
