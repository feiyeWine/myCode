package com.adapter;
/**
 * ÀàÊÊÅäÆ÷
 * @author YR
 *
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void handleRequest() {
	super.request();
    }

}
