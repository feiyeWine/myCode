package com.strategy;

public class NewMany implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("�¿ͻ����������������");
	return standardPrice*0.9;
    }
    
}
