package cn.ThreadSyn;
/**
 * 过多的同步方法容易造成死锁
 * @author YR
 *
 */
public class JvmDemo03 {
    public static void main(String[] args) {
	Object g= new Object();
	Object m = new Object();
	test1 t1 =new test1(g,m);
	test2 t2 = new test2(g,m);
	Thread s1  = new Thread(t1);
	Thread s2 = new Thread(t2);
	s1.start();
	s2.start();
    }
}
class test1 implements Runnable{
    Object good;
    Object money;
    
   public test1(Object good, Object money) {
	super();
	this.good = good;
	this.money = money;
    }

@Override
public void run() {
    while(true){
	test11();
    }
}
   public void test11() {
       synchronized(good){
	   try {
	    Thread.sleep(100);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	   synchronized(money){
	       try {
		Thread.sleep(200);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	   }
       }System.out.println("一手给钱");
   }   
}
class test2 implements Runnable{
    Object good;
    Object money;
    
   public test2(Object good, Object money) {
	super();
	this.good = good;
	this.money = money;
    }

@Override
public void run() {
    while(true){
	test22();
    }
}
   public void test22() {
       synchronized(money){
	   try {
	    Thread.sleep(100);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	   synchronized(good){
	       try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	   }
       }System.out.println("一手给货");
   }   
}
