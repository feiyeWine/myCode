package com.adapter;

public class Client {
    public static void main(String[] args) {
	Client c = new Client();
	//Target t = new Adapter();
	Adaptee a = new Adaptee();
	Adapter2 adapter= new Adapter2(a);
	c.test(adapter);
    }
    public void test(Target t){
	t.handleRequest();
    }
}
