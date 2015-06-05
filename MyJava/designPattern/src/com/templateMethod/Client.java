package com.templateMethod;

public class Client {
    public static void main(String[] args) {
	//通常使用内部类
	Template t = new Template() {
	    
	    @Override
	    public void transact() {
		System.out.println("我要取款");
	    }
	};
	t.process();
    }
}
