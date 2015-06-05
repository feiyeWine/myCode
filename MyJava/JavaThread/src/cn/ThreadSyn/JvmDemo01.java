package cn.ThreadSyn;
/**
 * �������ģʽ��ȷ��һ����ֻ��һ������
 * @author YR
 *
 */
public class JvmDemo01 {
    public static void main(String[] args) {
	/*Jvm j1 = Jvm.getIntance(200);
	Jvm j2 = Jvm.getIntance(500);*/
	JvmThread t1 = new JvmThread();
	JvmThread t2 = new JvmThread();
	t1.start();
	t2.start();
    }
}
class JvmThread extends  Thread{
   @Override
   public void run() {
    System.out.println(Thread.currentThread()+"��������"+Jvm.getIntance2(0));
   }
}

class Jvm{
    private long time ;
    private static Jvm intance = null;
    public  static Jvm getIntance2 (long time ){
	synchronized(Jvm.class){
   	if(null==intance){
   	    intance = new Jvm();
   	}
   	return intance;
       }
    }
    
    public  static synchronized Jvm getIntance1 (long time ){
	
	if(null==intance){
	    intance = new Jvm();
	}
	return intance;
    }
    
    public  static Jvm getIntance (long time ){
	
	if(null==intance){
	    intance = new Jvm();
	}
	return intance;
    }
    public Jvm() {
	
    }
    public Jvm(long time){
	this.time = time;
    }
}