package com.strategy;

public class OldFew implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("�Ͽͻ���С�����������");
	return standardPrice*0.9;
    }
    
}
