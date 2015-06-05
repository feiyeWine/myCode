package com.abstractFactory;

public interface CarFactory {
    Engine createEngine();
    Tyre createTyre();
}
class LuxuryCar implements CarFactory{

    @Override
    public Engine createEngine() {
	return new LuxuryEngine();
    }

    @Override
    public Tyre createTyre() {
	return new LuxuryTyre();
    }

}
class LowCar implements CarFactory{
    @Override
    public Engine createEngine() {
	return new LowEngine();
    }

    @Override
    public Tyre createTyre() {
	return new LowTyre();
    }

}
