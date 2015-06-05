package com.builder;

public class Airship {
    private Engine engine;
    private OrbitalModule orbitalModule;
    private EscapePod escapePod;
    public Airship(Engine engine, OrbitalModule orbitalModule,
	    EscapePod escapePod) {
	super();
	this.engine = engine;
	this.orbitalModule = orbitalModule;
	this.escapePod = escapePod;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }
    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }
    public EscapePod getEscapePod() {
        return escapePod;
    }
    public void setEscapePod(EscapePod escapePod) {
        this.escapePod = escapePod;
    }
    
}
class Engine{
    private String name;
    public Engine(String name) {
	super();
	this.name = name;
    }
}
class  OrbitalModule{
    private String name;
    public OrbitalModule(String name){
	super();
	this.name = name;
    }
}

class EscapePod{
    private String name;
    public EscapePod(String name){
	this.name = name;
    }
}