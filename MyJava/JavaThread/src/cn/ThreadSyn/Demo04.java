package cn.ThreadSyn;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度
 * Timer()
 * schedule(TimerTask task, Date time) 
          安排在指定的时间执行指定的任务。 
 void schedule(TimerTask task, Date firstTime, long period) 
          安排指定的任务在指定的时间开始进行重复的固定延迟执行。 

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
