package com.state;

public class HomeContext {
    private State state;
    public void setState(State state){
	System.out.println("ÐÞ¸Ä×´Ì¬");
	this.state = state;
	state.handle();
    }
}
