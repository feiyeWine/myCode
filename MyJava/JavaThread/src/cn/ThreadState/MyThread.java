package cn.ThreadState;
/**
 * 
 * @author YR
 *
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
	for(int i = 0;i<20;i++){
	    System.out.println("MyThread¡ª¡ª>"+i);
	}	
    }
    public static void main(String[] args) {
	MyThread it = new MyThread();
	Thread t1 = new Thread(it);
	System.out.println(Thread.currentThread().getName());
	System.out.println(t1.getName());
	System.out.println(t1.getPriority());
    }
}
