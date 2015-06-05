package com.builder;

public class MyAirshipDirector implements AirshipDirector{
    
    private AirshipBuilder builder;
    public MyAirshipDirector(AirshipBuilder builder) {
	this.builder = builder;
    }

    @Override
    public Airship createAirship() {
	MyAirshipBuilder builder = new MyAirshipBuilder();
	
	Engine engine = builder.builderEngine();
	OrbitalModule  orbitalModule = builder.builderOrbitalModule();
	EscapePod escapePod = builder.builderEscapePod();
	
	Airship ship = new Airship(engine, orbitalModule, escapePod);
	return ship;
    }

}
