package cn.Text01.thread;

public class TestThread01 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		t.setName("MyThread");
		System.out.println("Current Thread:"+t);
		for(int i = 0;i<6;i++){
			System.out.println("Sleep Time:"+i);
			try {
				Thread.sleep(1000);
				//�õ�ǰ���߳̽���˯��״̬1000����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
