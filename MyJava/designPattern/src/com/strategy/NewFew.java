package com.strategy;

public class NewFew implements Strategy{

    @Override
    public double getPrice(double standardPrice) {
	System.out.println("新客户，小批量！原价");
	return standardPrice;
    }
    
}
