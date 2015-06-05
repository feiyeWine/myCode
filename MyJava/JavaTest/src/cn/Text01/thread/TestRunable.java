package cn.Text01.thread;
/**
 * 1���̳��߳���
 * 2��ʵ���߳̽ӿ�
 * @author YR
 *
 */
public class TestRunable {
    public static void main(String[] args) {
	CountThead2 thread1 = new CountThead2(1, 150, "Thread_1");
	CountThead2 thread2 = new CountThead2(151, 300, "Thread_2");
	Thread th1 = new Thread(thread1);
	Thread th2 = new Thread(thread2);
	th1.start();
	th2.start();
    }
    
}
//�����߳�
class CountThead extends Thread{
    private int start;
    private int finish;
    private String name;
    
    public CountThead(int start, int finish, String name) {
	super();
	this.start = start;
	this.finish = finish;
	this.name = name;
    }
    public void run(){
	System.out.println("\r\n"+name+"�߳̿�ʼ�����ˡ�����");
	for(int i=start;i<finish;i++){
	    System.out.println(i+",");
	}
	System.out.println("\r\n"+name+"�߳̽�������");
    }
}
//�����߳�
class CountThead2 implements Runnable{
  private int start;
  private int finish;
  private String name;
  
  public CountThead2(int start, int finish, String name) {
	super();
	this.start = start;
	this.finish = finish;
	this.name = name;
  }
  @Override
  public void run(){
	System.out.println("\r\n"+name+"�߳̿�ʼ�����ˡ�����");
	for(int i=start;i<finish;i++){
	    System.out.println(i+",");
	}
	System.out.println("\r\n"+name+"�߳̽�������");
  }

}