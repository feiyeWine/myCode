package com.templateMethod;

public abstract class Template {
    public void takeNumber(){
	System.out.println("�Ŷ�ȡ��");
    }
    public abstract void transact();
    
    public void evaluate(){
	System.out.println("�������");
    }
    
    public final void process(){
	takeNumber();
	transact();
	evaluate();
    }
}
