package com.adapter;
/**
 * 对象适配器，通过组合方式
 * @author YR
 *
 */
public class Adapter2  implements Target{
    private Adaptee adaptee;
    @Override
    public void handleRequest() {
	this.adaptee.request();
    }
    public Adapter2(Adaptee adaptee){
	this.adaptee = adaptee;
    }
}
