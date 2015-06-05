package cn.ThreadPro;
/**
 * 一个场景，共同的资源
 * @author YR
 *
 */
public class Movie {
    private String pic;
    //标识
    private boolean flag = true;
    public synchronized  void  play(String pic){
	if(!flag){
	    try {
		this.wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	//开始生产
	try {
	    Thread.sleep(300);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	this.pic = pic;
	//通知消费
	this.notify();System.out.println("生产了："+pic);
	//停止生产
	flag = false;
    }
    public synchronized void watch(){
	if(flag){
	    try {
		this.wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	//开始消费
	try {
	    Thread.sleep(200);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.out.println("消费了："+pic);
	//消费完毕，通知生产
	this.notify();
	flag = true;
    }
}

