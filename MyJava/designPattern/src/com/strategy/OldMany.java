package com.strategy;

public class OldMany implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("老客户，大批量！打八折");
	return standardPrice*0.8;
    }
    
}
