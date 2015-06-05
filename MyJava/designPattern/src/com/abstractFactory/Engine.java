package com.abstractFactory;

public interface Engine {
    void run();
}

class LuxuryEngine implements Engine{

    @Override
    public void run() {
	System.out.println("good engine");
    }
    
}
class LowEngine implements Engine{

    @Override
    public void run() {
	System.out.println("low engine");
    }
}
