package com.strategy;

public class OldMany implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("�Ͽͻ����������������");
	return standardPrice*0.8;
    }
    
}
