package com.strategy;

public class Context {
    private Strategy stragegy ;
    
    public Context(Strategy stragegy) {
	super();
	this.stragegy = stragegy;
    }
    
    public Strategy getStragegy() {
        return stragegy;
    }

    public void setStragegy(Strategy stragegy) {
        this.stragegy = stragegy;
    }

    public void printPrice(double s){
	System.out.println("应该报价："+stragegy.getPrice(s));
    }
    
    
}
