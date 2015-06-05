package com.factory;

public class Test {
    public static void main(String[] args) {
	/*HairInterface left = new LeftHair();
	left.draw();*/
	HairFactory hair = new HairFactory();
	hair.getHair("left").draw();
    }
}
