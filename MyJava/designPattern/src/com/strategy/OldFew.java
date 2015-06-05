package com.strategy;

public class OldFew implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("老客户，小批量！打九折");
	return standardPrice*0.9;
    }
    
}
