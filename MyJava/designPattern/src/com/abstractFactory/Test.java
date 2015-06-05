package com.abstractFactory;

public class Test {
    public static void main(String[] args) {
	CarFactory car = new LuxuryCar();
	car.createEngine().run();
	
    }
}
