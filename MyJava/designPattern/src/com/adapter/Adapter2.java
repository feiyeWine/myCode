package com.adapter;
/**
 * ������������ͨ����Ϸ�ʽ
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
