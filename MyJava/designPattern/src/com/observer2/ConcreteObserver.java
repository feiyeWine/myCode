package com.observer2;

import java.util.Observable;

public class ConcreteObserver extends Observable{
    private int state;
    public void set(int state){
	this.state = state;
	setChanged();
	notifyObservers(this.state);//֪ͨ���й۲���
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
}
