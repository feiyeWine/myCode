package com.strategy;

public class NewFew implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("�¿ͻ���С������ԭ��");
	return standardPrice;
    }
    
}
