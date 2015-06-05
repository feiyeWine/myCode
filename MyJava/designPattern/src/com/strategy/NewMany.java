package com.strategy;

public class NewMany implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("新客户，大批量！打九折");
	return standardPrice*0.9;
    }
    
}
