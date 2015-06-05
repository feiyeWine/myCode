package com.abstractFactory;

public interface Tyre {
    void run();
}
class LuxuryTyre implements Tyre{

    @Override
    public void run() {
	System.out.println("ºÃÂÖÌ¥");
    }
    
}
class LowTyre implements Tyre{

    @Override
    public void run() {
	System.out.println("²îÂÖÌ¥");
    }
    
}