package cn.ThreadSyn;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * �������
 * Timer()
 * schedule(TimerTask task, Date time) 
          ������ָ����ʱ��ִ��ָ�������� 
 void schedule(TimerTask task, Date firstTime, long period) 
          ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С� 

 */
public class Demo04 {
    public static void main(String[] args) {
	Timer t =new  Timer();
	t.schedule(new TimerTask(){
		    @Override
		    public void run() {
			System.out.println("this is so easy!");
		    }
		},new Date(System.currentTimeMillis()+1000));
    }
}
