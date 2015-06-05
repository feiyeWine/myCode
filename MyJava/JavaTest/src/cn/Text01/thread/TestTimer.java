package cn.Text01.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ��������������������ɵ������ݼ�����
 * @author YR
 *
 */
public class TestTimer {
    public static void main(String[] args) {
	AddTimerTask add = new AddTimerTask();
	SubTimerTask sub = new SubTimerTask();
	Timer timer = new Timer();
	timer.schedule(add, 1000,1);
	timer.schedule(sub, 1000,1);
	while(true){
	    if(Math.abs(add.num - sub.num)==0){
		System.out.println("������������ֵΪ��"+add.num+"  �ݼ���ֵΪ��"+sub.num);
		timer.cancel();
		break;
	    }
	}
    }
}
class AddTimerTask extends TimerTask{
    int num = 1;
    @Override
    public void run() {
	num++;
    }
    
}
class SubTimerTask extends TimerTask{
    int num = 100;
    @Override
    public void run() {
	num--;
    }
    
}