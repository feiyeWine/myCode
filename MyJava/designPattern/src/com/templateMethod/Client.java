package com.templateMethod;

public class Client {
    public static void main(String[] args) {
	//ͨ��ʹ���ڲ���
	Template t = new Template() {
	    
	    @Override
	    public void transact() {
		System.out.println("��Ҫȡ��");
	    }
	};
	t.process();
    }
}
