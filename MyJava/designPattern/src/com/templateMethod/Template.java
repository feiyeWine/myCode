package com.templateMethod;

public abstract class Template {
    public void takeNumber(){
	System.out.println("排队取号");
    }
    public abstract void transact();
    
    public void evaluate(){
	System.out.println("打分评价");
    }
    
    public final void process(){
	takeNumber();
	transact();
	evaluate();
    }
}
