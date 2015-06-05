package com.builder;

public class MyAirshipBuilder implements AirshipBuilder{

    @Override
    public Engine builderEngine() {
	System.out.println("我的发动机");
	return new Engine("我的发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
	System.out.println("我的轨道舱");
	return new OrbitalModule("我的轨道舱");
    }

    @Override
    public EscapePod builderEscapePod() {
	System.out.println("我的逃逸仓");
	return new EscapePod("我的逃逸仓");
    }

}
