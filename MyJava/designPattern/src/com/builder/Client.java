package com.builder;

public class Client {
    public static void main(String[] args) {
	AirshipDirector director = new MyAirshipDirector(new MyAirshipBuilder());
	Airship ship = director.createAirship();
	System.out.println(ship.getEngine());
    }
}
